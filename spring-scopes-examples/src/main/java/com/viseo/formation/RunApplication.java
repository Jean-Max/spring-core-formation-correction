package com.viseo.formation;

import com.viseo.formation.config.PersonConfig;
import com.viseo.formation.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunApplication {

    public static void main(String[] args) {

        // Getting application context
        ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);

        // Getting singleton beans
        Person personSingleton1 = (Person)context.getBean("personSingleton");
        personSingleton1.setName("Singleton1");

        Person personSingleton2 = (Person)context.getBean("personSingleton");
        personSingleton2.setName("Singleton2");

        // Getting prototypes beans
        Person personPrototype1 = (Person)context.getBean("personPrototype");
        personPrototype1.setName("Prototype1");

        Person personPrototype2 = (Person)context.getBean("personPrototype");
        personPrototype2.setName("Prototype2");

        // Display beans name
        System.out.println("Bean personSingleton1 name is: " + personSingleton1.getName());
        System.out.println("Bean personSingleton2 name is: " + personSingleton2.getName());
        System.out.println("Bean personPrototype1 name is: " + personPrototype1.getName());
        System.out.println("Bean personPrototype2 name is: " + personPrototype2.getName());
    }
}
