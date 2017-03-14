package my.edu.umk.pams.academic.studyplan.model;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdBundleSubject extends AdSubject {

    List<AdBundleSubjectPart> getParts();

    void setParts(List<AdBundleSubjectPart> parts);
}
