package main.Mapping;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper model=new ModelMapper();

        model.getConfiguration().setAmbiguityIgnored(true);

        return model;
    }
}
