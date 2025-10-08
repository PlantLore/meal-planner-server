package com.davis.mealplanner.security.props;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({CorsConfigurationProps.class})
public class PropsConfiguration {

}