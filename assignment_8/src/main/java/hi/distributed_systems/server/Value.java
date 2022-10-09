package hi.distributed_systems.server;

public class Value {
    private int value = 0;

    public void setToZero() {
        this.value = 0;
        System.out.println("Setting value to 0");
    }

    public void setToFortyTwo() {
        this.setValue(42);
    }

    public int getValue() {
        System.out.println("Getter: value is " + this.value);
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
        System.out.println("Setting value to " + value);
    }
}
