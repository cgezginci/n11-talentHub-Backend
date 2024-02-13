import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeService {
    private List<Homes> homeList;

    public HomeService(List<Homes> homeList) {
        this.homeList = homeList;
    }

    public void getHouseList() {
        for (Homes home : homeList) {
            if (home.getClass().getSimpleName().equals("House")) {
                System.out.println(
                        "Type: " + home.getClass().getSimpleName() +
                                ", Name: " + home.getName() +
                                ", Price: " + home.getPrice() +
                                ", Square Meters: " + home.getSquareMeters() +
                                ", Room Count: " + home.getNumberOfRooms() +
                                ", Hall Count: " + home.getNumberOfHalls());
                ;
                System.out.println();
            }

        }

    }

    public void getVillaList() {
        for (Homes home : homeList) {
            if (home.getClass().getSimpleName().equals("Villa")) {
                System.out.println(
                        "Type: " + home.getClass().getSimpleName() +
                                ", Name: " + home.getName() +
                                ", Price: " + home.getPrice() +
                                ", Square Meters: " + home.getSquareMeters() +
                                ", Room Count: " + home.getNumberOfRooms() +
                                ", Hall Count: " + home.getNumberOfHalls());
                ;
                System.out.println();
            }
        }

    }

    public void getSummerHouseList() {
        for (Homes home : homeList) {
            if (home.getClass().getSimpleName().equals("SummerHouse")) {
                System.out.println(
                        "Type: " + home.getClass().getSimpleName() +
                        ", Name: " + home.getName() +
                        ", Price: " + home.getPrice() +
                        ", Square Meters: " + home.getSquareMeters() +
                        ", Room Count: " + home.getNumberOfRooms() +
                        ", Hall Count: " + home.getNumberOfHalls());
                        ;
                System.out.println();
            }
        }

    }




    private int calculateTotalPriceByType(Class<? extends Homes> homeType) {
        int total = 0;
        for (Homes home : homeList) {
            if (homeType.isInstance(home)) {
                total += home.getPrice();
            }
        }
        return total;
    }
    public int getTotalPriceOfHouse() {
        return calculateTotalPriceByType(House.class);
    }


    public int getTotalPriceOfVillas() {
        return calculateTotalPriceByType(Villa.class);
    }


    public int getTotalPriceOfSummerHouses() {
        return calculateTotalPriceByType(SummerHouse.class);
    }


    public int getTotalPriceOfAllTypes() {
        return getTotalPriceOfHouse() + getTotalPriceOfVillas() + getTotalPriceOfSummerHouses();
    }


    public double getAverageAreaOfHouse() {
        return calculateAverageAreaByType(House.class);
    }




    public double getAverageAreaOfVillas() {
        return calculateAverageAreaByType(Villa.class);
    }


    public double getAverageAreaOfSummerHouses() {
        return calculateAverageAreaByType(SummerHouse.class);
    }


    public double getAverageAreaOfAllTypes() {
        double totalArea = 0;
        int count = 0;
        for (Homes home : homeList) {
            totalArea += home.getSquareMeters();
            count++;
        }
        double averageArea = count > 0 ? totalArea / count : 0;
        return formatDouble(averageArea);
    }

    private double calculateAverageAreaByType(Class<? extends Homes> homeType) {
        double totalArea = 0;
        int count = 0;
        for (Homes home : homeList) {
            if (homeType.isInstance(home)) {
                totalArea += home.getSquareMeters();
                count++;
            }
        }
        double averageArea = count > 0 ? totalArea / count : 0;
        return formatDouble(averageArea);
    }
    private double formatDouble(double value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        return Double.parseDouble(df.format(value));
    }


    public List<Homes> filterHomesByRoomAndHallCount(int roomCount, int hallCount) {
        List<Homes> filteredHomes = new ArrayList<>();
        for (Homes home : homeList) {
            if (home.getNumberOfRooms() == roomCount && home.getNumberOfHalls() == hallCount) {
                filteredHomes.add(home);
            }
        }
        return filteredHomes;
    }
}
