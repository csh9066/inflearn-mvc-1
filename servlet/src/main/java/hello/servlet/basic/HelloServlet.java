package hello.servlet.basic;

import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("request = " + request);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print("hello " + username);
    }
}
