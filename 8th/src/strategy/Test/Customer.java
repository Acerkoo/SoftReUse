package strategy.Test;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Customer {
    public static void main(String []argc) {
        FileSystemXmlApplicationContext fsml = new FileSystemXmlApplicationContext("src/strategy/pom.xml");
        Sale sale = (Sale)fsml.getBeanFactory().getBean("Sale");
        System.out.println("花费：" + sale.getTotalPrice());
    }
}
