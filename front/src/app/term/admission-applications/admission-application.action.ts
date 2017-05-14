import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AdmissionApplicationActions {

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

  startAdmissionApplicationTask(invoice): Action {
    return {
      type: AdmissionApplicationActions.START_ADMISSION_APPLICATION_TASK,
      payload: invoice
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

  completeAdmissionApplicationTask(invoice): Action {
    return {
      type: AdmissionApplicationActions.COMPLETE_ADMISSION_APPLICATION_TASK,
      payload: invoice
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

  claimAdmissionApplicationTask(invoice): Action {
    return {
      type: AdmissionApplicationActions.CLAIM_ADMISSION_APPLICATION_TASK,
      payload: invoice
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

  releaseAdmissionApplicationTask(invoice): Action {
    return {
      type: AdmissionApplicationActions.RELEASE_ADMISSION_APPLICATION_TASK,
      payload: invoice
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

  findAdmissionApplicationByIdSuccess(invoice): Action {
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_BY_ID_SUCCESS,
      payload: invoice
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

  findAdmissionApplicationByReferenceNoSuccess(invoice): Action {
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_BY_REFERENCE_NO_SUCCESS,
      payload: invoice
    };
  }

  static FIND_ADMISSION_APPLICATION_ITEMS = '[AdmissionApplication] Find AdmissionApplication Items';

  findAdmissionApplicationItems(invoice): Action {
    console.log("findAdmissionApplicationItems for invoice: " + invoice);
    return {
      type: AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_ITEMS,
      payload: invoice
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

  updateAdmissionApplication(invoice): Action {
    return {
      type: AdmissionApplicationActions.UPDATE_ADMISSION_APPLICATION,
      payload: invoice
    };
  }

  static UPDATE_ADMISSION_APPLICATION_SUCCESS = '[AdmissionApplication] Update AdmissionApplication Success';

  updateAdmissionApplicationSuccess(invoice): Action {
    return {
      type: AdmissionApplicationActions.UPDATE_ADMISSION_APPLICATION_SUCCESS,
      payload: invoice
    };
  }

  static REMOVE_ADMISSION_APPLICATION = '[AdmissionApplication] Remove AdmissionApplication';

  removeAdmissionApplication(invoice): Action {
    return {
      type: AdmissionApplicationActions.REMOVE_ADMISSION_APPLICATION,
      payload: invoice
    };
  }

  static REMOVE_ADMISSION_APPLICATION_SUCCESS = '[AdmissionApplication] Remove AdmissionApplication Success';

  removeAdmissionApplicationSuccess(invoice): Action {
    return {
      type: AdmissionApplicationActions.REMOVE_ADMISSION_APPLICATION_SUCCESS,
      payload: invoice
    };
  }

  static ADD_ADMISSION_APPLICATION_ITEM = '[AdmissionApplication] Add AdmissionApplication Item';

  addAdmissionApplicationItem(invoice, item): Action {
    return {
      type: AdmissionApplicationActions.ADD_ADMISSION_APPLICATION_ITEM,
      payload: {invoice:invoice, item:item}
    };
  }

  static ADD_ADMISSION_APPLICATION_ITEM_SUCCESS = '[AdmissionApplication] Add AdmissionApplication Item Success';

  addAdmissionApplicationItemSuccess(message): Action {
    return {
      type: AdmissionApplicationActions.ADD_ADMISSION_APPLICATION_ITEM_SUCCESS,
      payload: message
    };
  }

}
