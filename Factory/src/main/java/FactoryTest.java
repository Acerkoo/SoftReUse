import Test.InterfaceTest;

public class FactoryTest {
    public static void main(String []argc) {
        Factory factory = Factory.getFactory();
        InterfaceTest inter = factory.getInterface();
        inter.getName();
    }
}
