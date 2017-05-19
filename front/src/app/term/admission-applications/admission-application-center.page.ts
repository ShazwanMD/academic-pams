import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store, State} from "@ngrx/store";
import {Observable} from "rxjs";
import {AdmissionApplicationTaskCreatorDialog} from "./dialog/admission-application-task-creator.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {AdmissionApplicationTask} from "./admission-application-task.interface";
import {TermModuleState} from "../index";
import {AdmissionApplicationActions} from "./admission-application.action";

@Component({
  selector: 'pams-admission-application-center',
  templateUrl: './admission-application-center.page.html',
})

export class AdmissionApplicationCenterPage implements OnInit {

  private ASSIGNED_ADMISSION_APPLICATION_TASKS: string[] = "termModuleState.assignedAdmissionApplicationTasks".split(".");
  private POOLED_ADMISSION_APPLICATION_TASKS: string[] = "termModuleState.pooledAdmissionApplicationTasks".split(".");
  private assignedAdmissionApplicationTasks$: Observable<AdmissionApplicationTask[]>;
  private pooledAdmissionApplicationTasks$: Observable<AdmissionApplicationTask[]>;
  private creatorDialogRef: MdDialogRef<AdmissionApplicationTaskCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AdmissionApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.assignedAdmissionApplicationTasks$ = this.store.select(...this.ASSIGNED_ADMISSION_APPLICATION_TASKS);
    this.pooledAdmissionApplicationTasks$ = this.store.select(...this.POOLED_ADMISSION_APPLICATION_TASKS);
  }

  goBack(route: string): void {
    this.router.navigate(['/term/admission-applications']);
  }

  view(invoice: AdmissionApplicationTask) {
    console.log("invoice: " + invoice.taskId);
    this.router.navigate(['/view-task', invoice.taskId]);
  }

  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '90%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AdmissionApplicationTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  ngOnInit(): void {
    console.log("find assigned invoice tasks");
    this.store.dispatch(this.actions.findAssignedAdmissionApplicationTasks());
    this.store.dispatch(this.actions.findPooledAdmissionApplicationTasks());
  }

}

