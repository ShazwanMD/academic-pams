package my.edu.umk.pams.academic.planner.model;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdBundleSubject extends AdSubject {

	AdSubjectElectiveStatus getSubjectElectiveStatus();

	void setSubjectElectiveStatus(AdSubjectElectiveStatus subjectElectiveStatus);

	List<AdBundleSubjectPart> getParts();

	void setParts(List<AdBundleSubjectPart> parts);
}
