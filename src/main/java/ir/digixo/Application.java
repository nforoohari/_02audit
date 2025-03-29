package ir.digixo;

import com.github.javafaker.App;
import com.github.javafaker.Faker;
import com.zaxxer.hikari.util.ClockSource;
import ir.digixo.entity.Product;
import ir.digixo.exception.EntityNotFoundException;
import ir.digixo.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@SpringBootApplication
public class Application {

    public static void main(String[] args) throws EntityNotFoundException {

        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        System.out.println("Hello1");
        ProductService ps = ctx.getBean(ProductService.class);
        ps.getAll().forEach(System.out::println);
        System.out.println(ps.getProduct(10L));
//        SpringApplication.run(Application.class, args);

    }


    @Bean
    public CommandLineRunner commandLineRunner(Faker faker, ProductService productService)
    {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                System.out.println("Hello2 : " + faker.commerce().productName());
//                System.out.println("Hello3 : " + faker.commerce().material());
//                System.out.println("Hello4 : " + faker.number().randomNumber());

                final List<Product> products = createProductList();
                productService.saveAll(products);
            }
            //create the product list
            private List<Product> createProductList() {
                final List<Product> products = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    Product p = create();
//                    p.setName("nima");
                    products.add(p);
                }

                return products;
            }

            //create the product
            private Product create() {
                return Product.builder()
                        .name(faker.commerce().productName())
                        .description(faker.commerce().material())
                        .price(new BigDecimal(faker.number().randomNumber()))    // faker.commerce().price() is replaced by faker.number().randomNumber()
                        .build();
            }
        };
    }










}
