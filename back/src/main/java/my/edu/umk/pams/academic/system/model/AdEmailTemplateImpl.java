package my.edu.umk.pams.academic.system.model;

import my.edu.umk.pams.academic.core.AdMetadata;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @author canang technologies
 * @since 9/4/2016.
 */
@Entity(name = "AdEmailTemplate")
@Table(name = "AD_EMIL_TMPT")
public class AdEmailTemplateImpl implements AdEmailTemplate {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_EMIL_TMPT")
    @SequenceGenerator(name = "SQ_AD_EMIL_TMPT", sequenceName = "SQ_AD_EMIL_TMPT", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SUBJECT")
    private String subject;

    @Lob
    @Column(name = "TEMPLATE", columnDefinition = "TEXT")// postgres
    @Type(type = "org.hibernate.type.TextType")
    private String template;

    @Column(name = "TO_ADDRESS", nullable = true)
    private String to;

    @Column(name = "CC_ADDRESS", nullable = true)
    private String cc;

    @Column(name = "BCC_ADDRESS", nullable = true)
    private String bcc;

    @Embedded
    private AdMetadata metadata;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String getCc() {
        return cc;
    }

    @Override
    public void setCc(String cc) {
        this.cc = cc;
    }

    @Override
    public String getBcc() {
        return bcc;
    }

    @Override
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    @Override
    public String getTemplate() {
        return template;
    }

    @Override
    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdEmailTemplate.class;
    }
}
