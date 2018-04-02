/**
* @Copyright: (c) 2017 DLFC. All rights reserved. 
*
* @name: ExceptionMessageStore.java 
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

/**
 * @name: ExceptionMessageStore
 * @description: 
 * 
 * @version 1.0
 * @author dean
 *
 */
public interface ExceptionMessageStore {
    
    void register(String errorPropertiesPath);
    
    String getExceptionMessage(String exceptionCode);

}
