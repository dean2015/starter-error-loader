package cn.devcenter.framework.starter.errorloader.config;

import cn.devcenter.framework.starter.errorloader.ExceptionMessageLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @version 1.0
 * @author gaosong
 *
 */
@Configuration
public class ErrorMessageConfig {

    @Bean
    public ExceptionMessageLoader getExceptionMessageLoader() {
        return new ExceptionMessageLoader();
    }

}
