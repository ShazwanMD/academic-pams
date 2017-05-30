import { Actor } from './../../../identity/actor.interface';
import { StudyCenter } from './../../../setup/study-centers/study-center.interface';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, ViewContainerRef, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Store } from "@ngrx/store";
import { MdDialogRef } from "@angular/material";
import { AdmissionApplicationActions } from "../admission-application.action";
import { AdmissionApplication } from "../admission-application.interface";
import { TermModuleState } from "../../index";
import { AcademicSession } from "../../../planner/academic-sessions/academic-session.interface";
import { Program } from "../../../planner/programs/program.interface";
import { Admission } from "../../admissions/admission.interface";
import { Student } from "../../../identity/student.interface";

@Component({
  selector: 'pams-admission-application-task-creator',
  templateUrl: './admission-application-task-creator.dialog.html',
})

export class AdmissionApplicationTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private store: Store<TermModuleState>,
    private actions: AdmissionApplicationActions,
    private router: Router,
    private route: ActivatedRoute,
    private vcf: ViewContainerRef,
    private dialog: MdDialogRef<AdmissionApplicationTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<AdmissionApplication>{
      id: null,
      referenceNo: '',
      sourceNo: '',
      auditNo: '',
      description: '',
      cancelComment: '',
      removeComment: '',
      actor: <Actor>{},
      student: <Student>{},
      academicSession: <AcademicSession>{},
      program: <Program>{},
      studyCenter: <StudyCenter>{},
    });
  }

  save(admissionApplication: AdmissionApplication, isValid: boolean) {
    this.store.dispatch(this.actions.startAdmissionApplicationTask(admissionApplication));
    this.dialog.close();
  }
}
