import {Component, OnInit,Input, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {EnrollmentApplicationTask} from '../../../shared/model/term/enrollment-application-task.interface';
import {Observable} from 'rxjs/Observable';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {EnrollmentApplicationActions} from './enrollment-application.action';
import {TermModuleState} from '../index';
import {EnrollmentApplicationTaskCreatorDialog} from './dialog/enrollment-application-task-creator.dialog';
import {EnrollmentApplication} from '../../../shared/model/term/enrollment-application.interface';
import { EnrollmentApplicationItem } from "../../../shared/model/term/enrollment-application-item.interface";

@Component({
  selector: 'pams-student-enrollment-application-center',
  templateUrl: './student-enrollment-application-center.page.html',
})

export class StudentEnrollmentApplicationCenterPage implements OnInit {

  private ASSIGNED_ENROLLMENT_APPLICATION_TASKS = 'termModuleState.assignedEnrollmentApplicationTasks'.split('.');
  private ENROLLMENT_APPLICATIONS = 'termModuleState.enrollmentApplications'.split('.');
  private ENROLLMENT_APPLICATION = 'termModuleState.enrollmentApplication'.split('.');
  private ENROLLMENT_APPLICATION_ITEMS = 'termModuleState.enrollmentApplicationItems'.split('.');
  private POOLED_ENROLLMENT_APPLICATION_TASKS = 'termModuleState.pooledEnrollmentApplicationTasks'.split('.');
  private ARCHIVED_ENROLLMENT_APPLICATIONS: string[] = 'termModuleState.archivedEnrollmentApplications'.split('.');
  private creatorDialogRef: MdDialogRef<EnrollmentApplicationTaskCreatorDialog>;
  private assignedEnrollmentApplicationTasks$: Observable<EnrollmentApplicationTask>;
  private enrollmentApplications$: Observable<EnrollmentApplication>;
  private enrollmentApplication$: Observable<EnrollmentApplication>;
  private enrollmentApplicationItems$: Observable<EnrollmentApplicationItem>;
  private pooledEnrollmentApplicationTasks$: Observable<EnrollmentApplicationTask>;
  private archivedEnrollmentApplications$: Observable<EnrollmentApplication>;

  @Input() enrollmentApplication: EnrollmentApplication;
  
  constructor(private router: Router,
              private route: ActivatedRoute,
              private vcf: ViewContainerRef,
              private actions: EnrollmentApplicationActions,
              private store: Store<TermModuleState>,
              private dialog: MdDialog) {

    this.assignedEnrollmentApplicationTasks$ = this.store.select(...this.ASSIGNED_ENROLLMENT_APPLICATION_TASKS);
    this.enrollmentApplications$ = this.store.select(...this.ENROLLMENT_APPLICATIONS);
    this.enrollmentApplication$ = this.store.select(...this.ENROLLMENT_APPLICATION);
    this.enrollmentApplicationItems$ = this.store.select(...this.ENROLLMENT_APPLICATION_ITEMS);
    this.pooledEnrollmentApplicationTasks$ = this.store.select(...this.POOLED_ENROLLMENT_APPLICATION_TASKS);
    this.archivedEnrollmentApplications$ = this.store.select(...this.ARCHIVED_ENROLLMENT_APPLICATIONS);
  }

  showDialog(): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(EnrollmentApplicationTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  viewApplication(enrollmentApplication: EnrollmentApplication): void {
    console.log('enrollmentApplication: ' + enrollmentApplication.id);
    this.router.navigate(['/secure/term/enrollment-applications', enrollmentApplication.id]);
  }

  claimTask(task: EnrollmentApplicationTask) {
    console.log('enrollmentApplication: ' + task.taskId);
    this.store.dispatch(this.actions.claimEnrollmentApplicationTask(task));
  }

  viewTask(task: EnrollmentApplicationTask) {
    console.log('enrollmentApplication: ' + task.taskId);
    this.router.navigate(['/secure/term/enrollment-applications/student-enrollment-application-task-detail', task.taskId]);
  }

  viewEnrollmentApplication(enrollmentApplication: EnrollmentApplication) {
    console.log('students applications: ' + enrollmentApplication.referenceNo);
    this.router.navigate(['/secure/term/enrollment-applications/', enrollmentApplication.referenceNo , 'student-enrollment-application-detail']);
    //this.router.navigate(['/secure/term/offerings', offering.canonicalCode]);
  }
  
  ngOnInit(): void {
      this.route.params.subscribe((params: { referenceNo: string }) => {
        let referenceNo: string = params.referenceNo;
        this.store.dispatch(this.actions.findEnrollmentApplicationByReferenceNo(referenceNo));
        //this.store.dispatch( this.actions.findEnrollmentApplicationItems(this.enrollmentApplication) );
      });
    }
}
