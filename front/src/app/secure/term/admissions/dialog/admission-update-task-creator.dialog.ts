import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {TermModuleState} from '../../index';
import {Admission} from '../../../../shared/model/term/admission.interface';
import {AdmissionActions} from '../admission.action';
import {ActivatedRoute, Router} from '@angular/router';

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
      gpa: 0,
      cgpa: 0,
      creditTaken: 0,
      creditEarned: 0,
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
