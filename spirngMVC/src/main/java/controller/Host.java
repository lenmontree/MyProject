package controller;

public class Host implements Rent {

    private String hostName;

    public Host(String hostName){
        this.hostName = hostName;
    }
    public void rent() {
        System.out.println("房东{" + hostName + "}出租房子");
    }
}
