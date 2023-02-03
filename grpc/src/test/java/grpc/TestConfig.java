package grpc;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.qameta.allure.grpc.AllureGrpc;
import org.inject.PicturesServiceGrpc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@PropertySource(value = "file:./src/test/resources/test.properties")
public class TestConfig {

    @Value("${grpc.server.address:localhost}")
    private String address;

    @Value("${grpc.server.port:9090}")
    private int port;

    @Value("${spring.datasource.url}")
    private String DBUrl;

    @Value("${spring.datasource.username}")
    private String DBUser;

    @Value("${spring.datasource.password}")
    private String DBPassword;

    @Bean
    Channel getChannel() {
        return ManagedChannelBuilder
                .forAddress(address, port)
                .usePlaintext()
                .build();
    }

    @Bean
    PicturesServiceGrpc.PicturesServiceBlockingStub getStub() {
        return PicturesServiceGrpc.newBlockingStub(getChannel())
                .withInterceptors(new AllureGrpc());
    }


    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(DBUrl, DBUser, DBPassword);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}

