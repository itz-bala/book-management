package main.OPENAPI;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public OpenAPI api(){

        Server server = new Server();
        server.setUrl("/");
        server.setDescription("API Documentation");

        return new OpenAPI().addServersItem(server);



    }



}
