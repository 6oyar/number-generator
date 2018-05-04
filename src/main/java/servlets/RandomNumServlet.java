package servlets;

import generator.NumberGenerator;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RandomNumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try (PrintWriter out = resp.getWriter()) {
                String number = NumberGenerator.getRandomNumber();
                out.print("<h1>" + number + "</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
