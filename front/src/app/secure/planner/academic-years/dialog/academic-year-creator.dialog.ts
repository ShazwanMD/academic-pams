import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {AcademicYear} from '../../../../shared/model/planner/academic-year.interface';
import {PlannerModuleState} from '../../index';
import {AcademicYearActions} from '../academic-year.action';

@Component({
  selector: 'pams-academic-year-creator',
  templateUrl: './academic-year-creator.dialog.html',
})

export class AcademicYearCreatorDialog implements OnInit {

  private createForm: FormGroup;
  private create: boolean = false;
  private _academicYear: AcademicYear;
  private minLength: number = 4; // contoh

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: AcademicYearActions,
              private dialog: MdDialogRef<AcademicYearCreatorDialog>) {
  }

  set academicYear(value: AcademicYear) {
    this._academicYear = value;
    this.create = true;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      id: [undefined],
      code: ['', Validators.required],
      description: ['', Validators.minLength(this.minLength)],
      year: ['', Validators.minLength(this.minLength)],
     
    });

    if (this.create) this.createForm.patchValue(this._academicYear);
  }

  save(academicYear: AcademicYear): void {
    if (!academicYear.id) this.store.dispatch(this.actions.saveAcademicYear(academicYear));
    else this.store.dispatch(this.actions.updateAcademicYear(academicYear));
    this.dialog.close();
  }
}
