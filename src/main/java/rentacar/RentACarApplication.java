package rentacar;

import rentacar.car.ElectricVehicle;
import rentacar.consumer.Consumer;
import rentacar.car.AutoMobile;
import rentacar.car.Car;
import rentacar.shop.RentalCarShop;

import java.util.HashMap;
import java.util.Map;

/**
 * レンタカー
 */
public class RentACarApplication {

    public static void main(String... args) {

        Consumer consumer = new Consumer();
        RentalCarShop rentalCarShop = new RentalCarShop(new RentACarApplication().init());
        rentalCarShop.executeRental(consumer);
        consumer.goOut();
        rentalCarShop.executeRetrun(consumer);
    }

    public Map<String, Car> init() {
        Car car1 = new AutoMobile("インプレッサ", 60, 8);
        Car car2 = new AutoMobile("Fitハイブリッド", 40, 20);
        Car car3 = new ElectricVehicle("リーフ", 30, 6);

        Map<String, Car> carMap = new HashMap<>();
        carMap.put(car1.getName(), car1);
        carMap.put(car2.getName(), car2);
        carMap.put(car3.getName(), car3);
        return carMap;
    }
}
