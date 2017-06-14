import { TermModuleState } from './../../index';
import { Store } from '@ngrx/store';
import { AdmissionApplicationActions } from './../admission-application.action';
import { AdmissionApplication } from './../../admissions/admission-application.interface';
import { Observable } from 'rxjs';
import { Component, OnInit, ViewContainerRef, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig } from "@angular/material";
import { TermService } from "../../../../services/term.service";
import { AdmissionApplicationTask } from "../admission-application-task.interface";
import { AdmissionApplicationTaskEditorDialog } from "../dialog/admission-application-task-editor.dialog";


/*@Component({
  selector: 'pams-admission-application-register-task',
  templateUrl: './admission-application-register-task.panel.html',
})*/

@Component({
  selector: 'pams-admission-application-draft-task',
  templateUrl: './admission-application-draft-task.panel.html',
})

export class AdmissionApplicationDraftTaskPanel implements OnInit {

  private ADMISSION_APPLICATION_TASK: string[] = "termModuleState.admissionApplicationTask".split(".");
  private admissionApplicationTask$: Observable<AdmissionApplication[]>;

  @Input() admissionApplicationTask: AdmissionApplicationTask;


  constructor(private router: Router,
    private route: ActivatedRoute,
    private vcf: ViewContainerRef,
    private dialog: MdDialog,
    private store: Store<TermModuleState>,
    private actions: AdmissionApplicationActions) {
    this.admissionApplicationTask$ = this.store.select(...this.ADMISSION_APPLICATION_TASK);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findAdmissionApplicationTaskByTaskId(this.admissionApplicationTask.application))
  }

  editApplication(application: AdmissionApplication) {
    console.log(JSON.stringify(this.admissionApplicationTask.application));
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '60%';
    config.position = { top: '0px' };
    let editorDialogRef = this.dialog.open(AdmissionApplicationTaskEditorDialog, config);
    editorDialogRef.componentInstance.admissionApplication = this.admissionApplicationTask.application;
  }

  register() {
    this.store.dispatch(this.actions.completeAdmissionApplicationTask(this.admissionApplicationTask));
    this.goBack();
  }

  goBack(): void {
    this.router.navigate(['/term/admission-applications']);
  }

  // private admissionApplicationTask: AdmissionApplicationTask = <AdmissionApplicationTask>{}

  // private _router: Router;
  // private _route: ActivatedRoute;
  // private _termService: TermService;
  // private _snackBar: MdSnackBar;
  // private _viewContainerRef: ViewContainerRef;
  // private _dialog: MdDialog;

  // this._router = router;
  // this._route = route;
  // this._termService = termService;
  // this._snackBar = snackBar;
  // this._dialog = dialog;
  // this._viewContainerRef = viewContainerRef;

  // ngOnInit(): void {
  //   this._route.params.subscribe((params: { taskId: string }) => {
  //     let taskId: string = params.taskId;
  //     // ngrx
  //   });

  // }
  // register() {
  //   this._termService.completeAdmissionApplicationTask(this.admissionApplicationTask).subscribe(res => {
  //     let snackBarRef = this._snackBar.open("AdmissionApplication  completed", "OK");
  //     snackBarRef.afterDismissed().subscribe(() => {
  //       this.goBack();
  //     });
  //   });
  // }


}
