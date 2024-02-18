public class Homes {
    private int price;
    private int squareMeters;
    private int numberOfRooms;
    private int numberOfHalls;

    private String name;

    public Homes(int price, int squareMeters, int numberOfRooms, int numberOfHalls, String name) {
        this.price = price;
        this.squareMeters = squareMeters;
        this.numberOfRooms = numberOfRooms;
        this.numberOfHalls = numberOfHalls;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfHalls() {
        return numberOfHalls;
    }

    public String getName() {
        return name;
    }
}
