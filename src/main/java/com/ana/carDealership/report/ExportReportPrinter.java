package com.ana.carDealership.report;

import com.ana.carDealership.domain.Exportable;

public class ExportReportPrinter {
    public void printReport(Exportable exportable) {
        System.out.println("Export document generated: ");
        System.out.println(exportable.getExportInfo());
    }

}
