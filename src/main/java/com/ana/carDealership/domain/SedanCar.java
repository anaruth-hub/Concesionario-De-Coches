package com.ana.carDealership.domain;

public final class SedanCar extends Car {

    private final int trunkCapacityLiters;

    public SedanCar(String brand, String model, FuelType fuelType, FabricationYear fabricationYear, int trunkCapacityLiters) {
        super(brand, model, fuelType, fabricationYear);
        if (trunkCapacityLiters <= 0) throw new IllegalArgumentException("trunkCapacityLiters must be > 0");
        this.trunkCapacityLiters = trunkCapacityLiters;
    }

    public int getTrunkCapacityLiters() {
        return trunkCapacityLiters;
    }

    @Override
    public String getDescription() {
        return String.format(
                "With its spacious trunk of %d liters and a comfort-oriented design, the %s is ideal for family trips and daily commuting with style.",
                trunkCapacityLiters, getDisplayName()
        );
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" - Trunk: %d L", trunkCapacityLiters);
    }
}
