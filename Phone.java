class Phone extends Device {
    @Override
    Phone getDevice() {
        System.out.println("This is a phone");
        return this;
    }
}

