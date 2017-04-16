package rentacar.human;

import rentacar.model.Car;

import java.util.Scanner;

/**
 * 消費者
 */
public class Consumer {

    private Car car;

    /**
     * お出かけする
     */
    public void goOut() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("車の操作を番号で選択");
            System.out.println("1:運転  2:給油  3:返却");

            switch (sc.nextInt()) {
                case 1:
                    drive();
                    break;
                case 2:
                    refuel();
                    break;
                case 3:
                    fullRefuel();
                    return;
            }

        } while (true);
    }

    /**
     * 車を借りる
     * @param car
     */
    public void rentalACar(Car car) {
        this.car = car;
    }

    /**
     * 車を返却する
     * @return
     */
    public Car returnCar() {
        Car car = this.car;
        this.car = null;
        return car;
    }

    /**
     * 運転する
     */
    private void drive() {
        // 20km走る
        car.run(20);
    }

    /**
     * 給油する
     */
    private void refuel() {
        // 20L給油
        car.refuel(10);
    }

    /**
     * ガスを満タンに給油する
     */
    private void fullRefuel() {
        car.refuel(car.getMaxFuel());
    }
}
