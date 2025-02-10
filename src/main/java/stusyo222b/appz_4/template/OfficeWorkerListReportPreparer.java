package stusyo222b.appz_4.template;


import stusyo222b.appz_4.entities.OfficeWorkerList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public abstract class OfficeWorkerListReportPreparer {

    static protected Map<String, String> reportsTypes = null;
    public static final String workPath =
            Thread.currentThread().getContextClassLoader().getResource("").getPath();

    public static void loadReportsTypeList() {
        boolean flOK = false;
        String fullPath = workPath+"reports_types.dat";

        Path path = Paths.get(fullPath.substring(1));
        try {
            List<String> typesList = Files.readAllLines(path, StandardCharsets.UTF_8);
            if (typesList.isEmpty()) {
                throw new RuntimeException("File with reports type was found empty!");
            }
            reportsTypes = new HashMap<>();
            for (String s : typesList) {
                reportsTypes.put(s.split("=")[0], s.split("=")[1]);
            }
            flOK = true;
        } catch (IOException e) {
            System.err.println("Problems with file...");
            flOK = false;
        } catch (Exception e) {
            System.err.println("File with reports types opened with problems...");
            flOK = false;
        }

    }

    public static Set<String> getReportsTypeList() {
        return reportsTypes.keySet();
    }

    public final boolean createReport(String filename, String filterName, OfficeWorkerList list, String signerName) {
        StringBuilder sb = new StringBuilder();
        sb.append(getHeader(filterName))
                .append(getData(list))
                .append(getFooter(signerName));
        String report = sb.toString();
        return save(report, filename);
    }

    abstract String getHeader(String filterName);
    abstract String getData(OfficeWorkerList list);
    abstract String getFooter(String signerName);

    public static boolean save(String report, String filename) {
        boolean flOK = false;
        if (!report.isEmpty()) {
            List<String> linesOfReport = Arrays.stream(report.split(System.lineSeparator())).toList();
            Path filepath = Paths.get(filename);
            try {
                Files.write(filepath, linesOfReport, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
                flOK = true;
            } catch (IOException e) {
                flOK = false;
                System.err.println("Problem with filename \'"+filename+"\'");
            }
        } else {
            System.err.println("List is null");
            flOK = false;
        }
        return flOK;
    }

}