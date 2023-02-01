package liebchen.daniel.service;

import liebchen.daniel.persistence.type.Color;
import liebchen.daniel.service.extensions.CarsServiceExtension;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(CarsServiceExtension.class)
@RequiredArgsConstructor
public class CarServiceCountByColorTest {

    private final CarService carServicer;

    @Test
    public void test1(){
        var expectedCountedColorsMap = Map.of(
                Color.BLACK , 2L,
                Color.BLUE , 1L,
                Color.GREEN , 1L,
                Color.WHITE , 1L,
                Color.SILVER , 1L
        );

        var coutendColorMap = carServicer.countByColor();

        assertThat(coutendColorMap).isEqualTo(expectedCountedColorsMap);
}

}
