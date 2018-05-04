package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String s = "<h1>  <a href=\" http://localhost:8080/number/next \"> NEXT </a>  </h1> \n" +
                "<h1>  <a href=\" http://localhost:8080/number/random \"> RANDOM </a>  </h1>";
        PrintWriter out = resp.getWriter();
        out.print(s);
    }
}
