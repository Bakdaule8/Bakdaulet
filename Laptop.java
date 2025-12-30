class Laptop extends Device {
    @Override
    Laptop getDevice() {
        System.out.println("This is a laptop");
        return this;
    }
}
