package cn.devcenter.framework.starter.errorloader;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;


/**
 * 异常信息存储的类，使用Properties存储
 *
 * @author gaosong
 *
 */
public class ExceptionMessageProperties {

    private static final String NOT_DEFINE = "异常信息没有定义";

    private static final ExceptionMessageStore MESSAGE_STORE = DefaultExceptionMessageStore
            .getInstance();

    public static String getExceptionMessage(String exceptionCode) {
        String exceptionMessage = MESSAGE_STORE.getExceptionMessage(exceptionCode);
        if (StringUtils.isBlank(exceptionMessage)) {
            return NOT_DEFINE;
        }
        return exceptionMessage;
    }

    public static String getExceptionMessage(String exceptionCode, Object... parameters) {
        return MessageFormat.format(getExceptionMessage(exceptionCode), parameters);
    }

}
