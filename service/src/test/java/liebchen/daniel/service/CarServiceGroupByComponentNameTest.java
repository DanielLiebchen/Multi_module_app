package liebchen.daniel.service;

import liebchen.daniel.service.extensions.CarsServiceExtension;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.LinkedHashMap;
import java.util.List;

import static liebchen.daniel.service.extensions.CarsFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(CarsServiceExtension.class)
@RequiredArgsConstructor
public class CarServiceGroupByComponentNameTest {
    private final CarService carService;

    @Test
    @DisplayName("should return map of grouped by Components")
    public void test1(){
        var expectedCarsGroupedByComponent = new LinkedHashMap<>();
        expectedCarsGroupedByComponent.put("1", List.of(skoda1,skoda2,audi,fiat));
        expectedCarsGroupedByComponent.put("2", List.of(audi,fiat));
        expectedCarsGroupedByComponent.put("3", List.of(skoda1,fiat,bmw));
        expectedCarsGroupedByComponent.put("4", List.of(skoda1));
        expectedCarsGroupedByComponent.put("5", List.of(skoda1));
        expectedCarsGroupedByComponent.put("6", List.of(skoda1));
        expectedCarsGroupedByComponent.put("7", List.of(skoda1,skoda2,audi));
        expectedCarsGroupedByComponent.put("8", List.of(skoda2,toyota,audi,fiat));
        expectedCarsGroupedByComponent.put("9", List.of(skoda1,skoda2,toyota,fiat,bmw));

        var carsGroupedByComponent = carService.groupByComponentName();
        assertThat(carsGroupedByComponent).isEqualTo(expectedCarsGroupedByComponent);
    }
}
