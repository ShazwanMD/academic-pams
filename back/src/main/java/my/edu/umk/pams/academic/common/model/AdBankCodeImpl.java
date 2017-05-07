package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "AdBankCode")
@Table(name = "AD_BANK_CODE")
public class AdBankCodeImpl implements AdBankCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_BANK_CODE")
    @SequenceGenerator(name = "SQ_AD_BANK_CODE", sequenceName = "SQ_AD_BANK_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "SWIFT_CODE", unique = true, nullable = false)
    private String swiftCode;

    @NotNull
    @Column(name = "IBG_CODE", unique = true, nullable = false)
    private String ibgCode;

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
    public String getSwiftCode() {
        return swiftCode;
    }

    @Override
    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    @Override
    public String getIbgCode() {
        return ibgCode;
    }

    @Override
    public void setIbgCode(String ibgCode) {
        this.ibgCode = ibgCode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
        return AdBankCode.class;
    }
}
