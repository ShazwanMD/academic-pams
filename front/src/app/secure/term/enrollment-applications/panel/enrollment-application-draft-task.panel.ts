import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig} from '@angular/material';
import {EnrollmentApplicationItem} from '../../../../shared/model/term/enrollment-application-item.interface';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';
import {EnrollmentApplicationItemEditorDialog} from '../dialog/enrollment-application-item-editor.dialog';
import {EnrollmentApplicationTask} from '../../../../shared/model/term/enrollment-application-task.interface';
import {Observable} from 'rxjs/Observable';
import {EnrollmentApplicationActions} from '../enrollment-application.action';
import {TermModuleState} from '../../index';
import {Store} from '@ngrx/store';

@Component({
  selector: 'pams-enrollment-application-draft-task',
  templateUrl: './enrollment-application-draft-task.panel.html',
})

export class EnrollmentApplicationDraftTaskPanel implements OnInit {

  private ENROLLMENT_APPLICATION_ITEMS: string[] = 'termModuleState.enrollmentApplicationItems'.split('.');
  private ENROLLMENT_APPLICATION_TASK: string[] = 'termModuleState.enrollmentApplicationTask'.split('.');
  private enrollmentApplicationItems$: Observable<EnrollmentApplicationItem[]>;
  private enrollmentApplicationTask$: Observable<EnrollmentApplication[]>;

  @Input() enrollmentApplicationTask: EnrollmentApplicationTask;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialog,
              private actions: EnrollmentApplicationActions,
              private store: Store<TermModuleState>) {
    this.enrollmentApplicationItems$ = this.store.select(...this.ENROLLMENT_APPLICATION_ITEMS);
    this.enrollmentApplicationTask$ = this.store.select(...this.ENROLLMENT_APPLICATION_TASK);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findEnrollmentApplicationItems(this.enrollmentApplicationTask.application));
  }

  filter(): void {
  }

  editItem(item: EnrollmentApplicationItem) {
    console.log(JSON.stringify(this.enrollmentApplicationTask.application));
    let config = new MdDialogConfig();
    config.viewContainerRef = this.viewContainerRef;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '60%';
    config.position = {top: '0px'};
    let editorDialogRef = this.dialog.open(EnrollmentApplicationItemEditorDialog, config);
    editorDialogRef.componentInstance.enrollmentApplication = this.enrollmentApplicationTask.application;
    editorDialogRef.componentInstance.enrollmentApplicationItem = item;
  }

  register() {
    this.store.dispatch(this.actions.completeEnrollmentApplicationTask(this.enrollmentApplicationTask));
    this.goBack();
  }

  remove() {
      this.store.dispatch(this.actions.releaseEnrollmentApplicationTask(this.enrollmentApplicationTask));
      this.goBack();
    }

  goBack(): void {
    this.router.navigate(['/term/enrollment-applications']);
  }
}
