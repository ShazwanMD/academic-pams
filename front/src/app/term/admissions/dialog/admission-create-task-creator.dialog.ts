import { Cohort } from './../../../planner/cohorts/cohort.interface';
import { StudyCenter } from './../../../setup/study-centers/study-center.interface';
import { Student } from './../../../identity/student.interface';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, ViewContainerRef, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Store } from "@ngrx/store";
import { MdDialogRef } from "@angular/material";
//import {OfferingApplicationActions} from "../offering-application.action";
//import {OfferingApplication} from "../offering-application.interface";
import { TermModuleState } from "../../index";
import { AcademicSession } from "../../../planner/academic-sessions/academic-session.interface";
import { Admission } from "../../admissions/admission.interface";
import { FlowState } from "../../../core/flow-state.enum";
import { MetaState } from "../../../core/meta-state.enum";
import { AdmissionApplication } from '../admission-application.interface';
import { AdmissionApplicationActions } from "../admission-application.action";
import { Course } from "../../../planner/courses/course.interface";
import { Program } from "../../../planner/programs/program.interface";
import { AdmissionActions } from "../admission.action";
import { AcademicStanding } from "../academic-standing.enum";
import { AdmissionStatus } from "../admission-status.enum";


@Component({
  selector: 'pams-admission-create-task-creator',
  templateUrl: './admission-create-task-creator.dialog.html',
})

export class AdmissionCreateTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;
  private create: boolean = false;
  private _admission: Admission;

  constructor(private formBuilder: FormBuilder,
    private store: Store<TermModuleState>,
    private actions: AdmissionActions,
    private dialog: MdDialogRef<AdmissionCreateTaskCreatorDialog>,
    private router: Router,
    private route: ActivatedRoute,
    private vcf: ViewContainerRef, ) {
  }

  set admission(value: Admission) {
    this._admission = value;
    this.create = true;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Admission>{
      id: null,
      gpa: '',
      cgpa: '',
      creditTaken: '',
      creditEarned: '',
      standing: AcademicStanding.TBD,
      status: AdmissionStatus.ADMITTED,
      cohort:<Cohort>{},
      session:<AcademicSession>{},
      studyCenter: <StudyCenter>{},
      student:<Student>{},
    });
    if (this.create) this.createForm.patchValue(this._admission);
  }
    submit(admission: Admission, isValid: boolean) {
      //  console.log("adding admission");
      //   if (!admission.id) this.store.dispatch(this.actions.saveAdmission(admission));
      //   else this.store.dispatch(this.actions.updateAdmission(admission));
      //   this.dialog.close();
      //   console.log(admission);
  }

  /* save(offeringApplication: OfferingApplication, isValid: boolean) {
     this.store.dispatch(this.actions.startOfferingApplicationTask(offeringApplication));
     this.dialog.close();
   } */
}
