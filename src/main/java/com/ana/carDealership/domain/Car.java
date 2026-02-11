package com.ana.carDealership.domain;

import java.util.Objects;

public abstract class Car {

    private final String brand;
    private final String model;
    private final FuelType fuelType;
    private final FabricationYear fabricationYear;

    protected Car(String brand, String model, FuelType fuelType, FabricationYear fabricationYear) {
        this.brand = requireNonBlank(brand, "brand");
        this.model = requireNonBlank(model, "model");
        this.fuelType = Objects.requireNonNull(fuelType, "fuelType cannot be null");
        this.fabricationYear = Objects.requireNonNull(fabricationYear, "fabricationYear cannot be null");
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public FuelType getFuelType() { return fuelType; }
    public FabricationYear getFabricationYear() { return fabricationYear; }

    public final String getDisplayName() {
        return brand + " " + model;
    }

    public abstract String getDescription();

    protected static String requireNonBlank(String value, String field) {
        Objects.requireNonNull(value, field + " cannot be null");
        String trimmed = value.trim();
        if (trimmed.isEmpty()) throw new IllegalArgumentException(field + " cannot be blank");
        return trimmed;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s) - Fuel: %s",
                brand, model, fabricationYear, fuelType);
    }
}
