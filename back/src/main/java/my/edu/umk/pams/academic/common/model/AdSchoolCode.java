package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * SMS,
 * SBP,
 * SBPI,
 * MRSM,
 * SMK,
 * SMAT,
 * SMAP,
 * SMA,
 * SMKA,
 * SMV,
 * SMT,
 * SEKOLAH,
 * KOLEJ
 */
public interface AdSchoolCode extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

}
