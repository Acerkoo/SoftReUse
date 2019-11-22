package Observer;

public class Discount implements ITicketObserver {
    @Override
    public void onBuyTicket() {
        System.out.println("Discount");
    }
}
