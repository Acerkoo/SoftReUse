package XiuShi;

public class Footer implements Component{

    @Override
    public void printTicket() {
        printFooter();
    }

    void printFooter() {
        System.out.println("--------------------");
        System.out.println("谢谢惠顾");
    }
}
