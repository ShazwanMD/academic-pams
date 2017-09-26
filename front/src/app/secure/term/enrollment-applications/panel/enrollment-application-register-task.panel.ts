
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';
import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {TermService} from '../../../../../services/term.service';
import {EnrollmentApplicationTask} from '../../../../shared/model/term/enrollment-application-task.interface';

@Component({
  selector: 'pams-enrollment-application-register-task',
  templateUrl: './enrollment-application-register-task.panel.html',
})

export class EnrollmentApplicationRegisterTaskPanel implements OnInit {

  private _router: Router;
  private _route: ActivatedRoute;
  private _termService: TermService;
  private _snackBar: MdSnackBar;
  private _viewContainerRef: ViewContainerRef;
  private _dialog: MdDialog;
  
  private enrollmentApplicationTask: EnrollmentApplicationTask = <EnrollmentApplicationTask>{};

  @Input() application: EnrollmentApplication;

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
    this._route.params.subscribe((params: { taskId: string }) => {
      let taskId: string = params.taskId;
    });

  }

 
  approve(): void {
    this._termService.completeEnrollmentApplicationTask(this.enrollmentApplicationTask).subscribe((res) => {
      let snackBarRef = this._snackBar.open('EnrollmentApplication completed', 'OK', {duration:3000});
      snackBarRef.afterDismissed().subscribe(() => {
        this.goBack();
      });
    });
  }

  goBack(): void {
    //this._router.navigate(['/secure/term/admission-applications/student-admission-application-center']);
    this._router.navigate(['/secure/term/enrollment-applications']);
  }
}
