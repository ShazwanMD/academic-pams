import { Offering } from './../../offerings/offering.interface';
import { AssessmentActions } from './../assessment.action';
import { Assessment } from './../assessment.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {AssessmentType} from "../assessment-type.enum";
import {AssessmentCategory} from "../assessment-category.enum";


@Component({
  selector: 'pams-assessment-creator',
  templateUrl: './assessment-creator.dialog.html',
})

export class AssessmentCreatorDialog implements OnInit {

  private _offering: Offering;
   private _assessment: Assessment;
  private editorForm: FormGroup;
  private edit: boolean = false;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: AssessmentActions,
              private dialog: MdDialogRef<AssessmentCreatorDialog>) {
  }

  set offering(value: Offering) {
    this._offering = value;
  }

    set assessment(value: Assessment) {
    this._assessment = value;
    this.edit = true;
  }
  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Assessment>{
      id: null,
      code: '',
      canonicalCode: '',
      description:'',
      offering: <Offering>{},
      assessmentType: AssessmentType.QUIZ,
      assessmentCategory: AssessmentCategory.COURSE_WORK

 
    });

    // set offering by default
    this.editorForm.patchValue({'offering': this._offering});
  }

  submit(assessment: Assessment, isValid: boolean) {
    // set codes
    assessment.canonicalCode = this._offering.canonicalCode + "" + assessment.canonicalCode
    assessment.code = this._offering.code + "" + assessment.code

//     // dispatch action
//     this.store.dispatch(this.actions.addion(this._offering, section));
//     this.dialog.close();
 }
}
