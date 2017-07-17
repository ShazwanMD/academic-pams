import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {EnrollmentApplicationActions} from "../enrollment-application.action";
import {EnrollmentApplication} from "../enrollment-application.interface";
import {TermModuleState} from "../../index";
import {AcademicSession} from "../../../planner/academic-sessions/academic-session.interface";
import {Admission} from "../../admissions/admission.interface";
import {EnrollmentApplicationType} from "../enrollment-application-type.enum";


@Component({
  selector: 'pams-enrollment-application-task-creator',
  templateUrl: './enrollment-application-task-creator.dialog.html',
})

export class EnrollmentApplicationTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;
  private minLength: number = 10;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: EnrollmentApplicationActions,
              private dialog: MdDialogRef<EnrollmentApplicationTaskCreatorDialog>) {
  }

  ngOnInit(): void {
      this.createForm = this.formBuilder.group({
      id: [null],
      auditNo: ['N/A'],
      sourceNo: ['N/A'],
      description: ['', Validators.minLength(this.minLength)],
      applicationType: [EnrollmentApplicationType.PRA, Validators.required],
      admission: [<Admission>{},Validators.required],
      academicSession: [<AcademicSession>{}, Validators.required],
     
    });
  }
  
 /* //asal
  ngOnInit(): void {
      this.createForm = this.formBuilder.group(<EnrollmentApplication>{
        id: null,
        auditNo: 'N/A',
        sourceNo: 'N/A',
        description: '',
        applicationType: EnrollmentApplicationType.PRA,
        admission: <Admission>{},
        academicSession: <AcademicSession>{}
      });
    }*/

  save(application: EnrollmentApplication, isValid: boolean) {

    console.log("auditNo: " + application.auditNo)
    console.log("sourceNo: " + application.sourceNo)
    console.log("description: " + application.description)
    console.log("admission: " + application.admission.id)
    console.log("academicSession: " + application.academicSession.id)
    console.log("enrollmentApplicationType: " + application.applicationType)
    console.log(JSON.stringify(application));
    this.store.dispatch(this.actions.startEnrollmentApplicationTask(application));
    this.dialog.close();
  }
}
