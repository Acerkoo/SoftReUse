import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface{
    private String message;

    public HelloImpl(String msg) throws RemoteException {
        this.message = msg;
    }

    public String sayHello() throws RemoteException {
        System.out.println("Called by HelloClient");
        return message;
    }
}
