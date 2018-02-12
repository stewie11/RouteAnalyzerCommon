package com.routecommon.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	private static PoolingHttpClientConnectionManager cm;
	private static CloseableHttpClient httpClient;
	static{
		  //1.获得一个httpclient对象
    	ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
		LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", plainsf)
				.register("https", sslsf)
				.build();

		cm = new PoolingHttpClientConnectionManager(registry);
		// 将最大连接数增加到200
		cm.setMaxTotal(200);
		// 将每个路由基础的连接增加到20
		cm.setDefaultMaxPerRoute(20);
		httpClient = HttpClients.custom().setConnectionManager(cm).build();
	}

	public static String sendGet(String url) throws Exception {
    	HttpGet httpget = new HttpGet(url);
    	CloseableHttpResponse response = null;
    	String result = null;
    	try {
			response = httpClient.execute(httpget,HttpClientContext.create());  
			if(response.getStatusLine().getStatusCode() != 200) {
				throw new Exception("Invalid response code : "+response.getStatusLine().getStatusCode());
			}
			HttpEntity entity = response.getEntity();
			if (entity != null ) {
				result = EntityUtils.toString(entity, "utf-8");//result = EntityUtils.toString(entity);
            } else {
        		throw new Exception("Invalid entity empty");
            }
	        EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(response != null)response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	return result;
    }
}
//ScriptEngineEngine engine = manager.getEngineByName("javascript");
//try{    
//	engine.put("a", 4);   
//	engine.put("b", 3);   
//	Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE); 
//	Double result = (Double) engine.eval("a+b");       
//
//	SystManager manager = new ScriptEngineManager();
//Scriptem.out.println("result = " + result);    
//	engine.eval("c=a+b");    
//
//	Double c = (Double)engine.get("c");    
//
//	System.out.println("c = " + c);   
////	Double result = (Double)engine.eval("var a=3; var b=4;print (a+b);");
////	System.out.println(result);
//	// engine.eval("alert(\"js alert\");");    // 不能调用浏览器中定义的js函数 // 错误，会抛出alert引用不存在的异常
//}
//catch(ScriptException e)
//{
//	e.printStackTrace();
//}
