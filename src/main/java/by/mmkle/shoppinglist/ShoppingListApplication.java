package by.mmkle.shoppinglist;

import by.mmkle.shoppinglist.console.ConsoleUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@ComponentScan(basePackages = "by.mmkle.shoppinglist")
@PropertySource("classpath:application.properties")
@Configuration
class ShoppingListApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShoppingListApplication.class);
        context.getBean("consoleUI", ConsoleUI.class).execute();
    }
}
