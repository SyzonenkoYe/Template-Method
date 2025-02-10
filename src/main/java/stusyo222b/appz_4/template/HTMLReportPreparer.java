package stusyo222b.appz_4.template;


import stusyo222b.appz_4.entities.OfficeWorkerList;

public class HTMLReportPreparer extends OfficeWorkerListReportPreparer {

    @Override
    String getHeader(String filterName) {
        StringBuilder header = new StringBuilder();
        header.append("<html><head><title>Office Worker Report</title></head><body>")
                .append("<h1>Office Worker Report</h1>");
        if (!filterName.isEmpty()) {
            header.append("<h2>Filter: ").append(filterName).append("</h2>");
        }
        header.append("<table border=\"1\"><tr>")
                .append("<th>#</th><th>Surname</th><th>Name</th><th>Worker Code</th><th>Status</th>")
                .append("</tr>");
        return header.toString();
    }

    @Override
    String getData(OfficeWorkerList list) {
        StringBuilder data = new StringBuilder();
        if (!list.isEmpty()) {
            for (int number = 0; number < list.size(); number++) {
                data.append("<tr>")
                        .append("<td>").append(number + 1).append("</td>")
                        .append("<td>").append(list.get(number).getSurname()).append("</td>")
                        .append("<td>").append(list.get(number).getName()).append("</td>")
                        .append("<td>").append(list.get(number).getWorkerCod()).append("</td>")
                        .append("<td>").append(list.get(number).getOfficeWorkerStatus().getDisplayName()).append("</td>")
                        .append("</tr>");
            }
        } else {
            data.append("<tr><td colspan=\"4\">No data available</td></tr>");
        }
        return data.toString();
    }

    @Override
    String getFooter(String signerName) {
        return "</table><p>Prepared by " + signerName + "</p></body></html>";
    }
}
