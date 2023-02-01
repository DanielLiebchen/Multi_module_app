package liebchen.daniel.persistence;


import liebchen.daniel.persistence.type.Color;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Car {
    String model;
    BigDecimal price;
    Color color;
    int mileage;
    List<String> components;

    public boolean hasMileageGreaterThan(double mileage){
        return this.mileage >mileage;
    }

    public Car withSortedComponents(){
        return Car
                .builder()
                .model(model)
                .price(price)
                .color(color)
                .mileage(mileage)
                .components(components
                                .stream()
                                .sorted()
                                .toList())
                .build();
    }

    public boolean containsComponent(String component){
        return components.stream().anyMatch(carComponent -> carComponent.equals(component));
    }

    public boolean hasPriceInRange(BigDecimal priceFrom, BigDecimal priceTo){
        return price.compareTo(priceFrom) >= 0 && price.compareTo(priceTo) <= 0;
    }

    @Override
    public String toString() {
        var message = "-------------------------------- CAR ------------------------------\n";
        message += "MODEL:      " + model + "\n";
        message += "PRICE:      " + price + "\n";
        message += "MILEAGE:    " + mileage + "\n";
        message += "COLOR:      " + color + "\n";
        message += "COMPONENTS: " + components.stream().collect(Collectors.joining(", ")) + "\n";
        return message;
    }
}
