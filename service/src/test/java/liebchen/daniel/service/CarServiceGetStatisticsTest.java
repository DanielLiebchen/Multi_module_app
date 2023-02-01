package liebchen.daniel.service;


import liebchen.daniel.service.extensions.CarServiceException;
import liebchen.daniel.service.extensions.CarsServiceExtension;
import liebchen.daniel.service.type.Statistics;
import liebchen.daniel.service.type.StatisticsType;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(CarsServiceExtension.class)
@RequiredArgsConstructor
public class CarServiceGetStatisticsTest {

    private final CarService carService;
    @Test
    @DisplayName("should throw exception when statistics type is null")
    public void test1() {
        assertThatThrownBy(() -> carService.getStatistics(null))
                .isInstanceOf(CarServiceException.class)
                .hasMessage("Statistics type is null");
    }


    @Test
    @DisplayName("should return correct statistics for price ")
    public void test2() {
        var expectedStatistics = Statistics
                .<BigDecimal>builder()
                .min(BigDecimal.valueOf(100))
                .average(BigDecimal.valueOf(400))
                .max(BigDecimal.valueOf(760))
                .build();

        var priceStatistics = carService.getStatistics(StatisticsType.PRICE);

        assertThat(priceStatistics).isEqualTo(expectedStatistics);
    }

    @Test
    @DisplayName("should return correct statistics for mileage ")
    public void test3() {
        var expectedStatistics = Statistics
                .<Double>builder()
                .min(10.0)
                .average(8800.0)
                .max(30000.0)
                .build();

        var priceStatistics = carService.getStatistics(StatisticsType.MILEAGE);

        assertThat(priceStatistics).isEqualTo(expectedStatistics);
    }
}
