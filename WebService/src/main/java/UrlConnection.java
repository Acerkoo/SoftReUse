import org.apache.commons.httpclient.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnection {
    public static void cl6(String xml) throws IOException {
        String urlString =  "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather";
        String soapActionString = "getMobileCodeInfo";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        String soap = xml;
        byte []buf = soap.getBytes("UTF-8");
        connection.setRequestProperty("Content-Length", String.valueOf(buf.length));
        connection.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
        connection.setRequestProperty("soapActionString", soapActionString);
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);

        OutputStream out = connection.getOutputStream();
        out.write(buf);
        out.close();

        int code = connection.getResponseCode();
        StringBuffer sb = new StringBuffer();
        InputStream is = connection.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while((len = is.read(b)) != -1) {
            String s = new String (b, 0, len, "utf-8");
            sb.append(s);
        }
        is.close();
        System.out.println(sb);
    }

    public static void main(String []args) throws IOException {
    }
}
