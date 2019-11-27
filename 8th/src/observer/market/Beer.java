package observer.market;

import observer.visitor.Visitor;

public class Beer extends Product{
    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getName() + " visit Beer!!");
    }

    public void operationB() {
        System.out.println("operationB");
    }
}
