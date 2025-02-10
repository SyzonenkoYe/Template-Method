<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
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
<head>
  <title>LAB 4</title>
</head>
<body>
<div style="text-align: center">
  <h1><%= "Hello, World with Design Patterns!" %>
  </h1>
  </h1>Syzonenko, KN-222b</h1>
  <br>
  <h2>Lab4 - Template Method (or Builder?) (save DB to report)</h2>
  <h3><a href="officeworkers.jsp">Show officeworkers page with Report Preparation</a></h3>
</div>
</body>
</html>
