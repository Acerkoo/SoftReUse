package observer.visitor;

import observer.market.Apple;
import observer.market.Beer;

public class Customer implements Visitor {
    @Override
    public void visit(Apple apple) {
        apple.accept(this);
    }
    @Override
    public void visit(Beer beer) {
        beer.accept(this);
    }
}
