package my.edu.umk.pams.academic.system.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface AdEmailQueue extends AdMetaObject {

    String getTo();

    String getCc();

    String getBcc();

    String getSubject();

    String getBody();

    Integer getRetryCount();

    String getCode();

    void setCode(String code);

    void setTo(String to);

    void setSubject(String subject);

    void setBody(String body);

    void setRetryCount(Integer retryCount);

    AdEmailQueueStatus getQueueStatus();

    void setQueueStatus(AdEmailQueueStatus status);

}
