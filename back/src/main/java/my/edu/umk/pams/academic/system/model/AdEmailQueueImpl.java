package my.edu.umk.pams.academic.system.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "AdEmailQueue")
@Table(name = "AD_EMAL_QUEU")
public class AdEmailQueueImpl implements AdEmailQueue {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_EMAL_QUEU")
    @SequenceGenerator(name = "SQ_AD_EMAL_QUEU", sequenceName = "SQ_AD_EMAL_QUEU", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "EMAIL_TO")
    private String to;

    @Column(name = "EMAIL_CC")
    private String cc;

    @Column(name = "EMAIL_BCC")
    private String bcc;

    @NotNull
    @Column(name = "SUBJECT")
    private String subject;

    @Lob
    @Column(name = "BODY")
    private String body;

    @Column(name = "RETRY_COUNT")
    private Integer retryCount;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "QUEUE_STATUS")
    private AdEmailQueueStatus queueStatus;

    @Embedded
    private AdMetadata metadata;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public AdEmailQueueStatus getQueueStatus() {
        return queueStatus;
    }

    public void setQueueStatus(AdEmailQueueStatus queueStatus) {
        this.queueStatus = queueStatus;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdEmailQueue.class;
    }
}
