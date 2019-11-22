package Observer;

public class MSM implements ITicketObserver {
    @Override
    public void onBuyTicket() {
        System.out.println("MSM");
    }
}
