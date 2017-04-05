import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig} from "@angular/material";
import {TermService} from "../../../../services/term.service";
import {EnrollmentApplicationItem} from "../enrollment-application-item.interface";
import {EnrollmentApplicationItemEditorDialog} from "../dialog/enrollment-application-item-editor.dialog";
import {EnrollmentApplicationTask} from "../enrollment-application-task.interface";


@Component({
  selector: 'pams-enrollmentApplication-register-task',
  templateUrl: './enrollmentApplication-register-task.panel.html',
})

export class EnrollmentApplicationApproveTaskPanel implements OnInit {

  private _router: Router;
  private _route: ActivatedRoute;
  private _termService: TermService;
  private _snackBar: MdSnackBar;
  private _viewContainerRef: ViewContainerRef;
  private _dialog: MdDialog;
  private _editorDialogRef: MdDialogRef<EnrollmentApplicationItemEditorDialog>;

  private enrollmentApplicationTask: EnrollmentApplicationTask = <EnrollmentApplicationTask>{}
  private enrollmentApplicationEntries: EnrollmentApplicationItem[] = <EnrollmentApplicationItem[]>[];

  constructor(router: Router,
              route: ActivatedRoute,
              viewContainerRef: ViewContainerRef,
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
    this._route.params.subscribe((params: {taskId: string}) => {
      let taskId: string = params.taskId;
      this.loadEnrollmentApplicationTask(taskId);
    });

  }

  editItem(item: EnrollmentApplicationItem) {
    let config = new MdDialogConfig();
    config.viewContainerRef = this._viewContainerRef;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '60%';
    config.position = {top:'0px'};
    this._editorDialogRef = this._dialog.open(EnrollmentApplicationItemEditorDialog, config);
    this._editorDialogRef.componentInstance.item = item;
  }

  register() {
    // this._termService.completeEnrollmentApplicationTask(this.enrollmentApplicationTask).subscribe(res => {
    //   let snackBarRef = this._snackBar.open("EnrollmentApplication  completed", "OK");
    //   snackBarRef.afterDismissed().subscribe(() => {
    //     this.goBack();
    //   });
    // });
  }

  goBack(): void {
    this._router.navigate(['/term/enrollment-applications/assigned-tasks']);
  }

  // todo: ngrx
  loadEnrollmentApplicationTask(taskId: string): void {
    // this._termService.findEnrollmentApplicationTaskByTaskId(taskId).subscribe((task: EnrollmentApplicationTask) => {
    //   this.enrollmentApplicationTask = task;
    //   this.loadEnrollmentApplicationEntries(this.enrollmentApplicationTask.referenceNo);
    // });
  }

  // todo: ngrx
  loadEnrollmentApplicationEntries(referenceNo: string): void {
    // this._termService.findEnrollmentApplicationEntries(referenceNo).subscribe((entries: EnrollmentApplicationItem[]) => {
    //   this.enrollmentApplicationEntries = entries;
    // });
  }
}
