import {ChangeDetectionStrategy, Component, Input, ViewContainerRef} from '@angular/core';
import {Admission} from '../../../../shared/model/term/admission.interface';
import { EnrollmentApplication } from '../../../../shared/model/term/enrollment-application.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {AdmissionActions} from '../admission.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {AdmissionCreateTaskCreatorDialog} from '../dialog/admission-create-task-creator.dialog';
import { AdmissionApplicationTaskDialog } from "../../admission-applications/dialog/admission-application-task.dialog";
import { AdmissionApplicationCreatorDialog } from "../../admission-applications/dialog/admission-application-creator.dialog";
import { AdmissionApplicationManualDialog } from "../../admission-applications/dialog/admission-application-manual.dialog";
import { StudentAdmissionApplicationCreatorDialog } from "../../admission-applications/dialog/student-admission-application-creator.dialog";

@Component({
  selector: 'pams-student-admission-action',
  templateUrl: './student-admission-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentAdmissionActionComponent {

  private editorDialogRef: MdDialogRef<AdmissionCreateTaskCreatorDialog>;
  private creatorDialogRef: MdDialogRef<StudentAdmissionApplicationCreatorDialog>;
  private creatorDialogRef2: MdDialogRef<AdmissionApplicationManualDialog>;

  @Input() admission: Admission;
  @Input() enrollmentApplications: EnrollmentApplication[];

  constructor(private actions: AdmissionActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

  }

  updateDialog(): void {
    console.log('open admission dialog');
    console.log(this.admission.id);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '95%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(AdmissionCreateTaskCreatorDialog, config);
    this.editorDialogRef.componentInstance.admission = this.admission;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog admission update');

    });
  }
  
//SEMESTER REGISTRATION
  semesterRegister(): void {
      console.log('showDialog');
      let config = new MdDialogConfig();
      config.viewContainerRef = this.vcf;
      config.role = 'dialog';
      config.width = '60%';
      config.height = '40%';
      config.position = { top: '0px' };
      this.creatorDialogRef = this.dialog.open(StudentAdmissionApplicationCreatorDialog, config);
      this.creatorDialogRef.componentInstance.admission = this.admission;
      this.creatorDialogRef.afterClosed().subscribe((res) => {
          console.log('close dialog');
          // load something here
      });
  }
  
//MANUAL COURSE ENROLL
  courseEnrollManual(): void {
      console.log('showDialog');
      let config = new MdDialogConfig();
      config.viewContainerRef = this.vcf;
      config.role = 'dialog';
      config.width = '75%';
      config.height = '50%';
      config.position = { top: '0px' };
      this.creatorDialogRef2 = this.dialog.open(AdmissionApplicationManualDialog, config);
      this.creatorDialogRef2.componentInstance.admission = this.admission;
      this.creatorDialogRef2.afterClosed().subscribe((res) => {
          console.log('close dialog');
          // load something here
      });
  }

}
