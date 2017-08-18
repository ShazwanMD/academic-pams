package my.edu.umk.pams.academic.graduation.service;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;

import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author PAMS
 */
public interface GraduationService {

    // ==================================================================================================== //
    // GRADUATION APPLICATION
    // ==================================================================================================== //

    // workflow
    AdGraduationApplication findGraduationApplicationByTaskId(String taskId);

    Task findGraduationApplicationTaskByTaskId(String taskId);

    List<Task> findAssignedGraduationApplicationTasks(Integer offset, Integer limit);

    List<Task> findPooledGraduationApplicationTasks(Integer offset, Integer limit);
    
    List<AdGraduationApplication> findGraduationApplicationsByFlowStates(AdFlowState... flowStates);

    String startGraduationApplicationTask(AdGraduationApplication application);

    void updateGraduationApplication(AdGraduationApplication application);

    void cancelGraduationApplication(AdGraduationApplication application);

    // ==================================================================================================== //
    // GRADUATION APPLICATION
    // ==================================================================================================== //

    AdGraduationApplication findGraduationApplicationById(Long id);

    AdGraduationApplication findGraduationApplicationByReferenceNo(String referenceNo);

    List<AdGraduationApplication> findGraduationApplications(String filter, Integer offset, Integer limit);

    List<AdGraduationApplication> findGraduationApplications(AdAcademicSession academicSession, Integer offset, Integer limit);

    Integer countGraduationApplication(String filter);

    Integer countGraduationApplication(AdAcademicSession academicSession);
}
