package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * STUDY MODE :-
 * UNDECIDED
 * FULL-TIME
 * PART-TIME
 *
 */
public interface AdStudyMode extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getPrefix();

    void setPrefix(String prefix);

    String getDescription();

    void setDescription(String description);
}
