package observer;

import observer.market.Apple;
import observer.market.Beer;
import observer.market.BuyBasket;
import observer.market.Product;
import observer.visitor.Cashier;
import observer.visitor.Customer;
import observer.visitor.Visitor;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.swing.plaf.IconUIResource;
import java.util.*;


public class Client {
    public static void main(String []argc) {
        FileSystemXmlApplicationContext fsml = new FileSystemXmlApplicationContext("src/observer/pom.xml");
        Apple apple = (Apple) fsml.getBeanFactory().getBean("Apple");
        Beer beer = (Beer) fsml.getBeanFactory().getBean("Beer");
        BuyBasket buybasket = (BuyBasket) fsml.getBeanFactory().getBean("BuyBasket");

        Visitor customer = (Customer) fsml.getBeanFactory().getBean("Customer");
        Visitor cashier = (Cashier) fsml.getBeanFactory().getBean("Cashier");

        customer.visit(apple);
        customer.visit(beer);
        buybasket.accept(customer);

        cashier.visit(apple);
        cashier.visit(beer);
        buybasket.accept(cashier);
    }
}
