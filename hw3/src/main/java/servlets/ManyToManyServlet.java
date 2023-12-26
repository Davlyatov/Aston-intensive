package servlets;

import dataSource.ConnectionData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(value = "/many-to-many", name = "manyToMany")
public class ManyToManyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        ConnectionData connectionData;
        PrintWriter writer = resp.getWriter();
        writer.print("<h1> Many To Many </h1>" +
                "<table border = '1'>" +
                "<tr><th>ФИО</th>" +
                "<th>Банк</th></tr>");
        try {
            connectionData = new ConnectionData();
            ResultSet set = connectionData.manyToMany();
            while (set.next()) {
                writer.print("<tr><td>"+set.getString(1)+"</td>" +
                        "<td>"+set.getString(2)+"</td></tr>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        writer.print("</table>");
    }
}
