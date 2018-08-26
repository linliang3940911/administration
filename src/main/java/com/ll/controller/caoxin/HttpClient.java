package com.ll.controller.caoxin;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
public class HttpClient {

    // 创建默认的httpClient实例.
    static CloseableHttpClient client = null;

    static {
        client = HttpClients.createDefault();
    }

    /**
     * <pre>get(创建get方法)
     * 创建人：因蓉儿
     * 创建时间：2018年6月19日 下午2:14:27
     * 修改人：因蓉儿
     * 修改时间：2018年6月19日 下午2:14:27
     * 修改备注：
     * @param url
     * @param params
     * @return</pre>
     */
    public static String get(String url,HashMap<String, Object> params){
        try {
            //创建get方法的实例
            HttpGet httpGet = new HttpGet();
            Set<String> keySet = params.keySet();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(url).append("?t=").append(System.currentTimeMillis());
            for (String key : keySet) {
                stringBuffer.append("&").append(key).append("=").append(params.get(key));
            }
            httpGet.setURI(new URI(stringBuffer.toString()));
            CloseableHttpResponse execute = client.execute(httpGet);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (200 != statusCode) {
                return "";
            }
            return EntityUtils.toString(execute.getEntity(), "UTF-8");
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String post(String url,HashMap<String, Object> params) {
        try {
            //创建post方法的实例
            HttpPost httpPost = new HttpPost();
            httpPost.setURI(new URI(url));
            // 创建参数队列
            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                NameValuePair e = new BasicNameValuePair(key, params.get(key).toString());
                parameters.add(e);
            }
            HttpEntity entity = new UrlEncodedFormEntity(parameters);


            httpPost.setEntity(entity);
            CloseableHttpResponse execute = client.execute(httpPost);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (200 != statusCode) {
                return "";
            }
            return EntityUtils.toString(execute.getEntity(), "UTF-8");
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

		/*public static void main(String[] args) {
			HashMap<String, Object> params = new HashMap<String, Object>();
			//params.put("city", "原平");
			String string = get("https://www.baidu.com", params);
			System.out.println(string);

		}*/
}
