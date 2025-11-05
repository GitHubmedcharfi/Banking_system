package singleton;

import singleton.db.DatabaseConnectionManager;
import singleton.service.OrderService;
import singleton.service.ProductService;
import singleton.service.UserService;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        UserService userService = new UserService();

        productService.getAllProducts();
        orderService.createOrder();
        userService.getUserProfile();

        DatabaseConnectionManager.getInstance().shutdown();
    }
}