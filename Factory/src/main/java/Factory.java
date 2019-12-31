import Test.InterfaceTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Factory {
    private static Properties pro = new Properties();

    static {
        try {
            pro.load(new FileInputStream("src/main/java/file.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Factory factory = new Factory();

    private Factory() {
    }

    public static Factory getFactory() {
        return factory;
    }

    public InterfaceTest getInterface() {
        InterfaceTest interfaceTest = null;

        try {
            String classInfo = pro.getProperty("test");
            Class c = Class.forName(classInfo);
            Object obj = c.newInstance();
            interfaceTest = (InterfaceTest) obj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return interfaceTest;
    }
}
