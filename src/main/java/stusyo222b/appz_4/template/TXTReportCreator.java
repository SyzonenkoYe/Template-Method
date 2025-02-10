package stusyo222b.appz_4.template;

import stusyo222b.appz_4.entities.OfficeWorkerList;

import static stusyo222b.appz_4.template.OfficeWorkerListReportPreparer.reportsTypes;

public class TXTReportCreator {

    public static boolean reportCreate(String reportType, String filterName, OfficeWorkerList list, String signerName) {
        boolean flOK = false;
        //For TXT
        OfficeWorkerListReportPreparer.loadReportsTypeList();
        if (reportsTypes.size() != 0) {
            OfficeWorkerListReportPreparer elrp = null;
            try {

                String typeReportPrefix = reportsTypes.get(reportType);
                if (typeReportPrefix!=null) {
                    System.out.println("Type report prefix: " + typeReportPrefix);
                    String reportPreparerName = "stusyo222b.appz_4.template." + typeReportPrefix+"ReportPreparer";
                    System.out.println("Attempting to load class: " + reportPreparerName);
                    elrp = (OfficeWorkerListReportPreparer) Class.forName(reportPreparerName).newInstance();
                    System.out.println("Class loaded and instance created successfully.");
                    String filename = reportType + "_officeworkers.txt";
                    String fullname = OfficeWorkerListReportPreparer.workPath.substring(1) + filename;
                    flOK = elrp.createReport(fullname, filterName, list, signerName);
                    System.out.println("Saving file to: " + fullname);


                } else {
                    System.err.println("No mapping found for reportType: " + reportType);
                    flOK = false;
                    System.err.println("\'"+reportType+"\' <== Processing such type report not implemented...");
                }
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                flOK = false;
                System.err.println("Problem when create OfficeWorkerListReportPreparer");
            }
        } else {
            flOK = false;
            System.err.println("List of SaverToFile empty");
        }
        return flOK;
    }
}
