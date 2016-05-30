package org.shop;


import org.shop.api.*;
import org.shop.data.Item;
import org.shop.data.Order;
import org.shop.data.Product;
import org.shop.data.Proposal;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext appletContext = new ClassPathXmlApplicationContext("context.xml");

        ProductService productService = appletContext.getBean(ProductService.class);
        OrderService orderService = appletContext.getBean(OrderService.class, "OrderServiceImpl");
        ItemService itemService = (ItemService) appletContext.getBean("itemService");
        UserService userService = (UserService) appletContext.getBean("UserSv");
        ProposalService proposalService = appletContext.getBean(ProposalService.class);

        Product galaxy = productService.getProductsByName("Samsung Galaxy Tab").get(0);
        Proposal proposal = proposalService.getProposalsByProduct(galaxy).get(0);

        orderService.createOrder(userService.getUserById((long) 1), proposal);

        for (Order order : orderService.getOrdersByUserId((long) 1)) {
            System.out.println(order);

            for (Item item : itemService.getItemsByOrderId(order.getId())) {
                System.out.println(item);
            }
        }

    }
}
