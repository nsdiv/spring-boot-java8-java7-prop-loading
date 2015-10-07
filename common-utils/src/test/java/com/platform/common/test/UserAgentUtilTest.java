package com.platform.common.test;

import com.platform.common.rest.RestClientSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ActiveProfiles("default,test")
@SpringApplicationConfiguration(classes = TestContext.class)
public class UserAgentUtilTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RestClientSettings restClientSettings;

    @Test
    public void someTest(){
        Assert.assertEquals(restClientSettings.getConnectionTimeoutMillis(), 40000);
    }

}
