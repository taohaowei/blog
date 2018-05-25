package util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 14978 on 2017/9/5.
 */

public class UpdateViewIp {


    public static String GetJsonByIp(String ip)
    {
        String urlAdre = "http://apis.juhe.cn/ip/ip2addr?ip="+ip+"&dtype=&key=e7caf7e63c9af0196b10de9344cbcebe";
        try {
            URL url = new URL(urlAdre);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String src = null;
            while((src=br.readLine())!=null)
            {
                sb.append(src);
            }
            System.out.println(sb.toString());
            JSONObject objects = JSONArray.parseObject(sb.toString());
            urlAdre = objects.get("result").toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return urlAdre;
    }

}
