<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="stusyo222b.appz_4.entities.OfficeWorkerList" %>
<%@ page import="stusyo222b.appz_4.entities.OfficeWorker" %>
<%@ page import="java.util.List" %>
<%@ page import="stusyo222b.appz_4.template.OfficeWorkerListReportPreparer" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Office Workers</title>
  <style type="text/css">
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      color: #333;
      margin: 0;
      padding: 0;
    }
    .content {
      max-width: 800px;
      margin: 40px auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
    }
    h1 {
      color: #4a90e2;
      text-align: center;
    }
    label {
      font-weight: bold;
      display: block;
      margin: 10px 0 5px;
    }
    input[type="text"],
    input[type="date"],
    select {
      width: 100%;
      padding: 8px;
      margin: 5px 0 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }
    .error-message {
      color: red;
      font-weight: bold;
      text-align: center;
      margin-bottom: 20px;
    }
    button {
      background-color: #4a90e2;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
    button:hover {
      background-color: #357ab7;
    }
    a {
      display: inline-block;
      padding: 10px 20px;
      margin-left: 10px;
      background-color: #ccc;
      color: black;
      text-decoration: none;
      border-radius: 5px;
    }
    a:hover {
      background-color: #aaa;
    }
    @media (max-width: 600px) {
      .content {
        padding: 15px;
        box-shadow: none;
      }
      h1 {
        font-size: 1.5em;
      }
    }
  </style>
</head>
<body>
<h1>Office Worker List</h1>

<table>
  <thead>
  <tr>
    <th>#</th>
    <th>Surname</th>
    <th>Name</th>
    <th>Patronomical Name</th>
    <th>Date of start work</th>
    <th>Date of end work</th>
    <th>Worker Code</th>
    <th>Status</th>
  </tr>
  </thead>
  <tbody>
  <%
    OfficeWorkerList officeworkers = OfficeWorkerList.getInstance();
    int counter = 1;
    for (OfficeWorker off : officeworkers) {
  %>
  <tr>
    <td><%= counter++ %></td>
    <td><%= off.getSurname() %></td>
    <td><%= off.getName() %></td>
    <td><%= off.getPname() %></td>
    <td><%= off.getStartWork() %></td>
    <td><%= off.getEndWork() %></td>
    <td><%= off.getWorkerCod() %></td>
    <td><%= off.getOfficeWorkerStatus().getDisplayName() %></td>
  </tr>
  <%
    }
  %>
  </tbody>
</table>

<div class="form-container">
  <h3>Generate Report</h3>
  <form action="GenerateReportServlet" method="post">
    <label for="reportType">Report Type:</label>
    <select name="reportType" id="reportType">
      <%
        OfficeWorkerListReportPreparer.loadReportsTypeList();
        for (String reportType : OfficeWorkerListReportPreparer.getReportsTypeList()) {
      %>
      <option value="<%= reportType %>"><%= reportType.toUpperCase() %> Report</option>
      <%
        }
      %>
    </select>
    <br>

    <br>
    <button type="submit">Generate Report</button>
  </form>

</div>
</body>
</html>






