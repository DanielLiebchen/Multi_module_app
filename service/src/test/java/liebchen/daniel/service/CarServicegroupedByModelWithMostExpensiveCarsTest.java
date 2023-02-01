package liebchen.daniel.service;

import liebchen.daniel.service.extensions.CarsServiceExtension;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Map;

import static liebchen.daniel.service.extensions.CarsFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(CarsServiceExtension.class)
@RequiredArgsConstructor
public class CarServicegroupedByModelWithMostExpensiveCarsTest {

    private final CarService carServicer;

    @Test
    @DisplayName("should return structure with grouped models and most expensive cars gor each model")
    public void test1(){
        var expectedStructure = Map.of(
            "Skoda", List.of(skoda1),
            "Toyota", List.of(toyota),
            "Audi", List.of(audi),
            "Fiat", List.of(fiat),
            "BMW", List.of(bmw)
        );

        var groupedModelsWithMostExpensiveCars = carServicer.groupedByModelWithMostExpensiveCars();

        assertThat(groupedModelsWithMostExpensiveCars).isEqualTo(expectedStructure);

    }
}
