package com.ana.carDealership.domain;

public final class SUVCar extends Car {

    private final Traction traction;

    public SUVCar(String brand, String model, FuelType fuelType, FabricationYear fabricationYear, Traction traction) {
        super(brand, model, fuelType, fabricationYear);
        this.traction = java.util.Objects.requireNonNull(traction, "traction cannot be null");
    }

    public Traction getTraction() { return traction; }

    @Override
    public String getDescription() {
        String tractionLabel = switch (traction) {
            case TWO_WHEEL_DRIVE -> "2WD";
            case FOUR_WHEEL_DRIVE -> "4x4";
            case ALL_WHEEL_DRIVE -> "AWD";
        };

        return String.format(
                "The %s, with %s traction, is an SUV ready to leave the asphalt behind—perfect for outdoor adventures and demanding terrain.",
                getDisplayName(), tractionLabel
        );
    }

    @Override
    public String toString() {
        return super.toString() + " - Traction: " + traction;
    }
}
