package online.tuanzi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = {"online.tuanzi.**.mapper"})
public class BlogBackendManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogBackendManagementSystemApplication.class, args);
    }

}
