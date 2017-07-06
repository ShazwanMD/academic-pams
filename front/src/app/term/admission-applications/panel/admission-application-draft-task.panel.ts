import { AdmissionApplicationTaskEditorDialog } from './../dialog/admission-application-task-editor.dialog';
import { Component, OnInit, ViewContainerRef, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig } from '@angular/material';
import { TermService } from '../../../../services/term.service';
import { AdmissionApplicationTask } from '../admission-application-task.interface';
import {AdmissionApplication} from "../admission-application.interface";
import { Store } from "@ngrx/store";
import { TermModuleState } from "../../index";
import { AdmissionApplicationActions } from "../admission-application.action";

/*@Component({
 selector: 'pams-admission-application-register-task',
 templateUrl: './admission-application-register-task.panel.html',
 })*/

@Component({
  selector: 'pams-admission-application-draft-task',
  templateUrl: './admission-application-draft-task.panel.html',
})

export class AdmissionApplicationDraftTaskPanel implements OnInit {

  @Input() admissionApplication: AdmissionApplication;
    
  private _router: Router;
  private _route: ActivatedRoute;
  private _termService: TermService;
  private _snackBar: MdSnackBar;
  private _viewContainerRef: ViewContainerRef;
  private _dialog: MdDialog;
  private editorDialogRef: MdDialogRef<AdmissionApplicationTaskEditorDialog>;
  private admissionApplicationTask: AdmissionApplicationTask = <AdmissionApplicationTask>{};

  constructor(router: Router,
    route: ActivatedRoute,
    viewContainerRef: ViewContainerRef,
    dialog: MdDialog,
    termService: TermService,
    snackBar: MdSnackBar,
    private store: Store<TermModuleState>,
    private actions: AdmissionApplicationActions) {
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
      // ngrx
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
    config.position = { top: '0px' };
    this.editorDialogRef = this._dialog.open(AdmissionApplicationTaskEditorDialog, config);
    this.editorDialogRef.componentInstance.admissionApplication = this.admissionApplicationTask.application;
  }

  register(): void {
    this._termService.completeAdmissionApplicationTask(this.admissionApplicationTask).subscribe((res) => {
      let snackBarRef = this._snackBar.open('AdmissionApplication  completed', 'OK');
      snackBarRef.afterDismissed().subscribe(() => {
        this.goBack();
      });
    });
  }
  
  //release admission application
  remove() {
      this.store.dispatch(this.actions.releaseAdmissionApplicationTask(this.admissionApplicationTask));
      this.goBack();
    }

  goBack(): void {
    this._router.navigate(['/term/admission-applications/student-admission-application-center']);
  }
}
