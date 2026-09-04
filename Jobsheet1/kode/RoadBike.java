package Jobsheet1.kode;

public class RoadBike extends Bike {
    private int tireWidth;

    public void setTireWidth(int width) {
        tireWidth = width;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Tire Wdith  " + tireWidth + " nm");
        System.out.println("Bike Type : Road Bike");
    }
}