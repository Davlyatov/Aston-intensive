package servlets;

import dao.BankDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/many-to-many", name = "manyToMany")
public class ManyToManyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1> Many To Many </h1>" +
                "<table border = '1'>" +
                "<tr><th>ФИО</th>" +
                "<th>Банк</th></tr>");
        BankDAO bankDAO = new BankDAO();
        List persons = bankDAO.findAll();
        for (Object person : persons) {
            Object[] objects = (Object[]) person;
            writer.print("<tr><td>" + objects[0] + "</td>" +
                    "<td>" + objects[1] + "</td></tr>");
        }
        writer.print("</table>");
    }
}
