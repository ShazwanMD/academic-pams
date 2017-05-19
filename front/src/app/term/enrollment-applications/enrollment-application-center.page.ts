import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store, State} from "@ngrx/store";
import {Observable} from "rxjs";
import {EnrollmentApplicationTaskCreatorDialog} from "./dialog/enrollment-application-task-creator.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {EnrollmentApplicationTask} from "./enrollment-application-task.interface";
import {TermModuleState} from "../index";
import {EnrollmentApplicationActions} from "./enrollment-application.action";

@Component({
  selector: 'pams-enrollment-application-center',
  templateUrl: './enrollment-application-center.page.html',
})

export class EnrollmentApplicationCenterPage implements OnInit {

  private ASSIGNED_ENROLLMENT_APPLICATION_TASKS: string[] = "termModuleState.assignedEnrollmentApplicationTasks".split(".");
  private POOLED_ENROLLMENT_APPLICATION_TASKS: string[] = "termModuleState.pooledEnrollmentApplicationTasks".split(".");
  private assignedEnrollmentApplicationTasks$: Observable<EnrollmentApplicationTask[]>;
  private pooledEnrollmentApplicationTasks$: Observable<EnrollmentApplicationTask[]>;
  private creatorDialogRef: MdDialogRef<EnrollmentApplicationTaskCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.assignedEnrollmentApplicationTasks$ = this.store.select(...this.ASSIGNED_ENROLLMENT_APPLICATION_TASKS);
    this.pooledEnrollmentApplicationTasks$ = this.store.select(...this.POOLED_ENROLLMENT_APPLICATION_TASKS);
  }

  goBack(route: string): void {
    this.router.navigate(['/term/enrollment-applications']);
  }

  view(invoice: EnrollmentApplicationTask) {
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
    this.creatorDialogRef = this.dialog.open(EnrollmentApplicationTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  ngOnInit(): void {
    console.log("find assigned invoice tasks");
    this.store.dispatch(this.actions.findAssignedEnrollmentApplicationTasks());
    this.store.dispatch(this.actions.findPooledEnrollmentApplicationTasks());
  }

}

