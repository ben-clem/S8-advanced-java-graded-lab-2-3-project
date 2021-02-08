import model.Order;
import model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.OrderRepository;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(final String[] args) throws Exception {

        Product product = new Product("Lampe", 500.0);
        Integer product01Id = ProductRepository.create(product);
        product = ProductRepository.find(product01Id);
        System.out.println(product);
        System.out.println(ProductRepository.get(product01Id));

        Order order = new Order();
        order.setDate(new Date());
        List<Product> products = new ArrayList<>();
        products.add(product);
        order.setProducts(products);
        Integer orderId = OrderRepository.create(order);
        Order savedOrder = OrderRepository.find(orderId);
        System.out.println(savedOrder);

        // retrieve all the products stored in the database
        System.out.println("listProducts()=" + ProductRepository.getAll());

        // remove all the products from the database for a fresh start
        System.out.println("deleteProducts()=" + ProductRepository.deleteAll());

        // populate the database with three products (observe that product IDs are automatically generated and set)
        Product sugar = new Product("sugar", 1.0);
        System.out.println("createProduct(" + sugar + ")=" + ProductRepository.create(sugar));
        System.out.println("   now, sugar=" + sugar);

        Product milk = new Product("milk", 0.5);
        System.out.println("createProduct(" + milk + ")=" + ProductRepository.create(milk));
//        System.out.println("   now, milk=" + milk);

        Product chocolate = new Product("chocolate", 5.0);
        System.out.println("createProduct(" + chocolate + ")=" + ProductRepository.create(chocolate));
//        System.out.println("   now, chocolate=" + chocolate);

        // retrieve all the products stored in the database
        System.out.println("listProducts()=" + ProductRepository.getAll());

        // raise the price of the chocolate and update the database accordingly
        chocolate.setPrice(7.0);
        System.out.println("updateProduct(" + chocolate + ")=" + ProductRepository.update(chocolate));
//        System.out.println("readProduct(" + chocolate.getId() + ")=" + ProductRepository.find(chocolate.getId()));

        // delete the milk from the database
        System.out.println("deleteProduct(" + milk + ")=" + ProductRepository.delete(milk));
        System.out.println("readProduct(" + milk.getId() + ")=" + ProductRepository.find(milk.getId()));

        // retrieve all the products that cost less than 6.0
        double maxPrice = 6.0;
        System.out.println("listProductsLessThan(" + maxPrice + ")=" + ProductRepository.listProductsLessThan(maxPrice));

        // raise the price of all the prodcuts by 1.0
        double priceRaise = 1.0;
        System.out.println("raiseProductPriceBy(" + priceRaise + ")=" + ProductRepository.raiseProductPriceBy(priceRaise));

        // retrieve all the products stored in the database
        System.out.println("listProducts()=" + ProductRepository.getAll());

        // done
        System.out.println("done");
    }

}