import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote, Serializable {
    public String sayHello() throws RemoteException;
}
