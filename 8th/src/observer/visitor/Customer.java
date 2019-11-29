package observer.visitor;

import observer.market.Apple;
import observer.market.Beer;

public class Customer implements Visitor {
    @Override
    public void visit(Apple apple) {
        System.out.println( "Customer visit Apple!");
    }
    @Override
    public void visit(Beer beer) {
        System.out.println("Customer visit Beer!");
    }
}
