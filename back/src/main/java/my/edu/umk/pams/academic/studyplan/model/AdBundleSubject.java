package my.edu.umk.pams.academic.studyplan.model;

import java.util.List;

/**
 * @author rafizan.baharum@canang.com.my
 */
public interface AdBundleSubject extends AdSubject {

    List<AdBundleSubjectPart> getParts();

    void setParts(List<AdBundleSubjectPart> parts);
}
