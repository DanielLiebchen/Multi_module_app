package liebchen.daniel.service;

import liebchen.daniel.persistence.CarUtils;
import liebchen.daniel.service.extensions.CarServiceException;
import liebchen.daniel.service.extensions.CarsServiceExtension;
import liebchen.daniel.service.type.SortBy;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@ExtendWith(CarsServiceExtension.class)
@RequiredArgsConstructor
public class CarServiceSortByTest {
    private final CarService carServicer;

    @Test
    @DisplayName("should throw exception when sortBy instance is null")
    public void test1(){
        assertThatThrownBy(() -> carServicer.sortBy(null,true))
                .isInstanceOf(CarServiceException.class)
                .hasMessage("SortBy instance is null");
    }

    @ParameterizedTest
    @EnumSource(SortBy.class)
    @DisplayName("should return cars sorted by sortBy instance ascending")
    public void test2(SortBy sortBy){

        var sortWithCars = Map.ofEntries(
                Map.entry(SortBy.MODEL,List.of("Audi","BMW", "Fiat","Skoda", "Skoda","Toyota")),
                Map.entry(SortBy.COLOR,List.of("Skoda", "Audi","Skoda","BMW","Toyota","Fiat")),
                Map.entry(SortBy.PRICE,List.of("Skoda","Fiat", "Skoda","Toyota","BMW","Audi")),
                Map.entry(SortBy.MILEAGE,List.of("Skoda", "Skoda","BMW","Toyota","Audi","Fiat"))
        );

        assertThat(carServicer.sortBy(sortBy, true)
                .stream()
                .map(CarUtils.toModel)
                .toList())
                .containsExactlyElementsOf(sortWithCars.get(sortBy));
    }

}
