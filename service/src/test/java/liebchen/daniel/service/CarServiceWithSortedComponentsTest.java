package liebchen.daniel.service;

import liebchen.daniel.service.extensions.CarsServiceExtension;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static liebchen.daniel.service.extensions.CarsFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(CarsServiceExtension.class)
@RequiredArgsConstructor
public class CarServiceWithSortedComponentsTest {
    private final CarService carService;

    @Test
    @DisplayName("should return correct colection of cars with sorted components")
    public void test1(){

        var expectedCarsWithSortedComponents = List.of(

                skoda1SotredComponents,
                skoda2SotredComponents,
                toyotaSotredComponents,
                audiSotredComponents,
                fiatSotredComponents,
                bmwSotredComponents
                );

        var carsWithSortedComponents = carService.withSortedComponents();
        assertThat(carsWithSortedComponents).isEqualTo(expectedCarsWithSortedComponents);

    }



}
