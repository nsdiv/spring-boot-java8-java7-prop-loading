package com.platform.common.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.platform"})
//Anything in the base package and down will be scanned.
//Most defaults are going to take effect based on what is in the classpath
@EnableAutoConfiguration
public class TestContext {

}
