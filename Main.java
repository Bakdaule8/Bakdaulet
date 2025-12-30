public class Main {
    public static void main(String[] args) {

        Device d1 = new Phone();
        Device d2 = new Laptop();

        d1.getDevice(); // This is a phone
        d2.getDevice(); // This is a laptop


        Phone p = new Phone().getDevice();
        Laptop l = new Laptop().getDevice();
    }
}
