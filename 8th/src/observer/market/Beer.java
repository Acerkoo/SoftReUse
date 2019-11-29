package observer.market;

import observer.visitor.Visitor;

public class Beer extends Product{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationB() {
        System.out.println("operationB");
    }
}
