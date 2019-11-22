package DaiLi;

public class ProxyTest {
    public static void main(String []argc) {
        Proxy proxy = new Proxy();
        proxy.Request();
    }
}

interface Subject {
    public void Request();
}

class RealSubject implements Subject {

    @Override
    public void Request() {
        System.out.println("验证身份");
    }
}

class Proxy implements Subject {

    private RealSubject realSubject = null;

    public Proxy(){}
    public Proxy(RealSubject realSubject) { this.realSubject = realSubject; }

    @Override
    public void Request() {
        if(realSubject == null) realSubject = new RealSubject();
        preRequest();
        realSubject.Request();
        postRequest();
    }

    void preRequest() {
        System.out.println("preRequest");
    }

    void postRequest() {
        System.out.println("postRequest");
    }
}
