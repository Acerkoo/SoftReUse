package XiuShi;

public class ClientTest {
    public static void main(String []argc) {
        SalesTicket salesTicket = new SalesTicket();
        TicketDecorateConcrete ticket = new TicketDecorateConcrete(salesTicket);

        ticket.printTicket();
    }
}
