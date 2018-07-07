package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloLink0", urlPatterns = {"/another/0"}, loadOnStartup = 3)
public class HelloLink0 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        String linkId = request.getParameter("link_id");

        out.println(
                "<html>\n" +
                        "<head><title>Hello Link page</title></head>\n" +
                        "<body>\n" +
                        "<h1>My first web page in Java!</h1>" +
                        (linkId == null ?
                                "<h3>No link was pressed</h3>" :
                                "<h3>Link " + linkId + " was pressed!</h3>") +
                        "<br/>" +
                        "<div>Back home: <a href=\"/servlet\">Back home</a></div>" +
                        "<div>Back to another page: <a href=\"/another\">Back to another</a></div>" +
                        "</body></html>"
        );
    }
}
