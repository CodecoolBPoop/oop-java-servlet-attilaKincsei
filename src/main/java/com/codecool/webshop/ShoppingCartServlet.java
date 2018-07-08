package com.codecool.webshop;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "shoppingCart", urlPatterns = {"/shopping-cart"}, loadOnStartup = 1)
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String title = "Shopping Cart";

        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : ItemStore.cartContent) {
            stringBuilder.append("<tr>\n<td>").append(item.getName())
                    .append("</td>\n<td align = \"right\">").append(item.getPrice())
                    .append("</td>\n</tr\n>");
        }
        stringBuilder.append("<tr>\n<td align = \"center\"><b>Total price</b></td>\n<td align = \"right\">")
                .append(String.valueOf(ItemStore.getTotalPrice())).append("</td>\n</tr\n>");



        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<div>" +
                        "<table border=\"1\">\n" +
                        "<thead>\n" +
                        "<tr>\n" +
                        "<th>NAME</th>\n" +
                        "<th>PRICE</th>\n" +
                        "</tr>\n" +
                        "</thead>\n" +
                        "\n" +
                        "<tbody>\n" + stringBuilder.toString() + "</tbody>\n" +
                        "</table>\n" +
                        "</div>" +
                        "\n" +
                        "<div><a href=\"/webshop\">Back to My Webshop</a></div>" +
                        "</body></html>"
        );
    }
}
