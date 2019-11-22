package Observer;

public class DBLog implements ITicketObserver {
    @Override
    public void onBuyTicket() {
        System.out.println("DBLog");
    }
}
