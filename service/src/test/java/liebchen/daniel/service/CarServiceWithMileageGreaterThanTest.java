package liebchen.daniel.service;

import liebchen.daniel.service.extensions.CarServiceException;
import liebchen.daniel.service.extensions.CarsServiceExtension;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static liebchen.daniel.service.extensions.CarsFactory.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(CarsServiceExtension.class)
@RequiredArgsConstructor
public class CarServiceWithMileageGreaterThanTest {
    private final CarService carService;

    @Test
    @DisplayName("should throw exception when mileage is not positive")
    public void test1() {
        assertThatThrownBy(() -> carService.withMileageGreaterThan(0))
                .isInstanceOf(CarServiceException.class)
                .hasMessage("Mileage must have positive value");
    }

//    public void test1(){
//        assertThatThrownBy(() -> carServicer.sortBy(null,true))
//                .isInstanceOf(CarServiceException.class)
//                .hasMessage("SortBy instance is null");
//    }


    @Test
    @DisplayName("should return correct cars collection with expected mileage")
    public void test2() {
        assertThat(carService.withMileageGreaterThan(1000))
                .hasSize(3)
                .contains(audi, fiat, toyota);
    }
}