package rentacar.car;

/**
 * 電気自動車
 */
public class ElectricVehicle implements Car{

    // 車名
    private String name;

    // 残バッテリー量(kWh)
    private int fuel;

    // バッテリー最大値(kWh)
    private int maxFuel;

    // 燃費(km/kWh)
    private int fuelConsumption;

    public ElectricVehicle(String name, int fuel, int fuelConsumption) {
        this.name = name;
        this.fuel = fuel;
        this.maxFuel = fuel;
        this.fuelConsumption = fuelConsumption;
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

    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return getName() + "/" + getMaxFuel() + "kWh";
    }

    @Override
    public void run(int km) {

        if (fuel > 0) {
            fuel = Math.round(fuel - (km / fuelConsumption));
            if (fuel <= 0) {
                fuel = 0;
            }
            System.out.println(km + "km 走りました。バッテリーは残り " + fuel + "kWh です。");
        } else {
            System.out.println("バッテリー切れです。給油してください。");
        }
    }

    @Override
    public void refuel(int fuel) {
        if (maxFuel > getFuel()) {
            this.fuel = getFuel() + fuel;
            if (maxFuel <= getFuel()) {
                this.fuel = maxFuel;
            }
            System.out.println("バッテリーは残り " + getFuel() + "kWh です。");
        } else {
            System.out.println("バッテリーはフル充電です。");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getMaxFuel() {
        return this.maxFuel;
    }
}
