# Example project for basic Servlets
* Navigation
* Generating HTML
* GET parameter processing
* Runs on Jetty


# Extend the base repo with a Webshop functionality.

Your project should contain the following classes:
* Item.java: a simple Java class with id (generated integer), name (string) and price (float or double) properties.
* ItemStore.java: contains a static List (ArrayList or LinkedList) of Items. It should provide static functions as well, like add and remove. The business logic is not that important, adding multiple Items with the same id is valid use case.
    - Pro version: store it in a session instead of a static list!
* WebShopServlet.java: This should list at least 3-5 different available Items with different properties (eg. [0, "Asus Laptop", 1600.0], [1, "Harry Potter Ebook", 50.0], etc.). Generate these Items in the init() method, for example. Render every Item's name and price on the screen, with an Add and a Remove button OR link (if it's easier for you). When these buttons are pressed, the content of ItemStore's static list should be modified with the belonging item. You shouldn't give any feedback on the screen from the modifications (yet)!
* ShoppingCartServlet.java: This should list the content of ItemStore's static list. It should render a HTML list or a table with the items in it. It should render a Sum of Price field as well.