import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef, Input, EventEmitter, Output} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Admission} from './admission.interface';
import {AdmissionActions} from './admission.action';
import {TermModuleState} from '../index';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {Enrollment} from '../enrollments/enrollment.interface';
import { AdmissionCreateTaskCreatorDialog } from "./dialog/admission-create-task-creator.dialog";
import { EnrollmentApplication } from "../enrollment-applications/enrollment-application.interface";

@Component({
  selector: 'pams-student-admission-detail',
  templateUrl: './student-admission-detail.page.html',
})

export class StudentAdmissionDetailPage implements OnInit {

  @Input() admission: Admission;
  @Input() enrollment: Enrollment;
    
  private ADMISSION: string[] = 'termModuleState.admission'.split('.');
  private ENROLLMENTS: string[] = 'termModuleState.admissionEnrollments'.split('.');
  private ENROLLMENTAPPLICATIONS: string[] = 'termModuleState.admissionEnrollmentApplications'.split('.');
  private admission$: Observable<Admission>;
  private enrollments$: Observable<Enrollment[]>;
  private enrollmentApplications$: Observable<EnrollmentApplication[]>;
  private creatorDialogRef: MdDialogRef<AdmissionCreateTaskCreatorDialog>;
  private creatorDialogRefDel: MdDialogRef<AdmissionCreateTaskCreatorDialog>;
  
  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AdmissionActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.admission$ = this.store.select(...this.ADMISSION);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
    this.enrollmentApplications$ = this.store.select(...this.ENROLLMENTAPPLICATIONS);
  }

  showDialog(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '80%';
    config.height = '70%';
    config.position = {top: '3px'};
    this.creatorDialogRef = this.dialog.open(AdmissionCreateTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  showDialogDelete(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '80%';
    config.height = '70%';
    config.position = {top: '3px'};
    this.creatorDialogRefDel = this.dialog.open(AdmissionCreateTaskCreatorDialog, config);
    this.creatorDialogRefDel.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { id: number }) => {
      let id: number = params.id;
      this.store.dispatch(this.actions.findAdmissionById(id));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/admissions']);
  }
  
  viewTask(enrollment: Enrollment) {
      console.log("task: " + enrollment.id);
      this.router.navigate(['/term/enrollments', enrollment.id]);
      
    } 
  
}
