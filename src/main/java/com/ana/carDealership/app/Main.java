package com.ana.carDealership.app;

import com.ana.carDealership.domain.*;
import com.ana.carDealership.report.ExportReportPrinter;
import com.ana.carDealership.service.Shop;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.addCar(new SedanCar("Toyota", "Camry", FuelType.HYBRID, FabricationYear.of(2021), 520));
        shop.addCar(new SportsCar("Porsche", "911", FuelType.GASOLINE, FabricationYear.of(2024), 308, "EXW", "JP"));
        shop.addCar(new SUVCar("Subaru", "Outback", FuelType.GASOLINE, FabricationYear.of(2020), Traction.FOUR_WHEEL_DRIVE));

        System.out.println("Stock descriptions");
        shop.listStockDescriptions().forEach(System.out::println);

        System.out.println("\nCars from year >= 2020");
        shop.filterByMinYear(2020).forEach(c -> System.out.println(c.getDisplayName() + " - " + c.getFabricationYear()));

        System.out.println("\nSearch brand: Toyota");
        shop.searchByBrand("toyota").forEach(c -> System.out.println(c.getDisplayName()));

        System.out.println("\nExport documents (Exportable only) ");
        ExportReportPrinter printer = new ExportReportPrinter();
        shop.exportablesInStock().forEach(printer::printReport);
    }
}
