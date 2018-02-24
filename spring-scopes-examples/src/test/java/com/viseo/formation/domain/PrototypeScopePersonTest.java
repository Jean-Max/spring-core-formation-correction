package com.viseo.formation.domain;


import com.viseo.formation.config.PersonConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersonConfig.class)
public class PrototypeScopePersonTest {

    private static final String NAME = "John Smith";
    private static final String ANOTHER_NAME = "Anna Jones";

    @Test
    public void should_verify_name_is_different_for_prototype_beans(){

        //Given
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PersonConfig.class);
        context.refresh();
        Person personPrototype1 = (Person)context.getBean("personPrototype");
        Person personPrototype2 = (Person)context.getBean("personPrototype");

        // When
        personPrototype1.setName(NAME);
        personPrototype2.setName(ANOTHER_NAME);

        // Then
        Assert.assertNotNull(personPrototype1);
        Assert.assertEquals(NAME, personPrototype1.getName());

        Assert.assertNotNull(personPrototype2);
        Assert.assertEquals(ANOTHER_NAME, personPrototype2.getName());

        context.close();
    }
}
