import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloServer {
    public static void main(String []args) {
        try {
            LocateRegistry.createRegistry(1099);
            HelloImpl service = new HelloImpl("Hello World!");
            Naming.rebind("Hello", service);
            System.out.println("Hello Server is ready...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
