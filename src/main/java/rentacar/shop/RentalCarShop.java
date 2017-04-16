package rentacar.shop;

import rentacar.consumer.Consumer;
import rentacar.car.Car;

import java.util.*;

/**
 * レンタカー屋さん
 */
public class RentalCarShop {

    private static Map<Rental, Map<String, Car>> cars = new HashMap<>();

    public RentalCarShop(Map<String, Car> cars) {
        RentalCarShop.cars.put(Rental.Available, cars);
        RentalCarShop.cars.put(Rental.Unavailable, new HashMap<>());
    }

    /**
     * 貸出業務を行う
     * @param consumer
     */
    public void executeRental(Consumer consumer) {

        System.out.println("店員のワイズちゃん「いらっしゃいませ、ワイズレンタカーです。」");

        String answer;
        String carName;
        Scanner sc = new Scanner(System.in);
        do {

            do {
                System.out.println("店員のワイズちゃん「車種を選んで車名を入力してください。」");
                showAvailables();
                carName = sc.next();
            } while (!hasCars(carName));

            System.out.println("店員のワイズちゃん「" + carName + "でよろしいですか？（y/n）」");
            answer = sc.next();
        } while (!answer.equals("y"));

        // 貸出処理
        Car car = lendCar(carName);
        System.out.println("店員のワイズちゃん「貸出処理が完了しました。」");
        showAvailables();
        showUnavailables();
        consumer.rentalACar(car);
    }

    /**
     * 返却業務を行う
     * @param consumer
     */
    public void executeRetrun(Consumer consumer) {
        Car car = consumer.returnCar();
        returnCar(car);
        System.out.println("店員のワイズちゃん「返却処理が完了しました。」");

        showAvailables();
        showUnavailables();

        System.out.println("店員のワイズちゃん「またのご利用をお待ちしております。」");
    }

    /**
     * 貸出可能か確認
     * @param carName
     * @return
     */
    private boolean hasCars(String carName) {

        return cars.get(Rental.Available)
                .entrySet()
                .stream()
                .filter(car -> car.getValue().getName().equals(carName))
                .count() == 1;
    }

    /**
     * 貸出し処理
     * @param carName
     */
    private Car lendCar(String carName) {

        Car car = cars.get(Rental.Available)
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getName().equals(carName))
                .findFirst()
                .orElseGet(() -> null)
                .getValue();

        cars.get(Rental.Available).remove(carName);
        cars.get(Rental.Unavailable).put(carName, car);
        return car;
    }

    /**
     * 返却処理
     * @param car
     */
    private void returnCar(Car car) {
        cars.get(Rental.Unavailable).remove(car.getName());
        cars.get(Rental.Available).put(car.getName(), car);
    }

    /**
     * 貸出可能な車表示
     */
    private void showAvailables() {
        cars.get(Rental.Available)
                .entrySet()
                .forEach(carEntry -> System.out.println(carEntry.getValue() + "/" + Rental.Available.getName()));
    }

    /**
     * 貸出中の車表示
     */
    private void showUnavailables() {
        cars.get(Rental.Unavailable)
                .entrySet()
                .forEach(carEntry -> System.out.println(carEntry.getValue() + "/" + Rental.Unavailable.getName()));

    }
}
