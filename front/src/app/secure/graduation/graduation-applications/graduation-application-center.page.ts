import {Component, OnInit, ChangeDetectionStrategy, state, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {GraduationModuleState} from "../index";
import {Store} from "@ngrx/store";
import {GraduationApplicationTask} from "../../../shared/model/graduation/graduation-application-task.interface";
import {Observable} from "rxjs/Observable";
import {MdDialogConfig, MdDialogRef, MdDialog} from "@angular/material";
import {GraduationApplicationCreatorDialog} from "./dialog/graduation-application-creator.dialog";
import {GraduationApplicationActions} from "./graduation-application.action";


@Component({
  selector: 'pams-graduation-application-center',
  templateUrl: './graduation-application-center.page.html',
})

export class GraduationApplicationCenterPage implements OnInit {

  private ASSIGNED_GRADUATION_APPLICATION_TASKS = "graduationModuleState.assignedGraduationApplicationTasks".split(".")
  private POOLED_GRADUATION_APPLICATION_TASKS = "graduationModuleState.pooledGraduationApplicationTasks".split(".")
  private creatorDialogRef: MdDialogRef<GraduationApplicationCreatorDialog>;

  private assignedGraduationApplicationTasks$: Observable<GraduationApplicationTask>;
  private pooledGraduationApplicationTasks$: Observable<GraduationApplicationTask>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private vcf: ViewContainerRef,
              private actions: GraduationApplicationActions,
              private store: Store<GraduationModuleState>,
              private dialog: MdDialog) {

    this.assignedGraduationApplicationTasks$ = this.store.select(...this.ASSIGNED_GRADUATION_APPLICATION_TASKS);
    this.pooledGraduationApplicationTasks$ = this.store.select(...this.POOLED_GRADUATION_APPLICATION_TASKS);
  }

  showDialog(): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(GraduationApplicationCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  claimTask(task: GraduationApplicationTask) {
    console.log("graduationApplication: " + task.taskId);
    this.store.dispatch(this.actions.claimGraduationApplicationTask(task));
  }

  viewTask(task: GraduationApplicationTask) {
    console.log("graduationApplication: " + task.taskId);
    this.router.navigate(['/graduation/graduation-applications/graduation-application-task-detail', task.taskId]);
  }

  ngOnInit(): void {
    console.log("find assigned/pooled graduation application tasks");
    this.store.dispatch(this.actions.findAssignedGraduationApplicationTasks());
    this.store.dispatch(this.actions.findPooledGraduationApplicationTasks());
  }
}
