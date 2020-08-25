package com.zatkhey.view;

import com.zatkhey.model.Report;
import org.springframework.stereotype.Component;

@Component
public class FormattedConsoleReportView implements ReportView {

    @Override
    public void showReport(Report report) {
        System.out.println("------------------------------------");
        for (Report.ReportEntry reportEntry : report.getEntries()) {
            System.out.print(String.format("%s\t%s\t%s\t%s\n",
                    reportEntry.getWorker().getLastName(),
                    reportEntry.getWorker().getFirstName(),
                    reportEntry.getDuration().toHours(),
                    reportEntry.getSalary().doubleValue()));
        }
        System.out.println("-----------------------------------");
    }

    @Override
    public String generateView(Report report) {
        String result = "";
        for (Report.ReportEntry reportEntry : report.getEntries()) {
            result += reportEntry.getWorker().getLastName() + "\n";
        }
        return result;
    }
}
