package rentacar.car;

/**
 * ガソリン車クラス
 */
public class AutoMobile implements Car {

    // 車名
    private String name;

    // 残ガソリン量(L)
    private int fuel;

    // ガソリン最大量(L)
    private int maxFuel;

    // 燃費(km/L)
    private int fuelConsumption;

    public AutoMobile(String name, int fuel, int fuelConsumption) {
        this.name = name;
        this.fuel = fuel;
        this.maxFuel = fuel;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxFuel() {
        return maxFuel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void addGus(int fuel) {
        this.fuel += fuel;
    }

    @Override
    public String toString() {
        return getName() + "/" + getMaxFuel() + "L";
    }

    @Override
    public void run(int km) {

        if (fuel > 0) {
            fuel = Math.round(fuel - (km / fuelConsumption));
            if (fuel <= 0) {
                fuel = 0;
            }
            System.out.println(km + "km 走りました。ガスは残り " + fuel + "L です。");
        } else {
            System.out.println("ガス欠です。給油してください。");
        }
    }

    @Override
    public void refuel(int fuel) {
        if (maxFuel > getFuel()) {
            this.fuel = getFuel() + fuel;
            if (maxFuel <= getFuel()) {
                this.fuel = maxFuel;
            }
            System.out.println("ガスは残り " + getFuel() + "L です。");
        } else {
            System.out.println("ガスは満タンです。");
        }
    }
}
