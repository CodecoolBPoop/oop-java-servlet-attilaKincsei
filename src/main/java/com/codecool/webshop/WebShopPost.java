package com.codecool.webshop;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "webshopPost", urlPatterns = {"/webshop-post"}, loadOnStartup = 1)
public class WebShopPost extends HttpServlet {


    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws IOException {

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

        response.sendRedirect("/webshop");

    };


}
