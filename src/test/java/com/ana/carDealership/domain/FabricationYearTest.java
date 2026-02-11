package com.ana.carDealership.domain;

import org.junit.jupiter.api.Test;

import java.time.Year;
import static org.junit.jupiter.api.Assertions.*;
class FabricationYearTest {

    @Test
    void of_shouldAcceptBoundaryYears() {
        int current = Year.now().getValue();
        assertEquals(1950, FabricationYear.of(1950).value());
        assertEquals(current, FabricationYear.of(current).value());
    }

    @Test
    void  of_shouldThrowWhenYearOut0fRange() {
        int current = Year.now().getValue();
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> FabricationYear.of(1949));
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> FabricationYear.of(current + 1));

        assertTrue(ex1.getMessage().contains("between 1950"));
        assertTrue(ex2.getMessage().contains("between 1950"));
        }
    }



