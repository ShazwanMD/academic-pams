import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, Validators} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {PlannerModuleState} from '../../index';
import {AcademicSessionActions} from '../academic-session.action';

@Component({
  selector: 'pams-academic-session-creator',
  templateUrl: './academic-session-creator.dialog.html',
})

export class AcademicSessionCreatorDialog implements OnInit {

  private createForm: FormGroup;
  private create: boolean = false;
  private _academicSession: AcademicSession;
  private minLength: number = 5; // contoh

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: AcademicSessionActions,
              private dialog: MdDialogRef<AcademicSessionCreatorDialog>) {
  }

  set academicSession(value: AcademicSession) {
    this._academicSession = value;
    this.create = true;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      id: [undefined],
      code: ['', Validators.required],
      description: ['', Validators.minLength(this.minLength)],
      current: [true],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      semester: ['', Validators.required],
      year: ['', Validators.required],
    });

    if (this.create) this.createForm.patchValue(this._academicSession);
  }

  save(academicSession: AcademicSession): void {
    if (!academicSession.id) this.store.dispatch(this.actions.saveAcademicSession(academicSession));
    else this.store.dispatch(this.actions.updateAcademicSession(academicSession));
    this.dialog.close();
  }
}
