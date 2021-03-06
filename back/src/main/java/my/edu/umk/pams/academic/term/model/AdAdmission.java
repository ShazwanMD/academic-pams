package my.edu.umk.pams.academic.term.model;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * KUMULATIVE KREDIT
 * <p/>
 * KREDIT DAPAT = CREDIT TAKEN
 * <p/>
 * KREDIT KIRA = CREDIT EARNED
 * <p/>
 * (1) Pelajar hendaklah membuat pendaftaran program yang ditawarkan pada tarikh
 * yang ditetapkan oleh Universiti.
 * <p/>
 * (2) Pelajar yang tidak mematuhi perkara di atas tanpa sebab-sebab yang boleh
 * diterima oleh Universiti, dengan sendirinya tawaran program kepadanya
 * TERBATAL.
 * <p/>
 * (3) Pendaftaran program bagi pelajar kanan dibuat secara automatik oleh
 * pentadbiran Universiti berdasarkan kepada keputusan peperiksaan semester
 * sebelumnya.
 * <p/>
 * (4) Pelajar kanan yang berstatus tangguh pengajian atau digantung pengajian
 * hendaklah membuat pendaftaran program semula. Jika pelajar gagal membuat
 * pendaftaran program dalam tempoh yang ditetapkan pelajar akan diberhentikan.
 * <p/>
 * (5) Pelajar kanan yang diluluskan mengikuti Program Minor hendaklah membuat
 * pendaftaran program tersebut di Fakulti pelajar pada tarikh yang ditetapkan
 * oleh Universiti.
 *
 * @author PAMS
 */
public interface AdAdmission extends AdMetaObject {

	BigDecimal getGpa();

	void setGpa(BigDecimal gpa);

	BigDecimal getCgpa();

	void setCgpa(BigDecimal cgpa);

	Integer getCreditTaken(); // kira

	void setCreditTaken(Integer CreditTaken);

	Integer getCreditEarned(); // dapat

	void setCreditEarned(Integer CreditEarned);

	Integer getOrdinal(); // semester taken by student

	void setOrdinal(Integer Ordinal);

	AdStudent getStudent();

	void setStudent(AdStudent student);

	AdStaff getAdvisor();

	void setAdvisor(AdStaff advisor);

	AdAdmissionStatus getStatus();

	void setStatus(AdAdmissionStatus status);

	AdAcademicStanding getStanding();

	void setStanding(AdAcademicStanding standing);

	AdStudyCenter getStudyCenter();

	void setStudyCenter(AdStudyCenter studyCenter);

	AdAcademicSession getSession();

	void setSession(AdAcademicSession session);

	AdCohort getCohort();

	void setCohort(AdCohort cohort);

	List<AdEnrollment> getEnrollments();

	void setEnrollments(List<AdEnrollment> enrollments);

	Integer getEnrollmentCount();

	void setEnrollmentCount(Integer enrollmentCount);

	List<AdEnrollmentApplication> getEnrollmentApplications();

	void setEnrollmentApplications(List<AdEnrollmentApplication> enrollmentApplications);

	Integer getEnrollmentApplicationCount();

	void setEnrollmentApplicationCount(Integer enrollmentApplicationCount);
}
