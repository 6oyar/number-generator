package servlets;

import generator.NumberGenerator;
import generator.NumbersLimitException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NextNumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)   {
        try (PrintWriter out = resp.getWriter()) {
            try {
                String number = NumberGenerator.getNextNumber();
                out.print("<h1>" + number + "</h1>");
            } catch (NumbersLimitException e) {
                out.print("<h1>" + "Last number is \"X999XX 116 RUS\" exceeded" + "</h1>");
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
