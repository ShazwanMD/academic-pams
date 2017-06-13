import { Component, ViewContainerRef, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Store } from "@ngrx/store";
import { MdDialogRef } from "@angular/material";
import { TermModuleState } from "../../index";
import { Admission } from "../../admissions/admission.interface";
import { FlowState } from "../../../core/flow-state.enum";
import { MetaState } from "../../../core/meta-state.enum";
import { AdmissionStatus } from "../admission-status.enum";
import { AcademicStanding } from "../academic-standing.enum";
import { AdmissionActions } from "../admission.action";
import { Router, ActivatedRoute } from '@angular/router';
//import {OfferingApplicationActions} from "../offering-application.action";

@Component({
  selector: 'pams-admission-update-task-creator',
  templateUrl: './admission-update-task-creator.dialog.html',
})

export class AdmissionUpdateTaskCreatorDialog implements OnInit {
  private editorForm: FormGroup;
  private edit: boolean = false;
  private _admission: Admission;

  constructor(private formBuilder: FormBuilder,
    private store: Store<TermModuleState>,
    private actions: AdmissionActions,
    private dialog: MdDialogRef<AdmissionUpdateTaskCreatorDialog>,
    private router: Router,
    private route: ActivatedRoute,
    private vcf: ViewContainerRef) {
  }

  set admission(value: Admission) {
    this._admission = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Admission>{
      id: null,
      gpa: '',
      cgpa: '',
      creditTaken: '',
      creditEarned: '',
      // standing: AcademicStanding.TBD,
      // status: AdmissionStatus.ADMITTED,
    });
    if (this.edit) this.editorForm.patchValue(this._admission);
  }

  submit(admission: Admission, isValid: boolean) {
    console.log(JSON.stringify(admission));
    this.store.dispatch(this.actions.updateAdmission(admission));
    this.dialog.close();
  }

  /* update(offeringApplication: OfferingApplication, isValid: boolean) {
     this.store.dispatch(this.actions.startOfferingApplicationTask(offeringApplication));
     this.dialog.close();
   } */
}
