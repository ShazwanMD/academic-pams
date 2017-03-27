package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

public interface AdBankCode extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getSwiftCode();

    void setSwiftCode(String swiftCode);

    String getIbgCode();

    void setIbgCode(String ibgCode);

    String getName();

    void setName(String description);
}
