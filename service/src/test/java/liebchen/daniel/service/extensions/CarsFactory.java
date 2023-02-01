package liebchen.daniel.service.extensions;

import liebchen.daniel.persistence.Car;
import liebchen.daniel.persistence.type.Color;

import java.math.BigDecimal;
import java.util.List;

public interface CarsFactory {

    Car skoda1 = Car
            .builder()
            .model("Skoda")
            .price(new BigDecimal("220"))
            .color(Color.BLACK)
            .mileage(90)
            .components(List.of("1", "4", "3", "6", "5", "7", "9"))
            .build();
    Car skoda2 = Car
            .builder()
            .model("Skoda")
            .price(new BigDecimal("100"))
            .color(Color.BLUE)
            .mileage(10)
            .components(List.of("7","1", "8", "9"))
            .build();
    Car toyota = Car
            .builder()
            .model("Toyota")
            .price(new BigDecimal("450"))
            .color(Color.SILVER)
            .mileage(2000)
            .components(List.of( "8", "9"))
            .build();
    Car audi =  Car
            .builder()
            .model("Audi")
            .price(new BigDecimal("760"))
            .color(Color.BLACK)
            .mileage(20000)
            .components(List.of( "2", "1", "7", "8"))
            .build();
    Car fiat = Car
            .builder()
            .model("Fiat")
            .price(new BigDecimal("150"))
            .color(Color.WHITE)
            .mileage(30000)
            .components(List.of( "2", "1", "8", "3", "9"))
            .build();
    Car bmw = Car
            .builder()
            .model("BMW")
            .price(new BigDecimal("720"))
            .color(Color.GREEN)
            .mileage(700)
            .components(List.of( "3", "9"))
            .build();

    Car skoda1SotredComponents = Car
            .builder()
            .model("Skoda")
            .price(new BigDecimal("220"))
            .color(Color.BLACK)
            .mileage(90)
            .components(List.of("1", "3", "4", "5", "6", "7", "9"))
            .build();
    Car skoda2SotredComponents = Car
            .builder()
            .model("Skoda")
            .price(new BigDecimal("100"))
            .color(Color.BLUE)
            .mileage(10)
            .components(List.of("1","7", "8", "9"))
            .build();
    Car toyotaSotredComponents = Car
            .builder()
            .model("Toyota")
            .price(new BigDecimal("450"))
            .color(Color.SILVER)
            .mileage(2000)
            .components(List.of("8", "9"))
            .build();
    Car audiSotredComponents =  Car
            .builder()
            .model("Audi")
            .price(new BigDecimal("760"))
            .color(Color.BLACK)
            .mileage(20000)
            .components(List.of("1", "2", "7", "8"))
            .build();
    Car fiatSotredComponents = Car
            .builder()
            .model("Fiat")
            .price(new BigDecimal("150"))
            .color(Color.WHITE)
            .mileage(30000)
            .components(List.of("1", "2", "3", "8", "9"))
            .build();
    Car bmwSotredComponents = Car
            .builder()
            .model("BMW")
            .price(new BigDecimal("720"))
            .color(Color.GREEN)
            .mileage(700)
            .components(List.of( "3", "9"))
            .build();
}
