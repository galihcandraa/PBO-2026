package Jobsheet3.Tugas;

public class EncapTest {
    public static void main(String[] args) {
        EncapDemo encap = new EncapDemo();
        encap.setName("James");
        encap.setAge(35);
        EncapDemo encap1 = new EncapDemo();
        encap1.setName("Arthur");
        encap1.setAge(16);

        System.out.println("Name : " + encap.getName());
        System.out.println("Age  : " + encap.getAge());
        System.out.println("Name : " + encap1.getName());
        System.out.println("Age  : " + encap1.getAge());
    }
}
