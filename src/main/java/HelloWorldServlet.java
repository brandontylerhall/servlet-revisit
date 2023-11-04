import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    int pageCount = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String reset = request.getParameter("reset");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");

        if (reset == null || !reset.equals("yes")) {
            pageCount++;
        } else {
            pageCount = 0;
        }

        if (name == null) {
            out.println("<h1>Hello, World</h1>");
        } else {
            out.printf("<h1>Hello, %s</h1>", name);
        }
        out.printf("<p>Current page count: %s", pageCount);
    }
}