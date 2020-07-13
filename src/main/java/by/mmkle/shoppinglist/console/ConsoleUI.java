package by.mmkle.shoppinglist.console;

import by.mmkle.shoppinglist.bean.Product;
import by.mmkle.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ConsoleUI {
    @Autowired
    private ProductService productService;
    public void execute(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();

                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());

                        System.out.println("Enter product discount: ");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());

                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();

                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setDiscount(discount);
                        product.setDescription(description);

                        productService.createProduct(product);

                        System.out.println("Result: " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        System.out.println(productService.findProductById(id));
                        break;
                    case 3:
                        return;
                }
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
