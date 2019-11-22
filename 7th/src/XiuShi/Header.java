package XiuShi;

public class Header implements Component{

    @Override
    public void printTicket() {
        printHeader();
    }

    void printHeader() {
        System.out.println("欢迎光临！！");
        System.out.println("--------------------");
    }
}
