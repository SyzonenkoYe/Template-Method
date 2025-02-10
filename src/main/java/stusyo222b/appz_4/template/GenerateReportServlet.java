package stusyo222b.appz_4.template;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import stusyo222b.appz_4.entities.OfficeWorker;
import stusyo222b.appz_4.entities.OfficeWorkerList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/GenerateReportServlet")
public class GenerateReportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the form
        String reportType = request.getParameter("reportType");
        String filterName = request.getParameter("filterName") != null ? request.getParameter("filterName") : "";
        String signerName = "Group: KN-222b. University: KhPI";

        
        boolean result = TXTReportCreator.reportCreate(reportType, filterName, OfficeWorkerList.getInstance(), signerName);

        // Prepare the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Report Generation</title></head><body>");
        if (result) {
            out.println("<h2>Report created successfully!</h2>");
        } else {
            out.println("<h2>Error: Failed to create the report.</h2>");
        }
        out.println("<a href=\"officeworkers.jsp\">Back to OfficeWorkers</a>");
        out.println("</body></html>");
        out.close();
    }
}
