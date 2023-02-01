package liebchen.daniel.persistence;

import liebchen.daniel.persistence.type.Color;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public interface CarUtils {
    Function<Car, String> toModel = car -> car.model;
    Function<Car, Color> toColor = car -> car.color;
    Function<Car, BigDecimal> toPrice = car -> car.price;
    Function<Car, List<String>> toComponents = car -> car.components;
    ToIntFunction<Car> toMileage = car -> car.mileage;
    org.eclipse.collections.api.block.function.Function<Car, BigDecimal> toPrice2 = car -> car.price;

    Comparator<Car> compareByModel = Comparator.comparing(car -> car.model);
    Comparator<Car> compareByPrice = Comparator.comparing(car -> car.price);
    Comparator<Car> compareByMileage = Comparator.comparing(car -> car.mileage);
    Comparator<Car> compareByColor = Comparator.comparing(car -> car.color);

}
