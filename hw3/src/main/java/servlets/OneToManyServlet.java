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

@WebServlet(value = "/one-to-many", name = "OneToManyServlet")
public class OneToManyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");
            ConnectionData connectionData;
            PrintWriter writer = resp.getWriter();
            writer.print("<h1> One To Many </h1>" +
                    "<table border = '1'>" +
                    "<tr><th>ФИО</th>" +
                    "<th>Профессия</th>" +
                    "<th>Клиника</th>" +
                    "<th>Адрес</th></tr>");
            try {
                connectionData = new ConnectionData();
                ResultSet set = connectionData.oneToMany();
                while (set.next()) {
                    writer.print("<tr><td>"+set.getString(1)+"</td>" +
                            "<td>"+set.getString(2)+"</td>" +
                            "<td>"+set.getString(3)+"</td>" +
                            "<td>"+set.getString(4)+"</td></tr>");
                }
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
            writer.print("</table>");
        }
    }
}
