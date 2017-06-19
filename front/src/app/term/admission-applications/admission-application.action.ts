import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';

@Injectable()
export class AdmissionApplicationActions {


  static FIND_ADMISSION_APPLICATIONS = '[AdmissionApplication] Find Admission Application';
  findAdmissionApplications(): Action {
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATIONS
    };
  }

  static FIND_ADMISSION_APPLICATIONS_SUCCESS = '[AdmissionApplication] Find Admission Application Success';
  findAdmissionApplicationsSuccess(message): Action {
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATIONS_SUCCESS,
      payload: message
    };
  }


  static FIND_ASSIGNED_ADMISSION_APPLICATION_TASKS = '[AdmissionApplication] Find Assigned AdmissionApplication Tasks';
  findAssignedAdmissionApplicationTasks(): Action {
    return {
      type: AdmissionApplicationActions.FIND_ASSIGNED_ADMISSION_APPLICATION_TASKS
    };
  }

  static FIND_ASSIGNED_ADMISSION_APPLICATION_TASKS_SUCCESS = '[AdmissionApplication] Find Assigned AdmissionApplication Tasks Success';
  findAssignedAdmissionApplicationTasksSuccess(tasks): Action {
    console.log("findAssignedAdmissionApplicationTasksSuccess");
    return {
      type: AdmissionApplicationActions.FIND_ASSIGNED_ADMISSION_APPLICATION_TASKS_SUCCESS,
      payload: tasks
    };
  }

  static FIND_POOLED_ADMISSION_APPLICATION_TASKS = '[AdmissionApplication] Find Pooled AdmissionApplication Tasks';
  findPooledAdmissionApplicationTasks(): Action {
    return {
      type: AdmissionApplicationActions.FIND_POOLED_ADMISSION_APPLICATION_TASKS
    };
  }

  static FIND_POOLED_ADMISSION_APPLICATION_TASKS_SUCCESS = '[AdmissionApplication] Find Pooled AdmissionApplication Tasks Success';
  findPooledAdmissionApplicationTasksSuccess(tasks): Action {
    console.log("findAssignedAdmissionApplicationTasksSuccess");
    return {
      type: AdmissionApplicationActions.FIND_POOLED_ADMISSION_APPLICATION_TASKS_SUCCESS,
      payload: tasks
    };
  }

  static FIND_ADMISSION_APPLICATION_TASK_BY_TASK_ID = '[AdmissionApplication] Find AdmissionApplication Task By Task Id';
  findAdmissionApplicationTaskByTaskId(taskId): Action {
    console.log("findAdmissionApplicationTaskByTaskId");
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_TASK_BY_TASK_ID,
      payload: taskId
    };
  }

  static FIND_ADMISSION_APPLICATION_TASK_BY_TASK_ID_SUCCESS = '[AdmissionApplication] Find AdmissionApplication Task By Task Id Success';
  findAdmissionApplicationTaskByTaskIdSuccess(task): Action {
    console.log("findAdmissionApplicationTaskByTaskIdSuccess");
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_TASK_BY_TASK_ID_SUCCESS,
      payload: task
    };
  }

  static START_ADMISSION_APPLICATION_TASK = '[AdmissionApplication] Start AdmissionApplication Task';
  startAdmissionApplicationTask(application): Action {
    return {
      type: AdmissionApplicationActions.START_ADMISSION_APPLICATION_TASK,
      payload: application
    };
  }

  static START_ADMISSION_APPLICATION_TASK_SUCCESS = '[AdmissionApplication] Start AdmissionApplication Task Success';
  startAdmissionApplicationTaskSuccess(task): Action {
    return {
      type: AdmissionApplicationActions.START_ADMISSION_APPLICATION_TASK_SUCCESS,
      payload: task
    };
  }

  static COMPLETE_ADMISSION_APPLICATION_TASK = '[AdmissionApplication] Complete AdmissionApplication Task';
  completeAdmissionApplicationTask(application): Action {
    return {
      type: AdmissionApplicationActions.COMPLETE_ADMISSION_APPLICATION_TASK,
      payload: application
    };
  }

  static COMPLETE_ADMISSION_APPLICATION_TASK_SUCCESS = '[AdmissionApplication] Complete AdmissionApplication Task Success';
  completeAdmissionApplicationTaskSuccess(message): Action {
    return {
      type: AdmissionApplicationActions.COMPLETE_ADMISSION_APPLICATION_TASK_SUCCESS,
      payload: message
    };
  }

  static CLAIM_ADMISSION_APPLICATION_TASK = '[AdmissionApplication] Assign AdmissionApplication Task';
  claimAdmissionApplicationTask(application): Action {
    return {
      type: AdmissionApplicationActions.CLAIM_ADMISSION_APPLICATION_TASK,
      payload: application
    };
  }

  static CLAIM_ADMISSION_APPLICATION_TASK_SUCCESS = '[AdmissionApplication] Assign AdmissionApplication Task Success';
  claimAdmissionApplicationTaskSuccess(task): Action {
    return {
      type: AdmissionApplicationActions.CLAIM_ADMISSION_APPLICATION_TASK_SUCCESS,
      payload: task
    };
  }

  static RELEASE_ADMISSION_APPLICATION_TASK = '[AdmissionApplication] Release AdmissionApplication Task';
  releaseAdmissionApplicationTask(application): Action {
    return {
      type: AdmissionApplicationActions.RELEASE_ADMISSION_APPLICATION_TASK,
      payload: application
    };
  }

  static RELEASE_ADMISSION_APPLICATION_TASK_SUCCESS = '[AdmissionApplication] Release AdmissionApplication Task Success';
  releaseAdmissionApplicationTaskSuccess(task): Action {
    return {
      type: AdmissionApplicationActions.RELEASE_ADMISSION_APPLICATION_TASK_SUCCESS,
      payload: task
    };
  }

  static FIND_ADMISSION_APPLICATION_BY_ID = '[AdmissionApplication] Find AdmissionApplication By Id';
  findAdmissionApplicationById(id): Action {
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_BY_ID,
      payload: id
    };
  }

  static FIND_ADMISSION_APPLICATION_BY_ID_SUCCESS = '[AdmissionApplication] Find AdmissionApplication By Id Success';
  findAdmissionApplicationByIdSuccess(application): Action {
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_BY_ID_SUCCESS,
      payload: application
    };
  }

  static FIND_ADMISSION_APPLICATION_BY_REFERENCE_NO = '[AdmissionApplication] Find AdmissionApplication By Reference No';
  findAdmissionApplicationByReferenceNo(referenceNo): Action {
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_BY_REFERENCE_NO,
      payload: referenceNo
    };
  }

  static FIND_ADMISSION_APPLICATION_BY_REFERENCE_NO_SUCCESS = '[AdmissionApplication] Find AdmissionApplication By Reference No Success';
  findAdmissionApplicationByReferenceNoSuccess(admissionApplication): Action {
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_BY_REFERENCE_NO_SUCCESS,
      payload: admissionApplication
    };
  }

  static FIND_ADMISSION_APPLICATION_ITEMS = '[AdmissionApplication] Find AdmissionApplication Items';
  findAdmissionApplicationItems(application): Action {
    console.log("findAdmissionApplicationItems for application: " + application);
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_ITEMS,
      payload: application
    };
  }

  static FIND_ADMISSION_APPLICATION_ITEMS_SUCCESS = '[AdmissionApplication] Find AdmissionApplication Items Success';
  findAdmissionApplicationItemsSuccess(items): Action {
    console.log("findAdmissionApplicationItemsSuccess");
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_ITEMS_SUCCESS,
      payload: items
    };
  }


  static UPDATE_ADMISSION_APPLICATION = '[AdmissionApplication] Update AdmissionApplication';
  updateAdmissionApplication(application): Action {
    return {
      type: AdmissionApplicationActions.UPDATE_ADMISSION_APPLICATION,
      payload: application
    };
  }

  static UPDATE_ADMISSION_APPLICATION_SUCCESS = '[AdmissionApplication] Update AdmissionApplication Success';
  updateAdmissionApplicationSuccess(application): Action {
    return {
      type: AdmissionApplicationActions.UPDATE_ADMISSION_APPLICATION_SUCCESS,
      payload: application
    };
  }

  static SAVE_ADMISSION_APPLICATION = '[AdmissionApplication] Save AdmissionApplication';
  saveAdmissionApplication(admissionApplication): Action {
    return {
      type: AdmissionApplicationActions.SAVE_ADMISSION_APPLICATION,
      payload: admissionApplication
    };
  }

  static SAVE_ADMISSION_APPLICATION_SUCCESS = '[AdmissionApplication] Save AdmissionApplication Success';
  saveAdmissionApplicationSuccess(admissionApplication): Action {
    return {
      type: AdmissionApplicationActions.SAVE_ADMISSION_APPLICATION_SUCCESS,
      payload: admissionApplication
    };
  }
  static REMOVE_ADMISSION_APPLICATION = '[AdmissionApplication] Remove AdmissionApplication';

  removeAdmissionApplication(application): Action {
    return {
      type: AdmissionApplicationActions.REMOVE_ADMISSION_APPLICATION,
      payload: application
    };
  }

  static REMOVE_ADMISSION_APPLICATION_SUCCESS = '[AdmissionApplication] Remove AdmissionApplication Success';
  removeAdmissionApplicationSuccess(application): Action {
    return {
      type: AdmissionApplicationActions.REMOVE_ADMISSION_APPLICATION_SUCCESS,
      payload: application
    };
  }

}
