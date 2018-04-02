package cn.devcenter.framework.starter.errorloader.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 从aplication{-profile}.properties中获取mybatis配置数据 数据源配置前缀为dlfc.mybatis
 *
 * @author gaosong
 */
@ConfigurationProperties(prefix = ErrorConfigProperties.PREFIX)
public class ErrorConfigProperties {

    public static final String PREFIX = "dlfc.error.config";

    private String file = "classpath*:ValidationMessages.properties";

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
