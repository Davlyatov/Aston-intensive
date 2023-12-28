package servlets;

import dao.ClinicDAO;
import entity.clinic.Doctor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/one-to-many", name = "OneToManyServlet")
public class OneToManyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.print("<h1> One To Many </h1>" +
                    "<table border = '1'>" +
                    "<tr><th>ФИО</th>" +
                    "<th>Профессия</th>" +
                    "<th>Клиника</th>" +
                    "<th>Адрес</th></tr>");
            ClinicDAO clinicDAO = new ClinicDAO();
            List<Doctor> doctors = clinicDAO.getAll();
            for (Doctor doctor : doctors) {
                writer.print("<tr><td>" + doctor.getName() + "</td>" +
                        "<td>" + doctor.getProfession() + "</td>" +
                        "<td>" + doctor.getClinic().getName() + "</td>" +
                        "<td>" + doctor.getClinic().getAddress() + "</td></tr>");
            }
            writer.print("</table>");
        }
    }
}
