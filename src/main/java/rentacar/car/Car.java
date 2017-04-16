package rentacar.model;

/**
 * 車インターフェース
 */
public interface Car {
    void run(int km);
    void refuel(int fuel);
    String getName();
    int getMaxFuel();
}
