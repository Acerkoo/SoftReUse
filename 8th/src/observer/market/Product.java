package observer.market;

import observer.visitor.Visitor;

public abstract class Product {
    public abstract void accept(Visitor visitor);
}
