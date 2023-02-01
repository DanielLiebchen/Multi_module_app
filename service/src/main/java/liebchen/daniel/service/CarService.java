package liebchen.daniel.service;

import liebchen.daniel.persistence.Car;
import liebchen.daniel.persistence.type.Color;
import liebchen.daniel.service.extensions.CarServiceException;
import liebchen.daniel.service.type.SortBy;
import liebchen.daniel.service.type.Statistics;
import liebchen.daniel.service.type.StatisticsType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.eclipse.collections.impl.collector.Collectors2;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static liebchen.daniel.persistence.CarUtils.*;
import static liebchen.daniel.service.type.Statistics.toBigDecimalStatistics;
import static liebchen.daniel.service.type.Statistics.toDoubleStatistics;

@RequiredArgsConstructor
@Getter
public class CarService {
    private final List<Car> cars;

    /**
     * Method witch returns information about car as formatted string expression
     * @return information about cars as string
     */
    public String info(){
        return cars.stream().map(Car::toString).collect(Collectors.joining("\n"));
    }

    /**
     * Method witch returns list of cars sorted by attributes ascending or descending
     * @param sortBy
     * @param descending
     * @return sorted list of cars
     */
    public List<Car> sortBy(SortBy sortBy, boolean descending){
        if (sortBy == null){
            throw new CarServiceException("SortBy instance is null");
        }

        return switch (sortBy){
            case MILEAGE -> cars.stream().sorted(compareByMileage).toList();
            case COLOR -> cars.stream().sorted(compareByColor).toList();
            case MODEL -> cars.stream().sorted(compareByModel).toList();
            case PRICE -> cars.stream().sorted(compareByPrice).toList();
        };
    }

    /**
     * Method witch returns cars with mileage greater then inserted value
     * @param mileage
     * @return list of cars with mileage greater then inserted value
     */
    public List<Car> withMileageGreaterThan(double mileage){

        if (mileage <= 0){
            throw new CarServiceException("Mileage must have positive value");
        }
        return cars
                .stream()
                .filter(car -> car.hasMileageGreaterThan(mileage))
                .toList();
    }

    /**
     * Method witch returns map as key Color and as values number of cars in this color
     * @return
     */
    public Map<Color, Long> countByColor(){
        return cars
                .stream()
                .collect(groupingBy(toColor,counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, Long::sum, LinkedHashMap::new));
    }

    /**
     *
     * @return
     */
    public Map<String, List<Car>> groupedByModelWithMostExpensiveCars(){
        return cars
                .stream()
                .collect(groupingBy(
                        toModel,
                        Collectors.collectingAndThen(
                                groupingBy(toPrice),
                                map -> map
                                        .entrySet()
                                        .stream()
                                        .max(Map.Entry.comparingByKey())
                                        .orElseThrow()
                                        .getValue()
                        )));
    }


    /**
     *
     * @param statisticsType
     * @return
     */
    public Statistics <?> getStatistics(StatisticsType statisticsType) {

        if (statisticsType == null) {
            throw new CarServiceException("Statistics type is null");
        }


        return switch (statisticsType) {
            case PRICE -> toBigDecimalStatistics(cars.stream().collect(Collectors2.summarizingBigDecimal(toPrice2)));
            case MILEAGE -> toDoubleStatistics(cars.stream().collect(Collectors.summarizingInt(toMileage)));
        };

    }

    /**
     *
     * @return
     */
    public List<Car> getMostExpensiveCar() {
        return cars
                .stream()
                .collect(groupingBy(toPrice))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .orElseThrow(() -> new CarServiceException("cannot find most expensive cars"))
                .getValue();
    }

    /**
     *
     * @return
     */
    public List<Car> withSortedComponents(){
        return cars
                .stream()
                .map(Car::withSortedComponents)
                .toList();
    }

    /**
     *
     * @return
     */
    public Map<String, List<Car>> groupByComponentName(){
        return cars
                .stream()
                .flatMap(car -> toComponents.apply(car).stream())
                .distinct()
                .collect(toMap(
                        component -> component,
                        component -> cars.stream().filter(car -> car.containsComponent(component)).toList()
                ))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> x,
                        LinkedHashMap::new
                ));
    }


    /**
     *
     * @param priceFrom
     * @param priceTo
     * @return
     */
    public  List<Car> withPriceInRange(BigDecimal priceFrom, BigDecimal priceTo){

        if (priceFrom == null){
            throw new CarServiceException("Price from is null");
        }
        if (priceTo == null){
            throw new CarServiceException("Price to is null");
        }
        if (priceFrom.compareTo(priceTo) > 0){
            throw new CarServiceException("Price from is greater or equal price to");
        }
        return cars
                .stream()
                .filter(car -> car.hasPriceInRange(priceFrom, priceTo))
                .toList();
    }

}
