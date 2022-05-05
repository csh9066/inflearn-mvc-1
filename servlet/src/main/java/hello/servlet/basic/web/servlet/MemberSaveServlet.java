package hello.servlet.basic.web.servlet;

import hello.servlet.basic.domain.member.Member;
import hello.servlet.basic.domain.member.MemberRepository;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member();
        member.setUsername(username);
        member.setAge(age);

        memberRepository.save(member);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<ul>");
        writer.println("<li>id : "+member.getId()+"</li>");
        writer.println("<li>username : "+member.getUsername()+"</li>");
        writer.println("<li>age : "+member.getAge()+"</li>");
        writer.println("</ul>");
        writer.println("<a href=\"/index.html\"    >메인</a>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
