package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/users/info"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = req.getParameterMap()
                .entrySet().stream().map(stringEntry -> {
                    String params = String.join(" and ", stringEntry.getValue());
                    return stringEntry.getKey() + ": " + params + "\n";
                }).collect(Collectors.joining());

        resp.getWriter().write(result);
    }
}
