package grpc;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.qameta.allure.grpc.AllureGrpc;
import org.inject.PicturesServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class TestConfig {

    @Value("${grpc.server.address:localhost}")
    private String address;

    @Value("${grpc.server.port:9090}")
    private int port;

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
}

