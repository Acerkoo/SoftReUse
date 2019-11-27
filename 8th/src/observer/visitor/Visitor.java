package observer.visitor;

import observer.market.Apple;
import observer.market.Beer;

public interface  Visitor {
    public void visit(Apple apple);
    public void visit(Beer beer);
}



