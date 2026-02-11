package com.ana.carDealership.domain;

import java.time.Year;

public final class FabricationYear {
    private final int value;

    private FabricationYear(int value) {
        this.value = value;
    }

    public static FabricationYear of(int year) {
        int current = Year.now().getValue();
        if (year < 1950 || year > current) {
            throw new IllegalArgumentException(
                    "FabricationYear must be between 1950 and " + current + " (inclusive). Provided: " + year
            );
        }
        return new FabricationYear(year);
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
