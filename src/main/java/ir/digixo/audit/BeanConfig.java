package ir.digixo.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.Locale;
import java.util.Optional;
import com.github.javafaker.Faker;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "aware")
public class BeanConfig {

    //helps to aware the application's current auditor.
    //this is some kind of user mostly.
    @Bean
    public AuditorAware<String> aware() {
        return () -> Optional.of("Administrator");
    }

    @Bean
    public Faker faker() {
        return new Faker(Locale.ENGLISH);
    }
}
