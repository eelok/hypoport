package hypoport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HypoportServiceTest {

    private HypoportService hypoportService;

    private HypoportRepository hypoportRepository;

    @BeforeEach
    void setUp() {
        hypoportRepository = mock(HypoportRepository.class);
        hypoportService = new HypoportService(hypoportRepository);
    }

    @Test
    void should_find_day_with_lowest_rate() throws IOException {
        Price price1 = mock(Price.class);
        when(price1.getDate()).thenReturn((1210L));
        when(price1.getLow()).thenReturn(300d);

        Price price2 = mock(Price.class);
        when(price2.getDate()).thenReturn((1220L));
        when(price2.getLow()).thenReturn(400d);

        Price price3 = mock(Price.class);
        when(price3.getDate()).thenReturn((1230L));
        when(price3.getLow()).thenReturn(null);
        when(hypoportRepository.getPriceList()).thenReturn(List.of(price1, price2, price3));

        Assertions.assertEquals(price1.getDate(), hypoportService.findDayWithLowestRate());
    }

    @Test
    void should_return_0_when_there_is_no_low_rate() throws IOException {
        when(hypoportRepository.getPriceList()).thenReturn(Collections.emptyList());

        Assertions.assertEquals(0L, hypoportService.findDayWithLowestRate());
    }

    @Test
    void should_find_day_with_highest_rate() throws IOException {
        Price price1 = mock(Price.class);
        when(price1.getDate()).thenReturn((1210L));
        when(price1.getHigh()).thenReturn(null);

        Price price2 = mock(Price.class);
        when(price2.getDate()).thenReturn((1220L));
        when(price2.getHigh()).thenReturn(440d);

        Price price3 = mock(Price.class);
        when(price3.getDate()).thenReturn((1230L));
        when(price3.getHigh()).thenReturn(550d);
        when(hypoportRepository.getPriceList()).thenReturn(List.of(price1, price2, price3));

        Assertions.assertEquals(price3.getDate(), hypoportService.findDayWithHighestRate());
    }

    @Test
    void should_return_0_then_there_is_no_high_rate() throws IOException {
        when(hypoportRepository.getPriceList()).thenReturn(Collections.emptyList());

        Assertions.assertEquals(0L, hypoportService.findDayWithHighestRate());
    }

    @Test
    void should_find_average_closing_rate() throws IOException {
        Price price1 = mock(Price.class);
        when(price1.getClose()).thenReturn(315.60d);

        Price price2 = mock(Price.class);
        when(price2.getClose()).thenReturn(429.8d);

        Price price3 = mock(Price.class);
        when(price3.getClose()).thenReturn(505.01d);

        Price price4 = mock(Price.class);
        when(price4.getClose()).thenReturn(null);

        when(hypoportRepository.getPriceList()).thenReturn(List.of(price1, price2, price3, price4));

        Assertions.assertEquals(416.80, hypoportService.findAverageClosingRate(), 0.01);
    }
    @Test
    void should_return_0_when_there_is_no_close_rate() throws IOException {
        when(hypoportRepository.getPriceList()).thenReturn(Collections.emptyList());

        Assertions.assertEquals(0d, hypoportService.findAverageClosingRate(), 0.01);
    }

    @Test
    void should_find_day_with_highest_diff_between_open_and_close_rate() throws IOException {
        Price price1 = mock(Price.class);
        when(price1.getDate()).thenReturn((1210L));
        when(price1.getOpen()).thenReturn(308.10d);
        when(price1.getClose()).thenReturn(315.60d);

        Price price2 = mock(Price.class);
        when(price2.getDate()).thenReturn((1220L));
        when(price2.getOpen()).thenReturn(415.00d);
        when(price2.getClose()).thenReturn(429.8d);

        Price price3 = mock(Price.class);
        when(price3.getDate()).thenReturn((1230L));
        when(price3.getOpen()).thenReturn(507.00d);
        when(price3.getClose()).thenReturn(505.01d);

        Price price4 = mock(Price.class);
        when(price4.getDate()).thenReturn((1130L));
        when(price4.getOpen()).thenReturn(null);
        when(price4.getClose()).thenReturn(500.01d);

        when(hypoportRepository.getPriceList()).thenReturn(List.of(price1, price2, price3, price4));

        Assertions.assertEquals(price2.getDate(), hypoportService.findDayWithHighestDiffBetweenOpenAndCloseRate());
    }

    @Test
    void should_return_0_when_there_is_no_open_or_close_rate() throws IOException {
        when(hypoportRepository.getPriceList()).thenReturn(Collections.emptyList());

        Assertions.assertEquals(0L, hypoportService.findDayWithHighestDiffBetweenOpenAndCloseRate());
    }

}