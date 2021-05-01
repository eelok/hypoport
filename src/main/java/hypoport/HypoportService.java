package hypoport;

import java.io.IOException;
import java.util.Comparator;

public class HypoportService {

    private HypoportRepository hypoportRepository;

    public HypoportService(HypoportRepository hypoportRepository) {
        this.hypoportRepository = hypoportRepository;
    }

    public long findDayWithLowestRate() throws IOException {
        return this.hypoportRepository.getPriceList().stream()
                .filter(price -> price.getLow() != null)
                .min(Comparator.comparingDouble(Price::getLow))
                .map(Price::getDate)
                .orElse(0L);
    }

    public long findDayWithHighestRate() throws IOException {
        return this.hypoportRepository.getPriceList().stream()
                .filter(price -> price.getHigh() != null)
                .max(Comparator.comparingDouble(Price::getHigh))
                .map(Price::getDate)
                .orElse(0L);
    }

    public double findAverageClosingRate() throws IOException {
        return this.hypoportRepository.getPriceList().stream()
                .filter(price -> price.getClose() != null)
                .mapToDouble(Price::getClose)
                .average()
                .orElse(0d);
    }


    public long findDayWithHighestDiffBetweenOpenAndCloseRate() throws IOException {
        return this.hypoportRepository.getPriceList()
                .stream()
                .filter(price -> price.getOpen() != null && price.getClose() != null)
                .map(price -> new PriceDiff(price.getDate(), Math.abs(price.getOpen() - price.getClose())))
                .max(Comparator.comparingDouble(PriceDiff::getOpenCloseDiff))
                .map(PriceDiff::getDate)
                .orElse(0L);
    }
}
