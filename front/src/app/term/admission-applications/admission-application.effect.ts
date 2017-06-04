import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AdmissionApplicationActions} from "./admission-application.action";
import {from} from "rxjs/observable/from";
import {TermService} from "../../../services/term.service";
import {TermModuleState} from "../index";
import {Store} from "@ngrx/store";
import 'rxjs/add/operator/withLatestFrom';


@Injectable()
export class AdmissionApplicationEffects {

  private ADMISSION_APPLICATION_TASK: string[] = "termModuleState.admissionApplicationTask".split(".");

  constructor(private actions$: Actions,
              private admissionApplicationActions: AdmissionApplicationActions,
              private termService: TermService,
              private store$: Store<TermModuleState>) {
  }

@Effect() findAdmissionApplications$ = this.actions$
    .ofType(AdmissionApplicationActions.FIND_ADMISSION_APPLICATIONS)
    .switchMap(() => this.termService.findAdmissionApplications())
    .map(message => this.admissionApplicationActions.findAdmissionApplicationsSuccess(message));



  @Effect() findAssignedAdmissionApplicationTasks$ = this.actions$
    .ofType(AdmissionApplicationActions.FIND_ASSIGNED_ADMISSION_APPLICATION_TASKS)
    .switchMap(() => this.termService.findAssignedAdmissionApplicationTasks())
    .map(admissionApplications => this.admissionApplicationActions.findAssignedAdmissionApplicationTasksSuccess(admissionApplications));


  @Effect() findPooledAdmissionApplicationTasks$ = this.actions$
    .ofType(AdmissionApplicationActions.FIND_POOLED_ADMISSION_APPLICATION_TASKS)
    .switchMap(() => this.termService.findPooledAdmissionApplicationTasks())
    .map(admissionApplications => this.admissionApplicationActions.findPooledAdmissionApplicationTasksSuccess(admissionApplications));

  @Effect() findAdmissionApplicationTaskByTaskId = this.actions$
    .ofType(AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_TASK_BY_TASK_ID)
    .map(action => action.payload)
    .switchMap(taskId => this.termService.findAdmissionApplicationTaskByTaskId(taskId))
    .map(task => this.admissionApplicationActions.findAdmissionApplicationTaskByTaskIdSuccess(task));

  @Effect() findAdmissionApplicationByReferenceNo$ = this.actions$
    .ofType(AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_BY_REFERENCE_NO)
    .map(action => action.payload)
    .switchMap(referenceNo => this.termService.findAdmissionApplicationByReferenceNo(referenceNo))
    .map(admissionApplication => this.admissionApplicationActions.findAdmissionApplicationByReferenceNoSuccess(admissionApplication));

  @Effect() findAdmissionApplicationItems$ = this.actions$
    .ofType(AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_ITEMS)
    .map(action => action.payload)
    .switchMap(admissionApplication => this.termService.findAdmissionApplicationItems(admissionApplication))
    .map(items => this.admissionApplicationActions.findAdmissionApplicationItemsSuccess(items));

  @Effect() startAdmissionApplicationTask$ = this.actions$
    .ofType(AdmissionApplicationActions.START_ADMISSION_APPLICATION_TASK)
    .map(action => action.payload)
    .switchMap(admissionApplication => this.termService.startAdmissionApplicationTask(admissionApplication))
    .map(message => this.admissionApplicationActions.startAdmissionApplicationTaskSuccess(message))
    .mergeMap(action => from([action,
        this.admissionApplicationActions.findAssignedAdmissionApplicationTasks(),
        this.admissionApplicationActions.findPooledAdmissionApplicationTasks()
      ]
    ));

  @Effect() completeAdmissionApplicationTask$ = this.actions$
    .ofType(AdmissionApplicationActions.COMPLETE_ADMISSION_APPLICATION_TASK)
    .map(action => action.payload)
    .switchMap(admissionApplicationTask => this.termService.completeAdmissionApplicationTask(admissionApplicationTask))
    .map(message => this.admissionApplicationActions.completeAdmissionApplicationTaskSuccess(message))
    .mergeMap(action => from([action,
        this.admissionApplicationActions.findAssignedAdmissionApplicationTasks(),
        this.admissionApplicationActions.findPooledAdmissionApplicationTasks()
      ]
    ));

  @Effect() claimAdmissionApplicationTask$ = this.actions$
    .ofType(AdmissionApplicationActions.CLAIM_ADMISSION_APPLICATION_TASK)
    .map(action => action.payload)
    .switchMap(admissionApplicationTask => this.termService.claimAdmissionApplicationTask(admissionApplicationTask))
    .map(message => this.admissionApplicationActions.claimAdmissionApplicationTaskSuccess(message))
    .mergeMap(action => from([action,
        this.admissionApplicationActions.findAssignedAdmissionApplicationTasks(),
        this.admissionApplicationActions.findPooledAdmissionApplicationTasks()
      ]
    ));

  @Effect() releaseAdmissionApplicationTask$ = this.actions$
    .ofType(AdmissionApplicationActions.RELEASE_ADMISSION_APPLICATION_TASK)
    .map(action => action.payload)
    .switchMap(admissionApplicationTask => this.termService.releaseAdmissionApplicationTask(admissionApplicationTask))
    .map(message => this.admissionApplicationActions.releaseAdmissionApplicationTaskSuccess(message))
    .mergeMap(action => from([action,
        this.admissionApplicationActions.findAssignedAdmissionApplicationTasks(),
        this.admissionApplicationActions.findPooledAdmissionApplicationTasks()
      ]
    ));

  @Effect() saveAdmissionApplication$ = this.actions$
    .ofType(AdmissionApplicationActions.SAVE_ADMISSION_APPLICATION)
    .map(action => action.payload)
    .switchMap(payload => this.termService.saveAdmissionApplication(payload.admissionApplication))
    .map(message => this.admissionApplicationActions.saveAdmissionApplicationSuccess(message))
    .mergeMap(action => from([action,
      this.admissionApplicationActions.findAdmissionApplications()
    ]
  ));

  @Effect() updateAdmissionApplication$ = this.actions$
    .ofType(AdmissionApplicationActions.UPDATE_ADMISSION_APPLICATION)
    .map(action => action.payload)
    .switchMap(admissionApplication => this.termService.updateAdmissionApplication(admissionApplication))
    .map(admissionApplication => this.admissionApplicationActions.updateAdmissionApplicationSuccess(admissionApplication));

  @Effect() addAdmissionApplicationItem$ =
    this.actions$
      .ofType(AdmissionApplicationActions.ADD_ADMISSION_APPLICATION_ITEM)
      .map(action => action.payload)
      .switchMap(payload => this.termService.addAdmissionApplicationItem(payload.admissionApplication, payload.item))
      .map(message => this.admissionApplicationActions.addAdmissionApplicationItemSuccess(message))
      .withLatestFrom(this.store$.select(...this.ADMISSION_APPLICATION_TASK))
      .map(state => state[1])
      .map(admissionApplication => this.admissionApplicationActions.findAdmissionApplicationItems(admissionApplication));
}
