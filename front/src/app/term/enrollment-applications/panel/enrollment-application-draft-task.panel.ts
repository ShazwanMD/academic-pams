import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig} from "@angular/material";
import {EnrollmentApplicationItem} from "../enrollment-application-item.interface";
import {EnrollmentApplicationItemEditorDialog} from "../dialog/enrollment-application-item-editor.dialog";
import {EnrollmentApplicationTask} from "../enrollment-application-task.interface";
import {Observable} from "rxjs/Observable";
import {EnrollmentApplicationActions} from "../enrollment-application.action";
import {TermModuleState} from "../../index";
import {Store} from "@ngrx/store";


@Component({
  selector: 'pams-enrollment-application-draft-task',
  templateUrl: './enrollment-application-draft-task.panel.html',
})

export class EnrollmentApplicationDraftTaskPanel implements OnInit {

  private ENROLLMENT_APPLICATION_ITEMS: string[] = "termModuleState.enrollmentApplicationItems".split(".");
  private enrollmentApplicationItems$: Observable<EnrollmentApplicationItem[]>;
  @Input() enrollmentApplicationTask: EnrollmentApplicationTask;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialog,
              private actions: EnrollmentApplicationActions,
              private store: Store<TermModuleState>) {
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findEnrollmentApplicationItems(this.enrollmentApplicationTask.application))
  }

  editItem(item: EnrollmentApplicationItem) {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.viewContainerRef;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '60%';
    config.position = {top: '0px'};
    let editorDialogRef = this.dialog.open(EnrollmentApplicationItemEditorDialog, config);
    editorDialogRef.componentInstance.enrollmentApplicationItem = item;
  }

  register() {
    this.store.dispatch(this.actions.completeEnrollmentApplicationTask(this.enrollmentApplicationTask));
    this.goBack();
  }

  goBack(): void {
    this.router.navigate(['/term/enrollment-applications']);
  }
}
