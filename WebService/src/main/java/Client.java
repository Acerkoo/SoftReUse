import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.util.Scanner;

public class Client {
    public static void main(String []args) throws IOException {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");

        System.out.print("请输入手机号：");
        Scanner cin = new Scanner(System.in);
        String phone = cin.next();

        post.setParameter("mobileCode", phone);
        post.setParameter("userID", "");

        int code = client.executeMethod(post);

        //System.out.println("结果码：" + code);
        String result = post.getResponseBodyAsString();
        System.out.println("结果：\n" + result);

        post.releaseConnection();
    }
}
