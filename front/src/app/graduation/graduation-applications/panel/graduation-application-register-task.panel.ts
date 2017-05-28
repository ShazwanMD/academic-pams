import {Component, OnInit, ViewContainerRef, Input} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig} from "@angular/material";
import {GraduationApplicationTask} from "../graduation-application-task.interface";
import {GraduationApplicationActions} from "../graduation-application.action";
import {GraduationApplicationTaskState} from "../graduation-application-task.reducer";
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {GraduationModuleState} from "../../index";


@Component({
  selector: 'pams-graduation-application-register-task',
  templateUrl: './graduation-application-register-task.panel.html',
})

export class GraduationApplicationRegisterTaskPanel implements OnInit {

  @Input() graduationApplicationTask: GraduationApplicationTask;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private actions: GraduationApplicationActions,
              private store: Store<GraduationModuleState>,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }

  ngOnInit(): void {
  }

  register() {
    this.store.dispatch(this.actions.completeGraduationApplicationTask(this.graduationApplicationTask));
    this.goBack();
  }

  goBack(): void {
    this.router.navigate(['/billing/graduationApplications']);
  }
}
