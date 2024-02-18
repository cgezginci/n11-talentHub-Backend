import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Homes> homeList = new ArrayList<>();
        homeList.add(new House(100000, 100, 3, 1 , "Small House "));
        homeList.add(new House(150000, 120, 5, 1 , "Standard House "));
        homeList.add(new House(200000, 150, 6, 2 , "Big House "));

        homeList.add(new Villa(300000, 200, 4, 2 , "Small Villa"));
        homeList.add(new Villa(400000, 250, 7, 3    , "Standard Villa"));
        homeList.add(new Villa(500000, 300, 7, 3   , "Big Villa"));

        homeList.add(new SummerHouse(80000, 80, 3, 1 , "Small Summer House"));
        homeList.add(new SummerHouse(100000, 100, 4, 2 , "Standard Summer House"));
        homeList.add(new SummerHouse(120000, 120, 5, 2 , "Big Summer House"));

        HomeService homeService = new HomeService(homeList);



        homeService.getHouseList();
        homeService.getVillaList();
        homeService.getSummerHouseList();
        System.out.println("-----------------------------------");
        System.out.println("Total price of all houses: " + homeService.getTotalPriceOfHouse());
        System.out.println("Total price of all villas: " + homeService.getTotalPriceOfVillas());
        System.out.println("Total price of all summer houses: " + homeService.getTotalPriceOfSummerHouses());
        System.out.println("Total price of all types of homes: " + homeService.getTotalPriceOfAllTypes());
        System.out.println("-----------------------------------");

        System.out.println("Average area of all houses: " + homeService.getAverageAreaOfHouse());
        System.out.println("Average area of all villas: " + homeService.getAverageAreaOfVillas());
        System.out.println("Average area of all summer houses: " + homeService.getAverageAreaOfSummerHouses());
        System.out.println("Average area of all types of homes: " + homeService.getAverageAreaOfAllTypes());
        System.out.println("-----------------------------------");

        int roomCount = 3;
        int hallCount = 1;
        List<Homes> filteredHomes = homeService.filterHomesByRoomAndHallCount(roomCount, hallCount);
        System.out.println("Homes with " + roomCount + " rooms and " + hallCount + " halls:");
        if (filteredHomes.isEmpty()) {
            System.out.println("No homes found");
        }else {
            for (Homes home : filteredHomes) {
                System.out.println("Name: " + home.getName());
            }
        }

    }
}
