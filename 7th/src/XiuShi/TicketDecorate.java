package XiuShi;

public abstract class TicketDecorate implements Component{

    private Component component = null;
    public TicketDecorate(Component component) {
        this.component = component;
    }

    @Override
    public void printTicket() {
        component.printTicket();
    }
}
