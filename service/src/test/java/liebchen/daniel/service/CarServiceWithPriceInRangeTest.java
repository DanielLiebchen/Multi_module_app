package liebchen.daniel.service;
import liebchen.daniel.service.extensions.CarServiceException;
import liebchen.daniel.service.extensions.CarsServiceExtension;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.math.BigDecimal;
import java.util.List;

import static liebchen.daniel.service.extensions.CarsFactory.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(CarsServiceExtension.class)
@RequiredArgsConstructor
public class CarServiceWithPriceInRangeTest {
    private final CarService carService;

    @Test
    @DisplayName("should throw exeption when price from is null")
    public void test1(){
        assertThatThrownBy(() -> carService.withPriceInRange(null, BigDecimal.ONE))
                .isInstanceOf(CarServiceException.class)
                .hasMessage("Price from is null");
    }
    @Test
    @DisplayName("should throw exeption when price to is null")
    public void test2(){
        assertThatThrownBy(() -> carService.withPriceInRange(BigDecimal.ONE, null))
                .isInstanceOf(CarServiceException.class)
                .hasMessage("Price to is null");
    }

    @Test
    @DisplayName("should throw exeption when price from is greater than price to")
    public void test3(){
        assertThatThrownBy(() -> carService.withPriceInRange(BigDecimal.ONE, BigDecimal.ZERO))
                .isInstanceOf(CarServiceException.class)
                .hasMessage("Price from is greater or equal price to");
    }

    @Test
    @DisplayName("should throw exeption when price from is greater than price to")
    public void test4(){
        var priceFor = BigDecimal.valueOf(100);
        var priceTo = BigDecimal.valueOf(230);

        var expectedCars = List.of(skoda1,skoda2,fiat);

        var cars = carService.withPriceInRange(priceFor, priceTo);

        assertThat(cars).isEqualTo(expectedCars);
    }
}
