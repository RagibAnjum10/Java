import java.util.Random;

public class Droid {
    private int batteryLevel;
    private String name;
    private boolean isAlive;
    private int age;

    public Droid(String droidName) {
        name = droidName;
        batteryLevel = 100;
        isAlive = true;
        age = 0;
    }

    public void rechargeBattery(int amount) {
        if (amount < 0) {
            System.out.println(name + " cannot recharge with a negative amount.");
            return;
        }

        batteryLevel += amount;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }

        System.out.println(name + " recharged the battery by " + amount + " units. Battery level: " + batteryLevel);
    }

    public void performTask(String task) {
        if (!isAlive) {
            System.out.println(name + " is out of power and cannot perform tasks.");
            return;
        }

        if (batteryLevel < 10) {
            System.out.println(name + " is too low on power to perform tasks. Recharge first!");
            return;
        }

        Random rand = new Random();
        int taskEnergy = rand.nextInt(11); // Random energy consumption between 0 and 10.

        batteryLevel -= taskEnergy;
        age++;

        System.out.println(name + " is performing task: " + task);
        System.out.println("Battery level after the task: " + batteryLevel);
        System.out.println(name + "'s age: " + age);

        if (batteryLevel <= 0) {
            isAlive = false;
            System.out.println(name + " ran out of power and is now inactive.");
        }
    }

    public void energyReport() {
        System.out.println("The battery level is " + batteryLevel);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public static void main(String[] args) {
        Droid codey = new Droid("Codey");
        System.out.println(codey);

        codey.performTask("coding");
        codey.performTask("cleaning");
        codey.performTask("exploring");

        codey.rechargeBattery(50);
        codey.performTask("playing");

        while (codey.isAlive()) {
            codey.performTask("working");
        }

        codey.energyReport();
    }

    public String toString() {
        return "Hello, I'm the droid: " + name;
    }
}
