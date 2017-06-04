import { AdmissionApplication } from './admission-application.interface';
import { Component, OnInit, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Store, State } from "@ngrx/store";
import { Observable } from "rxjs";
import { AdmissionApplicationTaskCreatorDialog } from "./dialog/admission-application-task-creator.dialog";
import { MdDialog, MdDialogConfig, MdDialogRef } from "@angular/material";
import { AdmissionApplicationTask } from "./admission-application-task.interface";
import { TermModuleState } from "../index";
import { AdmissionApplicationActions } from "./admission-application.action";

@Component({
  selector: 'pams-admission-application-center',
  templateUrl: './admission-application-center.page.html',
})

export class AdmissionApplicationCenterPage implements OnInit {

  private ADMISSION_APPLICATION: string[] = "termModuleState.admissionApplications".split(".");
  // private ASSIGNED_ADMISSION_APPLICATION_TASKS: string[] = "termModuleState.assignedAdmissionApplicationTasks".split(".");
  // private POOLED_ADMISSION_APPLICATION_TASKS: string[] = "termModuleState.pooledAdmissionApplicationTasks".split(".");

  private admissionApplications$: Observable<AdmissionApplication>;
  // private assignedAdmissionApplicationTasks$: Observable<AdmissionApplicationTask[]>;
  // private pooledAdmissionApplicationTasks$: Observable<AdmissionApplicationTask[]>;
  
  private creatorDialogRef: MdDialogRef<AdmissionApplicationTaskCreatorDialog>;
    private columns: any[] = [
    { name: 'auditNo', label: 'Audit No' },
    { name: 'description', label: 'Description' },
    { name: 'sourceNo', label: 'Source No' },
    { name: 'referenceNo', label: 'Reference No' },
    { name: 'actor.name', label: 'Advisor' },
    { name: 'program.code', label: 'Program' },
    { name: 'academicSession.code', label: 'Academic Session' },
    { name: 'student.identityNo', label: 'Student' },
    { name: 'studyCenter.code', label: 'Study Center' },
    { name: 'action', label: '' }
  ];
  
  constructor(private router: Router,
    private route: ActivatedRoute,
    private actions: AdmissionApplicationActions,
    private store: Store<TermModuleState>,
    private vcf: ViewContainerRef,
    private dialog: MdDialog) {
        this.admissionApplications$ = this.store.select(...this.ADMISSION_APPLICATION);
        // this.assignedAdmissionApplicationTasks$ = this.store.select(...this.ASSIGNED_ADMISSION_APPLICATION_TASKS);
        // this.pooledAdmissionApplicationTasks$ = this.store.select(...this.POOLED_ADMISSION_APPLICATION_TASKS);
  }

 ngOnInit(): void {
    console.log("find application");
    // this.store.dispatch(this.actions.findAssignedAdmissionApplicationTasks());
    // this.store.dispatch(this.actions.findPooledAdmissionApplicationTasks());
    this.store.dispatch(this.actions.findAdmissionApplications());
  }

  viewAdmissionApplication(admissionApplication: AdmissionApplication) {
    console.log(admissionApplication.referenceNo);
    this.router.navigate(['/admission-application-detail', admissionApplication.referenceNo]);
  }

  // view(invoice: AdmissionApplicationTask) {
  //   console.log("invoice: " + invoice.taskId);
  //   this.router.navigate(['/view-task', invoice.taskId]);
  // }

  // showDialog(): void {
  //   console.log("showDialog");
  //   let config = new MdDialogConfig();
  //   config.viewContainerRef = this.vcf;
  //   config.role = 'dialog';
  //   config.width = '60%';
  //   config.height = '85%';
  //   config.position = { top: '0px' };
  //   this.creatorDialogRef = this.dialog.open(AdmissionApplicationTaskCreatorDialog, config);
  //   this.creatorDialogRef.afterClosed().subscribe(res => {
  //     console.log("close dialog");
  //     // load something here
  //   });
  // }

  private createDialog(referenceNo: AdmissionApplication): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '65%';
    config.height = '85%';
    config.position = { top: '0px' };
    this.creatorDialogRef = this.dialog.open(AdmissionApplicationTaskCreatorDialog, config);
    if (referenceNo) this.creatorDialogRef.componentInstance.admissionApplication = referenceNo;

    //set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

 goBack(route: string): void {
    this.router.navigate(['/term/admission-applications']);
  }
}

