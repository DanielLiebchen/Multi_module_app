package liebchen.daniel.service;

import liebchen.daniel.service.extensions.CarsServiceExtension;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(CarsServiceExtension.class)
@RequiredArgsConstructor
public class CarServiceCarsTest {


    private final CarService carService;

    @Test
    @DisplayName("should return correct string expression with information about cars")
    public void test1(){
        var info = carService.info();

        val expression = """
                -------------------------------- CAR ------------------------------
                MODEL:      Skoda
                PRICE:      220
                MILEAGE:    90
                COLOR:      BLACK
                COMPONENTS: 1, 4, 3, 6, 5, 7, 9
                """ ;

        //System.out.println(expression);
        System.out.println(info);
        assertThat(info)
                .hasLineCount(41)
                .startsWith(expression)
                .endsWith("\n")
                .contains(List.of(
                        "MODEL:      Skoda\n",
                        "MODEL:      Skoda\n",
                        "MODEL:      Toyota\n",
                        "MODEL:      Audi\n",
                        "MODEL:      Fiat\n",
                        "MODEL:      BMW\n"
                ));

    }
}
