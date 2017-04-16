package rentacar;

import rentacar.human.Consumer;
import rentacar.model.AutoMobile;
import rentacar.model.Car;
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
        Car autoMobile1 = new AutoMobile("インプレッサ", 60, 8);
        Car autoMobile2 = new AutoMobile("Fitハイブリッド", 40, 20);

        Map<String, Car> carMap = new HashMap<>();
        carMap.put(autoMobile1.getName(), autoMobile1);
        carMap.put(autoMobile2.getName(), autoMobile2);
        return carMap;
    }
}
