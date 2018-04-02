package cn.devcenter.framework.starter.errorloader;

import cn.devcenter.framework.starter.errorloader.config.property.ErrorConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * 从配置文件获取错误信息
 *
 * @author gaosong
 */
public class ExceptionMessageLoader implements CommandLineRunner {

    @Autowired
    private ErrorConfigProperties errorConfigProperties;

    @Override
    public void run(String... strings) throws Exception {
        DefaultExceptionMessageStore.getInstance().register(errorConfigProperties.getFile());
    }
}
