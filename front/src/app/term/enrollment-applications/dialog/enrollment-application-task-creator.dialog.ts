import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {EnrollmentApplicationActions} from "../enrollment-application.action";
import {EnrollmentApplication} from "../enrollment-application.interface";
import {TermModuleState} from "../../index";
import {AcademicSession} from "../../../planner/academic-sessions/academic-session.interface";
import {Admission} from "../../admissions/admission.interface";
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";


@Component({
  selector: 'pams-enrollment-application-task-creator',
  templateUrl: './enrollment-application-task-creator.dialog.html',
})

export class EnrollmentApplicationTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: EnrollmentApplicationActions,
              private dialog: MdDialogRef<EnrollmentApplicationTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<EnrollmentApplication>{
      id:null,
      referenceNo:'',
      sourceNo:'please insert your data',
      description:'please insert your data',
      admission:<Admission>{},
      academicSession:<AcademicSession>{},
    });
  }

  save(enrollmentApplication: EnrollmentApplication, isValid: boolean) {
    this.store.dispatch(this.actions.startEnrollmentApplicationTask(enrollmentApplication));
    this.dialog.close();
  }
}
