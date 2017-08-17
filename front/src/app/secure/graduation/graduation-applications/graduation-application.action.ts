import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class GraduationApplicationActions {

  static FIND_ASSIGNED_GRADUATION_APPLICATION_TASKS = '[GraduationApplication] Find Assigned GraduationApplication Tasks';

  findAssignedGraduationApplicationTasks(): Action {
    return {
      type: GraduationApplicationActions.FIND_ASSIGNED_GRADUATION_APPLICATION_TASKS
    };
  }

  static FIND_ASSIGNED_GRADUATION_APPLICATION_TASKS_SUCCESS = '[GraduationApplication] Find Assigned GraduationApplication Tasks Success';

  findAssignedGraduationApplicationTasksSuccess(tasks): Action {
    console.log("findAssignedGraduationApplicationTasksSuccess");
    return {
      type: GraduationApplicationActions.FIND_ASSIGNED_GRADUATION_APPLICATION_TASKS_SUCCESS,
      payload: tasks
    };
  }

  static FIND_POOLED_GRADUATION_APPLICATION_TASKS = '[GraduationApplication] Find Pooled GraduationApplication Tasks';

  findPooledGraduationApplicationTasks(): Action {
    return {
      type: GraduationApplicationActions.FIND_POOLED_GRADUATION_APPLICATION_TASKS
    };
  }

  static FIND_POOLED_GRADUATION_APPLICATION_TASKS_SUCCESS = '[GraduationApplication] Find Pooled GraduationApplication Tasks Success';

  findPooledGraduationApplicationTasksSuccess(tasks): Action {
    console.log("findPooledGraduationApplicationTasksSuccess");
    return {
      type: GraduationApplicationActions.FIND_POOLED_GRADUATION_APPLICATION_TASKS_SUCCESS,
      payload: tasks
    };
  }
  
//archived
  static FIND_ARCHIVED_GRADUATION_APPLICATIONS = '[GraduationApplication] Find Archived GraduationApplication';

  findArchivedGraduationApplications(): Action {
    return {
      type: GraduationApplicationActions.FIND_ARCHIVED_GRADUATION_APPLICATIONS
    };
  }

  static FIND_ARCHIVED_GRADUATION_APPLICATIONS_SUCCESS = '[GraduationApplication] Find Archived GraduationApplication Success';

  findArchivedGraduationApplicationsSuccess(graduationApplications): Action {
    console.log("findArchivedGraduationApplicationsSuccess");
    return {
      type: GraduationApplicationActions.FIND_ARCHIVED_GRADUATION_APPLICATIONS_SUCCESS,
      payload: graduationApplications
    };
  }

  static FIND_GRADUATION_APPLICATION_TASK_BY_TASK_ID = '[GraduationApplication] Find GraduationApplication Task By Task Id';

  findGraduationApplicationTaskByTaskId(taskId): Action {
    console.log("findGraduationApplicationTaskByTaskId");
    return {
      type: GraduationApplicationActions.FIND_GRADUATION_APPLICATION_TASK_BY_TASK_ID,
      payload: taskId
    };
  }

  static FIND_GRADUATION_APPLICATION_TASK_BY_TASK_ID_SUCCESS = '[GraduationApplication] Find GraduationApplication Task By Task Id Success';

  findGraduationApplicationTaskByTaskIdSuccess(task): Action {
    console.log("findGraduationApplicationTaskByTaskIdSuccess");
    return {
      type: GraduationApplicationActions.FIND_GRADUATION_APPLICATION_TASK_BY_TASK_ID_SUCCESS,
      payload: task
    };
  }

  static START_GRADUATION_APPLICATION_TASK = '[GraduationApplication] Start GraduationApplication Task';

  startGraduationApplicationTask(graduationApplication): Action {
    return {
      type: GraduationApplicationActions.START_GRADUATION_APPLICATION_TASK,
      payload: graduationApplication
    };
  }

  static START_GRADUATION_APPLICATION_TASK_SUCCESS = '[GraduationApplication] Start GraduationApplication Task Success';

  startGraduationApplicationTaskSuccess(task): Action {
    return {
      type: GraduationApplicationActions.START_GRADUATION_APPLICATION_TASK_SUCCESS,
      payload: task
    };
  }

  static COMPLETE_GRADUATION_APPLICATION_TASK = '[GraduationApplication] Complete GraduationApplication Task';

  completeGraduationApplicationTask(task): Action {
    return {
      type: GraduationApplicationActions.COMPLETE_GRADUATION_APPLICATION_TASK,
      payload: task
    };
  }

  static COMPLETE_GRADUATION_APPLICATION_TASK_SUCCESS = '[GraduationApplication] Complete GraduationApplication Task Success';

  completeGraduationApplicationTaskSuccess(task): Action {
    return {
      type: GraduationApplicationActions.COMPLETE_GRADUATION_APPLICATION_TASK_SUCCESS,
      payload: task
    };
  }

  static CLAIM_GRADUATION_APPLICATION_TASK = '[GraduationApplication] Claim GraduationApplication Task';

  claimGraduationApplicationTask(invoice): Action {
    return {
      type: GraduationApplicationActions.CLAIM_GRADUATION_APPLICATION_TASK,
      payload: invoice
    };
  }

  static CLAIM_GRADUATION_APPLICATION_TASK_SUCCESS = '[GraduationApplication] Claim GraduationApplication Task Success';

  claimGraduationApplicationTaskSuccess(task): Action {
    return {
      type: GraduationApplicationActions.CLAIM_GRADUATION_APPLICATION_TASK_SUCCESS,
      payload: task
    };
  }

  static RELEASE_GRADUATION_APPLICATION_TASK = '[GraduationApplication] Release GraduationApplication Task';

  releaseGraduationApplicationTask(invoice): Action {
    return {
      type: GraduationApplicationActions.RELEASE_GRADUATION_APPLICATION_TASK,
      payload: invoice
    };
  }

  static RELEASE_GRADUATION_APPLICATION_TASK_SUCCESS = '[GraduationApplication] Release GraduationApplication Task Success';

  releaseGraduationApplicationTaskSuccess(task): Action {
    return {
      type: GraduationApplicationActions.RELEASE_GRADUATION_APPLICATION_TASK_SUCCESS,
      payload: task
    };
  }

  static FIND_GRADUATION_APPLICATION_BY_ID = '[GraduationApplication] Find GraduationApplication By Id';

  findGraduationApplicationById(id): Action {
    return {
      type: GraduationApplicationActions.FIND_GRADUATION_APPLICATION_BY_ID,
      payload: id
    };
  }

  static FIND_GRADUATION_APPLICATION_BY_ID_SUCCESS = '[GraduationApplication] Find GraduationApplication By Id Success';

  findGraduationApplicationByIdSuccess(invoice): Action {
    return {
      type: GraduationApplicationActions.FIND_GRADUATION_APPLICATION_BY_ID_SUCCESS,
      payload: invoice
    };
  }

  static FIND_GRADUATION_APPLICATION_BY_REFERENCE_NO = '[GraduationApplication] Find GraduationApplication By Reference No';

  findGraduationApplicationByReferenceNo(referenceNo): Action {
    return {
      type: GraduationApplicationActions.FIND_GRADUATION_APPLICATION_BY_REFERENCE_NO,
      payload: referenceNo
    };
  }

  static FIND_GRADUATION_APPLICATION_BY_REFERENCE_NO_SUCCESS = '[GraduationApplication] Find GraduationApplication By Reference No Success';

  findGraduationApplicationByReferenceNoSuccess(invoice): Action {
    return {
      type: GraduationApplicationActions.FIND_GRADUATION_APPLICATION_BY_REFERENCE_NO_SUCCESS,
      payload: invoice
    };
  }

  static UPDATE_GRADUATION_APPLICATION = '[GraduationApplication] Update GraduationApplication';

  updateGraduationApplication(invoice): Action {
    return {
      type: GraduationApplicationActions.UPDATE_GRADUATION_APPLICATION,
      payload: invoice
    };
  }

  static UPDATE_GRADUATION_APPLICATION_SUCCESS = '[GraduationApplication] Update GraduationApplication Success';

  updateGraduationApplicationSuccess(invoice): Action {
    return {
      type: GraduationApplicationActions.UPDATE_GRADUATION_APPLICATION_SUCCESS,
      payload: invoice
    };
  }

  static REMOVE_GRADUATION_APPLICATION = '[GraduationApplication] Remove GraduationApplication';

  removeGraduationApplication(invoice): Action {
    return {
      type: GraduationApplicationActions.REMOVE_GRADUATION_APPLICATION,
      payload: invoice
    };
  }

  static REMOVE_GRADUATION_APPLICATION_SUCCESS = '[GraduationApplication] Remove GraduationApplication Success';

  removeGraduationApplicationSuccess(invoice): Action {
    return {
      type: GraduationApplicationActions.REMOVE_GRADUATION_APPLICATION_SUCCESS,
      payload: invoice
    };
  }
}
