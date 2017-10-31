import {AdmissionApplicationTaskEditorDialog} from '../dialog/admission-application-task-editor.dialog';
import {AdmissionApplication} from '../../../../shared/model/term/admission-application.interface';
import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {TermService} from '../../../../../services/term.service';
import {AdmissionApplicationTask} from '../../../../shared/model/term/admission-application-task.interface';
import {Store} from '@ngrx/store';
import { TermModuleState } from "../../index";
import {AdmissionApplicationActions} from '../admission-application.action';

@Component({
  selector: 'pams-admission-application-verify-task',
  templateUrl: './admission-application-verify-task.panel.html',
})

export class AdmissionApplicationVerifyTaskPanel implements OnInit {

  private _router: Router;
  private _route: ActivatedRoute;
  private _termService: TermService;
  private _snackBar: MdSnackBar;
  private _viewContainerRef: ViewContainerRef;
  private _dialog: MdDialog;
  private editorDialogRef: MdDialogRef<AdmissionApplicationTaskEditorDialog>;
  private admissionApplicationTask: AdmissionApplicationTask = <AdmissionApplicationTask>{};

  @Input() application: AdmissionApplication;

  constructor(router: Router,
              route: ActivatedRoute,
              viewContainerRef: ViewContainerRef,
              private store: Store<TermModuleState>,
              private actions: AdmissionApplicationActions,
              dialog: MdDialog,
              termService: TermService,
              snackBar: MdSnackBar) {
    this._router = router;
    this._route = route;
    this._termService = termService;
    this._snackBar = snackBar;
    this._dialog = dialog;
    this._viewContainerRef = viewContainerRef;
  }

  ngOnInit(): void {
    this._route.params.subscribe((params: { taskId: string }) => {
      let taskId: string = params.taskId;
    });

  }

  edit(): void {
    console.log("open admission app update dialog");
    console.log(this.admissionApplicationTask.id);
    let config = new MdDialogConfig();
    config.viewContainerRef = this._viewContainerRef;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this._dialog.open(AdmissionApplicationTaskEditorDialog, config);
    this.editorDialogRef.componentInstance.admissionApplication = this.admissionApplicationTask.application;
  }

  approve(): void {
    this._termService.completeAdmissionApplicationTask(this.admissionApplicationTask).subscribe((res) => {
      let snackBarRef = this._snackBar.open('Admission application  completed', 'OK',  {duration:3000});
      snackBarRef.afterDismissed().subscribe(() => {
        this.goBack();
      });
    });
  }

  goBack(): void {
    //this._router.navigate(['/secure/term/admission-applications/student-admission-application-center']);
    this._router.navigate(['/secure/term/admission-applications']);
  }
  
  remove() {
      this.store.dispatch(this.actions.releaseAdmissionApplicationTask(this.admissionApplicationTask));
      this.goBack();
    }
}
