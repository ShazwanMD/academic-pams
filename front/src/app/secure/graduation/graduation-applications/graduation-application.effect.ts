import {Injectable} from '@angular/core';
import {Actions, Effect} from '@ngrx/effects';
import {from} from 'rxjs/observable/from';
import {GraduationApplicationActions} from './graduation-application.action';
import {GraduationService} from '../../../../services/graduation.service';

@Injectable()
export class GraduationApplicationEffects {
  constructor(private actions$: Actions,
              private graduationApplicationActions: GraduationApplicationActions,
              private graduationService: GraduationService) {
  }

  @Effect() findAssignedGraduationApplicationTasks$ = this.actions$
    .ofType(GraduationApplicationActions.FIND_ASSIGNED_GRADUATION_APPLICATION_TASKS)
    .switchMap(() => this.graduationService.findAssignedGraduationApplicationTasks())
    .map((graduationApplications) => this.graduationApplicationActions.findAssignedGraduationApplicationTasksSuccess(graduationApplications));

  @Effect() findPooledGraduationApplicationTasks$ = this.actions$
    .ofType(GraduationApplicationActions.FIND_POOLED_GRADUATION_APPLICATION_TASKS)
    .switchMap(() => this.graduationService.findPooledGraduationApplicationTasks())
    .map((graduationApplications) => this.graduationApplicationActions.findPooledGraduationApplicationTasksSuccess(graduationApplications));

  //archived
  @Effect() findArchivedGraduationApplications$ = this.actions$
    .ofType(GraduationApplicationActions.FIND_ARCHIVED_GRADUATION_APPLICATIONS)
    .switchMap(() => this.graduationService.findArchivedGraduationApplications())
    .map((graduationApplications) => this.graduationApplicationActions.findArchivedGraduationApplicationsSuccess(graduationApplications));

  
  @Effect() findGraduationApplicationTaskByTaskId = this.actions$
    .ofType(GraduationApplicationActions.FIND_GRADUATION_APPLICATION_TASK_BY_TASK_ID)
    .map((action) => action.payload)
    .switchMap((taskId) => this.graduationService.findGraduationApplicationTaskByTaskId(taskId))
    .map((task) => this.graduationApplicationActions.findGraduationApplicationTaskByTaskIdSuccess(task));

  @Effect() findGraduationApplicationByReferenceNo$ = this.actions$
    .ofType(GraduationApplicationActions.FIND_GRADUATION_APPLICATION_BY_REFERENCE_NO)
    .map((action) => action.payload)
    .switchMap((referenceNo) => this.graduationService.findGraduationApplicationByReferenceNo(referenceNo))
    .map((graduationApplication) => this.graduationApplicationActions.findGraduationApplicationByReferenceNoSuccess(graduationApplication));

  @Effect() startGraduationApplicationTask$ = this.actions$
    .ofType(GraduationApplicationActions.START_GRADUATION_APPLICATION_TASK)
    .map((action) => action.payload)
    .switchMap((graduationApplication) => this.graduationService.startGraduationApplicationTask(graduationApplication))
    .map((referenceNo) => this.graduationApplicationActions.startGraduationApplicationTaskSuccess(referenceNo))
    .mergeMap((action) => from([action,
        this.graduationApplicationActions.findAssignedGraduationApplicationTasks(),
        this.graduationApplicationActions.findPooledGraduationApplicationTasks(),
      ],
    ));

  @Effect() completeGraduationApplicationTask$ = this.actions$
    .ofType(GraduationApplicationActions.COMPLETE_GRADUATION_APPLICATION_TASK)
    .map((action) => action.payload)
    .switchMap((applicationTask) => this.graduationService.completeGraduationApplicationTask(applicationTask))
    .map((message) => this.graduationApplicationActions.completeGraduationApplicationTaskSuccess(message))
    .mergeMap((action) => from([action,
        this.graduationApplicationActions.findAssignedGraduationApplicationTasks(),
        this.graduationApplicationActions.findPooledGraduationApplicationTasks(),
      ],
    ));

  @Effect() claimGraduationApplicationTask$ = this.actions$
    .ofType(GraduationApplicationActions.CLAIM_GRADUATION_APPLICATION_TASK)
    .map((action) => action.payload)
    .switchMap((applicationTask) => this.graduationService.claimGraduationApplicationTask(applicationTask))
    .map((message) => this.graduationApplicationActions.claimGraduationApplicationTaskSuccess(message))
    .mergeMap((action) => from([action,
        this.graduationApplicationActions.findAssignedGraduationApplicationTasks(),
        this.graduationApplicationActions.findPooledGraduationApplicationTasks(),
      ],
    ));

  @Effect() releaseGraduationApplicationTask$ = this.actions$
    .ofType(GraduationApplicationActions.RELEASE_GRADUATION_APPLICATION_TASK)
    .map((action) => action.payload)
    .switchMap((applicationTask) => this.graduationService.releaseGraduationApplicationTask(applicationTask))
    .map((message) => this.graduationApplicationActions.releaseGraduationApplicationTaskSuccess(message))
    .mergeMap((action) => from([action,
        this.graduationApplicationActions.findAssignedGraduationApplicationTasks(),
        this.graduationApplicationActions.findPooledGraduationApplicationTasks(),
      ],
    ));

  @Effect() updateGraduationApplication$ = this.actions$
    .ofType(GraduationApplicationActions.UPDATE_GRADUATION_APPLICATION)
    .map((action) => action.payload)
    .switchMap((application) => this.graduationService.updateGraduationApplication(application))
    .map((application) => this.graduationApplicationActions.updateGraduationApplicationSuccess(application));

}
