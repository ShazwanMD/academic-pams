import {AdmissionApplication} from '../../../shared/model/term/admission-application.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {AdmissionApplicationTaskCreatorDialog} from './dialog/admission-application-task-creator.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {AdmissionApplicationTask} from '../../../shared/model/term/admission-application-task.interface';
import {TermModuleState} from '../index';
import {AdmissionApplicationActions} from './admission-application.action';

@Component({
  selector: 'pams-admission-application-center2',
  templateUrl: './admission-application-center2.page.html',
})

export class StudentAdmissionApplicationCenterPage implements OnInit {

  private ASSIGNED_ADMISSION_APPLICATION_TASKS: string[] = 'termModuleState.assignedAdmissionApplicationTasks'.split('.');
  private POOLED_ADMISSION_APPLICATION_TASKS: string[] = 'termModuleState.pooledAdmissionApplicationTasks'.split('.');
  private ARCHIVED_ADMISSION_APPLICATIONS: string[] = 'termModuleState.archivedAdmissionApplications'.split('.');
  private assignedAdmissionApplicationTasks$: Observable<AdmissionApplicationTask>;
  private pooledAdmissionApplicationTasks$: Observable<AdmissionApplicationTask>;
  private archivedAdmissionApplications$: Observable<AdmissionApplication>;
  private creatorDialogRef: MdDialogRef<AdmissionApplicationTaskCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AdmissionApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.assignedAdmissionApplicationTasks$ = this.store.select(...this.ASSIGNED_ADMISSION_APPLICATION_TASKS);
    this.pooledAdmissionApplicationTasks$ = this.store.select(...this.POOLED_ADMISSION_APPLICATION_TASKS);
    this.archivedAdmissionApplications$ = this.store.select(...this.ARCHIVED_ADMISSION_APPLICATIONS);
  }

  createDialog(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '70%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AdmissionApplicationTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  claimTask(task: AdmissionApplicationTask) {
    console.log('approved application:' + task.taskId);
    this.store.dispatch(this.actions.claimAdmissionApplicationTask(task));
  }

  viewTask(task: AdmissionApplicationTask) {
    console.log('students applications: ' + task.taskId);
    this.router.navigate(['/secure/term/admission-applications/student-admission-application-task-detail', task.taskId]);
  }

  viewAdmissionApplication(admissionApplication: AdmissionApplication) {
    console.log('students applications: ' + admissionApplication.referenceNo);
    this.router.navigate(['/secure/term/admission-applications', admissionApplication.referenceNo, 'student-admission-application-detail']);
    //this.router.navigate(['/secure/term/offerings', offering.canonicalCode]);
  }

  ngOnInit(): void {
    console.log('find approved/review application tasks');
    this.store.dispatch(this.actions.findAssignedAdmissionApplicationTasks());
    this.store.dispatch(this.actions.findPooledAdmissionApplicationTasks());
    this.store.dispatch(this.actions.findArchivedAdmissionApplications());
    
    //alert("Please VIEW your registration to register semester");
  }

  goBack(route: string): void {
    this.router.navigate(['/secure/term/admission-applications']);
  }
}

