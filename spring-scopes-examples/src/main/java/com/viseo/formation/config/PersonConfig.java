package com.viseo.formation.config;

import com.viseo.formation.domain.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PersonConfig {

    @Bean(name = "personSingleton")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    Person personSingleton (){
        return new Person();
    }

    @Bean(name = "personPrototype")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    Person personPrototype(){
        return new Person();
    }

}
