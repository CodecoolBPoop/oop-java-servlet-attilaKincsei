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
                    .append("</td>\n</tr\n>");
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
                        "<tbody>\n" +
                        "<tr>\n" +
                        "<td>" + item0.getName() + "</td>\n" +
                        "<td align = \"right\">" + item0.getPrice() + "</td>\n" +
                        "<td>\n" +
                        "<form id=\"add-form1\" action=\"/webshop\" method=\"get\">\n" +
                        "<button form=\"add-form1\" name=\"add\" value=\"" + item0.getId() + "\" type=\"submit\">Add</button>\n" +
                        "</form>\n" +
                        "</td>\n" +
                        "<td>\n" +
                        "<form id=\"remove-form1\" action=\"/webshop\" method=\"get\">\n" +
                        "<button form=\"remove-form1\" name=\"remove\" value=\"" + item0.getId() + "\" type=\"submit\">Remove</button>\n" +
                        "</form>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "\n" +
                        "<tr>\n" +
                        "<td>" + item1.getName() + "</td>\n" +
                        "<td align = \"right\">" + item1.getPrice() + "</td>\n" +
                        "<td>\n" +
                        "<form id=\"add-form2\" action=\"/webshop\" method=\"get\">\n" +
                        "<button form=\"add-form2\" name=\"add\" value=\"" + item1.getId() + "\" type=\"submit\">Add</button>\n" +
                        "</form>\n" +
                        "</td>\n" +
                        "<td>\n" +
                        "<form id=\"remove-form2\" action=\"/webshop\" method=\"get\">\n" +
                        "<button form=\"remove-form2\" name=\"remove\" value=\"" + item1.getId() + "\" type=\"submit\">Remove</button>\n" +
                        "</form>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "\n" +
                        "<tr>\n" +
                        "<td>" + item2.getName() + "</td>\n" +
                        "<td align = \"right\">" + item2.getPrice() + "</td>\n" +
                        "<td>\n" +
                        "<form id=\"add-form3\" action=\"/webshop\" method=\"get\">\n" +
                        "<button form=\"add-form3\" name=\"add\" value=\"" + item2.getId() + "\" type=\"submit\">Add</button>\n" +
                        "</form>\n" +
                        "</td>\n" +
                        "<td>\n" +
                        "<form id=\"remove-form3\" action=\"/webshop\" method=\"get\">\n" +
                        "<button form=\"remove-form3\" name=\"remove\" value=\"" + item2.getId() + "\" type=\"submit\">Remove</button>\n" +
                        "</form>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "\n" +
                        "<tr>\n" +
                        "<td>" + item3.getName() + "</td>\n" +
                        "<td align = \"right\">" + item3.getPrice() + "</td>\n" +
                        "<td>\n" +
                        "<form id=\"add-form4\" action=\"/webshop\" method=\"get\">\n" +
                        "<button form=\"add-form1\" name=\"add\" value=\"" + item3.getId() + "\" type=\"submit\">Add</button>\n" +
                        "</form>\n" +
                        "</td>\n" +
                        "<td>\n" +
                        "<form id=\"remove-form4\" action=\"/webshop\" method=\"get\">\n" +
                        "<button form=\"remove-form1\" name=\"remove\" value=\"" + item3.getId() + "\" type=\"submit\">Remove</button>\n" +
                        "</form>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>" +
                        "<br>" +
                        "<form id=\"check-cart\" action=\"/shopping-cart\" method=\"get\">\n" +
                        "<button form=\"check-cart\" type=\"submit\">Check shopping cart</button>\n" +
                        "</body></html>"
        );
    }
}


