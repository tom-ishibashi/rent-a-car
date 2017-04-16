package rentacar.shop;

public enum Rental {
    Available("貸出可"),
    Unavailable("貸出中");

    private String name;

    Rental(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
