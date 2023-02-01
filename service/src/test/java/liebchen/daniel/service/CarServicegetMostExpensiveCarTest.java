package liebchen.daniel.service;
import liebchen.daniel.service.extensions.CarsServiceExtension;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import java.util.List;

import static liebchen.daniel.service.extensions.CarsFactory.audi;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(CarsServiceExtension.class)
@RequiredArgsConstructor
public class CarServicegetMostExpensiveCarTest {


    private final CarService carService;


    @Test
    @DisplayName("should return collection of most expensice car")
    public void test1(){

        var expectedMostExpensiveCars = List.of(audi);
        var mostExpensiveCars = carService.getMostExpensiveCar();
        assertThat(mostExpensiveCars).isEqualTo(expectedMostExpensiveCars);
    }

}
