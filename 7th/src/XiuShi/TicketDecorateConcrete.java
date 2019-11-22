package XiuShi;

public class TicketDecorateConcrete extends TicketDecorate{

    public TicketDecorateConcrete(Component component) {
        super(component);
    }

    public void printTicket() {
        addHeader();
        super.printTicket();
        addFooter();
    }

    void addHeader() {
        Header header = new Header();
        header.printTicket();
    }
    void addFooter() {
        Footer footer = new Footer();
        footer.printTicket();

    }
}
