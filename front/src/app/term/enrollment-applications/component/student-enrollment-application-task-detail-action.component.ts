import {Component, Input, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {EnrollmentApplication} from "../enrollment-application.interface";
import {Admission} from "../../admissions/admission.interface";
import {Offering} from "../../offerings/offering.interface";
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from "@angular/material";
import {EnrollmentApplicationActions} from "../enrollment-application.action";
import {Store} from "@ngrx/store";
import {TermModuleState} from "../../index";
import { EnrollmentApplicationTaskCreatorDialog } from "../dialog/enrollment-application-task-creator.dialog";

@Component({
  selector: 'pams-student-enrollment-application-task-detail-action',
  templateUrl: './student-enrollment-application-task-detail-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentEnrollmentApplicationTaskDetailActionComponent {

  @Input() enrollmentApplication: EnrollmentApplication;
  @Input() admission: Admission;
 
  private editorDialogRef: MdDialogRef<EnrollmentApplicationTaskCreatorDialog>;

  constructor(private actions: EnrollmentApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

  }

  updateDialog(): void {
    console.log("open enrollmentApplication dialog");
    console.log("referenceNo", this.enrollmentApplication.referenceNo);
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
    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog enrollmentApplication update");

    });
  }
}
