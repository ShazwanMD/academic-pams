import {ChangeDetectionStrategy, Component, Input, ViewContainerRef} from '@angular/core';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';
import {Admission} from '../../../../shared/model/term/admission.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {EnrollmentApplicationActions} from '../enrollment-application.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {EnrollmentApplicationTaskCreatorDialog} from '../dialog/enrollment-application-task-creator.dialog';

@Component({
  selector: 'pams-student-enrollment-application-task-detail-action',
  templateUrl: './student-enrollment-application-task-detail-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentEnrollmentApplicationTaskDetailActionComponent {

  private editorDialogRef: MdDialogRef<EnrollmentApplicationTaskCreatorDialog>;

  @Input() enrollmentApplication: EnrollmentApplication;
  @Input() admission: Admission;

  constructor(private actions: EnrollmentApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

  }

  updateDialog(): void {
    console.log('open enrollmentApplication dialog');
    console.log('referenceNo', this.enrollmentApplication.referenceNo);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(EnrollmentApplicationTaskCreatorDialog, config);
    // this.editorDialogRef.componentInstance.enrollmentApplication = this.enrollmentApplication;
    //this.editorDialogRef.componentInstance.admission = this.admission;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog enrollmentApplication update');

    });
  }
}
