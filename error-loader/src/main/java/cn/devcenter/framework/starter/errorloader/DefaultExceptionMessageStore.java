/**
* @Copyright: (c) 2017 DLFC. All rights reserved. 
*
* @name: DefaultExceptionMessageStore.java 
* @description: 
*
* @version: 1.0
* @date : May 25, 2017 
* @author: dean 
*
* @Modification  History:<br>
*  Date          Author         Version        Discription
*  May 25, 2017       dean        1.0             <修改原因描述>
*/

package cn.devcenter.framework.starter.errorloader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @name: DefaultExceptionMessageStore
 * @description:
 * 
 * @version 1.0
 * @author dean
 *
 */
@Slf4j
public class DefaultExceptionMessageStore implements ExceptionMessageStore {

    protected final Properties properties = new Properties();

    private ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    private DefaultExceptionMessageStore() {

    }

    private static class InnerClass {
        private static final DefaultExceptionMessageStore INSTANCE = new DefaultExceptionMessageStore();
    }

    public static DefaultExceptionMessageStore getInstance() {
        return InnerClass.INSTANCE;
    }

    @Override
    public void register(String errorPropertiesPath) {
        Resource[] resources = null;
        try {
            resources = resolver.getResources(errorPropertiesPath);
        } catch (IOException e) {
            log.error("获取错误信息配置文件出错，提供的错误信息配置文件路径为 " + errorPropertiesPath, e);
        }
        InputStream is = null;
        for (Resource resource : resources) {
            try {
                is = resource.getInputStream();
                properties.load(is);
            } catch (IOException e) {
                if (log.isDebugEnabled()) {
                    log.debug("Could not load properties from path:" + errorPropertiesPath, e);
                }
                continue;
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        log.debug("Close reader for classpath:errors.properties in error.", e);
                    }
                    is = null;
                }
            }
        }
    }

    @Override
    public String getExceptionMessage(String exceptionCode) {
        return properties.getProperty(exceptionCode);
    }

}
