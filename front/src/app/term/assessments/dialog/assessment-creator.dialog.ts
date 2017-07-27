import {ActivatedRoute, Router} from '@angular/router';
import {Offering} from '../../../shared/model/term/offering.interface';
import {AssessmentActions} from '../assessment.action';
import {Assessment} from '../../../shared/model/term/assessment.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder, Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-assessment-editor',
  templateUrl: './assessment-editor.dialog.html',
})

export class AssessmentEditorDialog implements OnInit {

  private _offering: Offering;
  private _assessment: Assessment;
  private editorForm: FormGroup;
  private edit: boolean = false;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private actions: AssessmentActions,
              private dialog: MdDialogRef<AssessmentEditorDialog>) {
  }

  set offering(value: Offering) {
    this._offering = value;
  }

  set assessment(value: Assessment) {
    this._assessment = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group({
      id: 0,
      code: ['', Validators.required],
      canonicalCode: '',
      description: ['', Validators.required],
      totalScore: [100, Validators.required],
      ordinal: ['', Validators.required],
      weight: ['', Validators.required],
      offering: ['', Validators.required],
      assessmentType: ['', Validators.required],
      assessmentCategory: ['', Validators.required]

    });

    // set offering by default
    this.editorForm.patchValue({'offering': this._offering});
    if (this.edit) this.editorForm.patchValue(this._assessment);
  }

  submit(assessment: Assessment, isValid: boolean) {
    console.log(assessment);
    console.log('canonical Code: ' + this._offering.canonicalCode + '-' + assessment.code);
    // set canonical code
    assessment.canonicalCode = this._offering.canonicalCode + '-' + assessment.code;

    if (this.edit) this.store.dispatch(this.actions.updateAssessment(this._offering, assessment));
    else this.store.dispatch(this.actions.addAssessment(this._offering, assessment));
    this.dialog.close();
  }
}
