package kz.edu.nu.cs.exercise;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet(urlPatterns = { "/myservlet" })
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

//Save all request before
    private ArrayList<String> story = new ArrayList<String>();

    public MyServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocalDateTime time = LocalDateTime.now();
        String host = request.getRemoteHost();
        String path = request.getContextPath();
        String res = "Path: " + path +" Time: " + time.toString() +  " Host: " + host;
        story.add(res);
        for(String element : story) {
            response.getWriter().append(element).append('\n');
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
