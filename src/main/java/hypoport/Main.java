package hypoport;

import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        HypoportRepository hypoportRepository = new HypoportRepository();
        HypoportService hypoportService = new HypoportService(hypoportRepository);

        System.out.println("Day with lowest rate:");
        System.out.println(epochToDate(hypoportService.findDayWithLowestRate()));
        System.out.println("**************");
        System.out.println("Day with highest rate:");
        System.out.println(epochToDate(hypoportService.findDayWithHighestRate()));
        System.out.println("**************");
        System.out.println("Day with highest different between open and close rate:");
        System.out.println(epochToDate(hypoportService.findDayWithHighestDiffBetweenOpenAndCloseRate()));
        System.out.println("**************");
        System.out.println("Average closing rate: ");
        System.out.printf("%.2f", hypoportService.findAverageClosingRate());
    }

    private static Date epochToDate(long epochDate) {
        return new Date(epochDate * 1000);
    }
}
