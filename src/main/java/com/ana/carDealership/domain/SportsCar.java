package com.ana.carDealership.domain;

import java.util.Objects;

public final class SportsCar extends Car implements Exportable {

    private final int topSpeedKmH;
    private final String incoterms;
    private final String destinationCountryCode;

    public SportsCar(String brand, String model, FuelType fuelType, FabricationYear fabricationYear,
                     int topSpeedKmH, String incoterms, String destinationCountryCode) {
        super(brand, model, fuelType, fabricationYear);
        if (topSpeedKmH <= 0) throw new IllegalArgumentException("topSpeedKmH must be > 0");
        this.topSpeedKmH = topSpeedKmH;
        this.incoterms = Objects.requireNonNull(incoterms, "incoterms cannot be null").trim();
        this.destinationCountryCode = Objects.requireNonNull(destinationCountryCode, "destinationCountryCode cannot be null").trim();
        if (this.incoterms.isEmpty()) throw new IllegalArgumentException("incoterms cannot be blank");
        if (this.destinationCountryCode.isEmpty()) throw new IllegalArgumentException("destinationCountryCode cannot be blank");
    }

    public int getTopSpeedKmH() { return topSpeedKmH; }

    @Override
    public String getDescription() {
        return String.format(
                "Built for those who live the road intensely: the %s reaches a top speed of %d km/h, combining elegance and performance in every curve.",
                getDisplayName(), topSpeedKmH
        );
    }

    @Override
    public String getExportInfo() {
        return String.format("%s (%s) — Top speed: %d km/h — Export-ready. Incoterms: %s. Destination: %s.",
                getDisplayName(), getFabricationYear(), topSpeedKmH, incoterms, destinationCountryCode
        );
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" - Top speed: %d km/h", topSpeedKmH);
    }
}
