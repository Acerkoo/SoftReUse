package observer.visitor;

import observer.market.Apple;
import observer.market.Beer;

public class Cashier implements Visitor {
    @Override
    public void visit(Apple apple) {
        System.out.println("Cashier visit Apple!");
    }
    @Override
    public void visit(Beer beer) {
        System.out.println("Cashier visit Beer!");
    }
}
