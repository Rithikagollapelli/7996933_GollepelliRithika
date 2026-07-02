// BuilderPatternExample.java

class Computer {

    private String CPU;
    private String RAM;
    private String Storage;
    private String GraphicsCard;

    // Private Constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.GraphicsCard = builder.GraphicsCard;
    }

    // Display Configuration
    public void showConfiguration() {
        System.out.println("CPU          : " + CPU);
        System.out.println("RAM          : " + RAM);
        System.out.println("Storage      : " + Storage);
        System.out.println("Graphics Card: " + GraphicsCard);
        System.out.println();
    }

    // Static Nested Builder Class
    public static class Builder {

        private String CPU;
        private String RAM;
        private String Storage;
        private String GraphicsCard;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String Storage) {
            this.Storage = Storage;
            return this;
        }

        public Builder setGraphicsCard(String GraphicsCard) {
            this.GraphicsCard = GraphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class Exe3BuilderPatternExample {

    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("512GB SSD")
                .setGraphicsCard("Integrated Graphics")
                .build();

        System.out.println("Gaming PC Configuration:");
        gamingPC.showConfiguration();

        System.out.println("Office PC Configuration:");
        officePC.showConfiguration();
    }
}