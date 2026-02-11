package com.ana.carDealership.service;

import com.ana.carDealership.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public final class Shop {

    private final List<Car> stock = new ArrayList<>();

    public void addCar(Car car) {
        stock.add(Objects.requireNonNull(car, "car cannot be null"));
    }

    public List<Car> listStock() {
        return List.copyOf(stock);
    }

    public List<String> listStockDescriptions() {
        return stock.stream()
                .map(Car::getDescription)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> filterByMinYear(int minYear) {
        return stock.stream()
                .filter(c -> c.getFabricationYear().value() >= minYear)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> searchByBrand(String brand) {
        Objects.requireNonNull(brand, "brand cannot be null");
        String normalized = brand.trim().toLowerCase(Locale.ROOT);

        return stock.stream()
                .filter(c -> c.getBrand().toLowerCase(Locale.ROOT).equals(normalized))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> filterByFuel(FuelType fuelType) {
        Objects.requireNonNull(fuelType, "fuelType cannot be null");
        return stock.stream()
                .filter(c -> c.getFuelType() == fuelType)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<SUVCar> filterSuvByTraction(Traction traction) {
        Objects.requireNonNull(traction, "traction cannot be null");
        return stock.stream()
                .filter(SUVCar.class::isInstance)
                .map(SUVCar.class::cast)
                .filter(suv -> suv.getTraction() == traction)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Exportable> exportablesInStock() {
        return stock.stream()
                .filter(Exportable.class::isInstance)
                .map(Exportable.class::cast)
                .collect(Collectors.toUnmodifiableList());
    }
}
