import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {GraduationModuleState} from '../index';
import {Store} from '@ngrx/store';
import {GraduationApplicationTask} from '../../../shared/model/graduation/graduation-application-task.interface';
import {Observable} from 'rxjs/Observable';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {GraduationApplicationCreatorDialog} from './dialog/graduation-application-creator.dialog';
import {GraduationApplicationActions} from './graduation-application.action';
import { GraduationApplication } from "../../../shared/model/graduation/graduation-application.interface";

@Component({
  selector: 'pams-student-graduation-application-center',
  templateUrl: './student-graduation-application-center.page.html',
})

export class StudentGraduationApplicationCenterPage implements OnInit {

  private ASSIGNED_GRADUATION_APPLICATION_TASKS = 'graduationModuleState.assignedGraduationApplicationTasks'.split('.');
  private POOLED_GRADUATION_APPLICATION_TASKS = 'graduationModuleState.pooledGraduationApplicationTasks'.split('.');
  private ARCHIVED_GRADUATION_APPLICATIONS: string[] = 'graduationModuleState.archivedGraduationApplications'.split('.');
  private creatorDialogRef: MdDialogRef<GraduationApplicationCreatorDialog>;
  private assignedGraduationApplicationTasks$: Observable<GraduationApplicationTask>;
  private pooledGraduationApplicationTasks$: Observable<GraduationApplicationTask>;
  private archivedGraduationApplications$: Observable<GraduationApplicationTask>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private vcf: ViewContainerRef,
              private actions: GraduationApplicationActions,
              private store: Store<GraduationModuleState>,
              private dialog: MdDialog) {

    this.assignedGraduationApplicationTasks$ = this.store.select(...this.ASSIGNED_GRADUATION_APPLICATION_TASKS);
    this.pooledGraduationApplicationTasks$ = this.store.select(...this.POOLED_GRADUATION_APPLICATION_TASKS);
    this.archivedGraduationApplications$ = this.store.select(...this.ARCHIVED_GRADUATION_APPLICATIONS);
  }

  showDialog(): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(GraduationApplicationCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  claimTask(task: GraduationApplicationTask) {
    console.log('graduationApplication: ' + task.taskId);
    this.store.dispatch(this.actions.claimGraduationApplicationTask(task));
  }

  viewTask(task: GraduationApplicationTask) {
    console.log('graduationApplication: ' + task.taskId);
    this.router.navigate(['/secure/graduation/graduation-applications/graduation-application-task-detail', task.taskId]);
  }
  
  viewGraduationApplication(graduationApplication: GraduationApplication) {
      console.log('graduation applications: ' + graduationApplication.referenceNo);
      this.router.navigate(['/secure/term/graduation-applications', graduationApplication.referenceNo]);
    }

  ngOnInit(): void {
    console.log('find assigned/archived graduation application tasks');
    this.store.dispatch(this.actions.findAssignedGraduationApplicationTasks());
    this.store.dispatch(this.actions.findPooledGraduationApplicationTasks());
    this.store.dispatch(this.actions.findArchivedGraduationApplications());
  }
}
