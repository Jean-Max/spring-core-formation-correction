package com.viseo.formation.domain;

import com.viseo.formation.config.PersonConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersonConfig.class)
public class SingletonScopePersonTest {

    private static final String NAME = "John Smith";
    private static final String ANOTHER_NAME = "Anna Jones";

    @Test
    public void should_verify_name_is_same_for_singleton_beans(){

        //Given
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PersonConfig.class);
        context.refresh();
        Person personSingleton1 = (Person)context.getBean("personSingleton");
        Person personSingleton2 = (Person)context.getBean("personSingleton");

        // When
        personSingleton1.setName(NAME);
        personSingleton2.setName(ANOTHER_NAME);

        // Then
        Assert.assertNotNull(personSingleton1);
        Assert.assertEquals(ANOTHER_NAME, personSingleton1.getName());

        Assert.assertNotNull(personSingleton2);
        Assert.assertEquals(ANOTHER_NAME, personSingleton2.getName());

        context.close();
    }

}
