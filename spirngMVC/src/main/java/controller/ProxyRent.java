package controller;

public class ProxyRent implements Rent{

    private Rent rent;

    public ProxyRent(Rent rent) {
        this.rent = rent;
    }

    public void rent() {
        System.out.println("中介看房子");
        rent.rent();
        System.out.println("中介收费，签合同");
    }

    public void see() {
        System.out.println("中介看房子");
    }

    public void fee() {
        System.out.println("中介收费，签合同");
    }
}
