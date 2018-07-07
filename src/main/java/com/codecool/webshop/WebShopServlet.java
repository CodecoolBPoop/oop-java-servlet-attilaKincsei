package com.codecool.webshop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "webshop", urlPatterns = {"/", "/webshop"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {

    Item item0;
    Item item1;
    Item item2;
    Item item3;

    @Override
    public void init() throws ServletException {
        item0 = new Item("Tiller (Earthquake, used, but in very good condition)", (double) 599.99);
        item1 = new Item("Too unlimited discography on 1 casette", (double) 9.99);
        item2 = new Item("Pinky, my baby pig (1 year old)", (double) 999.99);
        item3 = new Item("Sistine Chapel (painting, by Michael Angelo)", (double) 19699.99);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String pageTitle = "A Very Excellentest Webshop";
        String title = "Welcome to my Excellent,  20th Century Webshop, Sir!";
        String subTitle = "Come and buy something excellentest";

        String addItemId = request.getParameter("add");
        String removeItemId = request.getParameter("remove");

        if (addItemId != null) {
            int addIdInt = Integer.parseInt(addItemId);
            Item itemToAdd = Item.getItemById(addIdInt, Item.itemList);
            ItemStore.cartContent.add(itemToAdd);
            ItemStore.calculateTotalPrice();
        } else if (removeItemId != null) {
            int removeIdInt = Integer.parseInt(removeItemId);
            Item.removeItem(removeIdInt, ItemStore.cartContent);
            ItemStore.calculateTotalPrice();
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : Item.itemList) {
            stringBuilder.append("<tr>\n<td>").append(item.getName())
                    .append("</td>\n<td align = \"right\">").append(item.getPrice())
                    .append("</td>\n<td>\n<form id=\"add-form").append(item.getId())
                    .append("\" action=\"/webshop\" method=\"get\">\n<button form=\"add-form")
                    .append(item.getId()).append("\" name=\"add\" value=\"")
                    .append(item.getId()).append("\" type=\"submit\">Add</button>\n</form>\n</td>\n")
                    .append("</td>\n<td>\n<form id=\"remove-form").append(item.getId())
                    .append("\" action=\"/webshop\" method=\"get\">\n<button form=\"remove-form")
                    .append(item.getId()).append("\" name=\"remove\" value=\"")
                    .append(item.getId()).append("\" type=\"submit\">Remove</button>\n</form>\n</td>\n</tr\n>");
        }


        out.println(
                "<html>\n" +
                        "<head><title>" + pageTitle + "</title></head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<ul>\n" +
                        "<h2 align = \"center\">" + subTitle + "</h2>\n" +
                        "<br/>" +
                        "<div>" +
                        "<table border=\"1\">\n" +
                        "<thead>\n" +
                        "<tr>\n" +
                        "<th>NAME</th>\n" +
                        "<th>PRICE</th>\n" +
                        "<th></th>\n" +
                        "<th></th>\n" +
                        "</tr>\n" +
                        "</thead>\n" +
                        "\n" +
                        "<tbody>\n" + stringBuilder.toString() + "</tbody>\n" +
                        "</table>\n" +
                        "</div>" +
                        "<br>" +
                        "<form id=\"check-cart\" action=\"/shopping-cart\" method=\"get\">\n" +
                        "<button form=\"check-cart\" type=\"submit\">Check shopping cart</button>\n" +
                        "</body></html>"
        );
    }
}


