package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(value = "/many-to-many", name = "manyToMany")
public class ManyToManyServlet extends HttpServlet {
}
