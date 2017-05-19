import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {EnrollmentApplicationActions} from "./enrollment-application.action";
import {from} from "rxjs/observable/from";
import {TermService} from "../../../services/term.service";
import {TermModuleState} from "../index";
import {Store} from "@ngrx/store";
import 'rxjs/add/operator/withLatestFrom';
import {EnrollmentApplicationTask} from "./enrollment-application-task.interface";


@Injectable()
export class EnrollmentApplicationEffects {

  private ENROLLMENT_APPLICATION_TASK: string[] = "termModuleState.enrollmentApplicationTask".split(".");

  constructor(private actions$: Actions,
              private enrollmentApplicationActions: EnrollmentApplicationActions,
              private termService: TermService,
              private store$: Store<TermModuleState>) {
  }

  @Effect() findAssignedEnrollmentApplicationTasks$ = this.actions$
    .ofType(EnrollmentApplicationActions.FIND_ASSIGNED_ENROLLMENT_APPLICATION_TASKS)
    .switchMap(() => this.termService.findAssignedEnrollmentApplicationTasks())
    .map(enrollmentApplications => this.enrollmentApplicationActions.findAssignedEnrollmentApplicationTasksSuccess(enrollmentApplications));


  @Effect() findPooledEnrollmentApplicationTasks$ = this.actions$
    .ofType(EnrollmentApplicationActions.FIND_POOLED_ENROLLMENT_APPLICATION_TASKS)
    .switchMap(() => this.termService.findPooledEnrollmentApplicationTasks())
    .map(enrollmentApplications => this.enrollmentApplicationActions.findPooledEnrollmentApplicationTasksSuccess(enrollmentApplications));

  @Effect() findEnrollmentApplicationTaskByTaskId = this.actions$
    .ofType(EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_TASK_BY_TASK_ID)
    .map(action => action.payload)
    .switchMap(taskId => this.termService.findEnrollmentApplicationTaskByTaskId(taskId))
    .map(task => this.enrollmentApplicationActions.findEnrollmentApplicationTaskByTaskIdSuccess(task));

  @Effect() findEnrollmentApplicationByReferenceNo$ = this.actions$
    .ofType(EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_BY_REFERENCE_NO)
    .map(action => action.payload)
    .switchMap(referenceNo => this.termService.findEnrollmentApplicationByReferenceNo(referenceNo))
    .map(enrollmentApplication => this.enrollmentApplicationActions.findEnrollmentApplicationByReferenceNoSuccess(enrollmentApplication))
    .mergeMap(action => from([action, this.enrollmentApplicationActions.findEnrollmentApplicationItems(action.payload)]));

  @Effect() findEnrollmentApplicationItems$ = this.actions$
    .ofType(EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_ITEMS)
    .map(action => action.payload)
    .switchMap(enrollmentApplication => this.termService.findEnrollmentApplicationItems(enrollmentApplication))
    .map(items => this.enrollmentApplicationActions.findEnrollmentApplicationItemsSuccess(items));

  @Effect() startEnrollmentApplicationTask$ = this.actions$
    .ofType(EnrollmentApplicationActions.START_ENROLLMENT_APPLICATION_TASK)
    .map(action => action.payload)
    .switchMap(enrollmentApplication => this.termService.startEnrollmentApplicationTask(enrollmentApplication))
    .map(message => this.enrollmentApplicationActions.startEnrollmentApplicationTaskSuccess(message))
    .mergeMap(action => from([action,
        this.enrollmentApplicationActions.findAssignedEnrollmentApplicationTasks(),
        this.enrollmentApplicationActions.findPooledEnrollmentApplicationTasks()
      ]
    ));

  @Effect() completeEnrollmentApplicationTask$ = this.actions$
    .ofType(EnrollmentApplicationActions.COMPLETE_ENROLLMENT_APPLICATION_TASK)
    .map(action => action.payload)
    .switchMap(enrollmentApplicationTask => this.termService.completeEnrollmentApplicationTask(enrollmentApplicationTask))
    .map(message => this.enrollmentApplicationActions.completeEnrollmentApplicationTaskSuccess(message))
    .mergeMap(action => from([action,
        this.enrollmentApplicationActions.findAssignedEnrollmentApplicationTasks(),
        this.enrollmentApplicationActions.findPooledEnrollmentApplicationTasks()
      ]
    ));

  @Effect() claimEnrollmentApplicationTask$ = this.actions$
    .ofType(EnrollmentApplicationActions.CLAIM_ENROLLMENT_APPLICATION_TASK)
    .map(action => action.payload)
    .switchMap(enrollmentApplicationTask => this.termService.claimEnrollmentApplicationTask(enrollmentApplicationTask))
    .map(message => this.enrollmentApplicationActions.claimEnrollmentApplicationTaskSuccess(message))
    .mergeMap(action => from([action,
        this.enrollmentApplicationActions.findAssignedEnrollmentApplicationTasks(),
        this.enrollmentApplicationActions.findPooledEnrollmentApplicationTasks()
      ]
    ));

  @Effect() releaseEnrollmentApplicationTask$ = this.actions$
    .ofType(EnrollmentApplicationActions.RELEASE_ENROLLMENT_APPLICATION_TASK)
    .map(action => action.payload)
    .switchMap(enrollmentApplicationTask => this.termService.releaseEnrollmentApplicationTask(enrollmentApplicationTask))
    .map(message => this.enrollmentApplicationActions.releaseEnrollmentApplicationTaskSuccess(message))
    .mergeMap(action => from([action,
        this.enrollmentApplicationActions.findAssignedEnrollmentApplicationTasks(),
        this.enrollmentApplicationActions.findPooledEnrollmentApplicationTasks()
      ]
    ));

  @Effect() updateEnrollmentApplication$ = this.actions$
    .ofType(EnrollmentApplicationActions.UPDATE_ENROLLMENT_APPLICATION)
    .map(action => action.payload)
    .switchMap(enrollmentApplication => this.termService.updateEnrollmentApplication(enrollmentApplication))
    .map(enrollmentApplication => this.enrollmentApplicationActions.updateEnrollmentApplicationSuccess(enrollmentApplication));

  @Effect() addEnrollmentApplicationItem$ =
    this.actions$
      .ofType(EnrollmentApplicationActions.ADD_ENROLLMENT_APPLICATION_ITEM)
      .map(action => action.payload)
      .switchMap(payload => this.termService.addEnrollmentApplicationItem(payload.enrollmentApplication, payload.item))
      .map(message => this.enrollmentApplicationActions.addEnrollmentApplicationItemSuccess(message))
      .withLatestFrom(this.store$.select(...this.ENROLLMENT_APPLICATION_TASK))
      .map(state => state[1])
      .map((task: EnrollmentApplicationTask) => this.enrollmentApplicationActions.findEnrollmentApplicationItems(task.application));
}
