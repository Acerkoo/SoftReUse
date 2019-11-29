package observer.market;

import observer.visitor.Visitor;

public class Apple extends Product{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public void operationA() {
        System.out.println("operationA");
    }
}
