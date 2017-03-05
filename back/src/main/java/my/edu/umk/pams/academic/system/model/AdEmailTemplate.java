package my.edu.umk.pams.academic.system.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author canang technologies
 * @since 9/4/2016.
 */
public interface AdEmailTemplate extends AdMetaObject {

    /**
     * get code
     *
     * @return code
     */
    String getCode();

    void setCode(String code);

    /**
     * get description
     *
     * @return description
     */
    String getDescription();

    void setDescription(String description);

    /**
     * get subject
     *
     * @return subject
     */
    String getSubject();

    void setSubject(String subject);

    /**
     * get to address
     *
     * @return address
     */
    String getTo();

    void setTo(String to);

    /**
     * get cc address
     *
     * @return address
     */
    String getCc();

    void setCc(String cc);

    /**
     * get bcc address
     *
     * @return address
     */
    String getBcc();

    void setBcc(String bcc);

    /**
     * get email template
     *
     * @return template
     */
    String getTemplate();

    void setTemplate(String template);

}
