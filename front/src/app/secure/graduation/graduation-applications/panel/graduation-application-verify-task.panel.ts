import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdSnackBar} from '@angular/material';
import {GraduationApplicationTask} from '../../../../shared/model/graduation/graduation-application-task.interface';
import {GraduationApplicationActions} from '../graduation-application.action';
import {Store} from '@ngrx/store';
import {GraduationModuleState} from '../../index';

@Component({
  selector: 'pams-graduation-application-verify-task',
  templateUrl: './graduation-application-verify-task.panel.html',
})

export class GraduationApplicationVerifyTaskPanel implements OnInit {

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
    this.router.navigate(['/secure/graduation/graduation-applications']);
  }
}
