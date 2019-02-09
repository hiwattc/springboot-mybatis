package com.staroot;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(
        properties = {
                "property.value=propertyTest",
                "value=test"
        },
        //classes = {TestApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class PropertiesTests {
    @Value("${value}")
    private String value;
    
    @Value("${property.value}")
    private String propertyValue;
    
    @Test
    public void contextLoads() {
        assertThat(value.contains("test"));
        assertThat(propertyValue.concat("propertyTest"));
    }
}