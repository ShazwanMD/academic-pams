import {Program} from '../../../shared/model/planner/program.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Cohort} from '../../../shared/model/planner/cohort.interface';
import {CohortActions} from '../cohort.action';
import {MdDialogRef} from '@angular/material';
import {PlannerModuleState} from '../../index';
import {Store} from '@ngrx/store';
import {AcademicClassification} from '../../../shared/model/planner/academic-classification.enum';
import {AcademicSession} from '../../../shared/model/planner/academic-session.interface';
@Component({
  selector: 'pams-cohort-update',
  templateUrl: './cohort-update.dialog.html',
})

export class CohortUpdateDialog implements OnInit {
  private _session: AcademicSession;
  private _program: Program;
  private _cohort: Cohort;
  private updateForm: FormGroup;
  private update: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private actions: CohortActions,
              private store: Store<PlannerModuleState>,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CohortUpdateDialog>) {

  }

  set program(value: Program) {
    this._program = value;
  }

  set session(value: AcademicSession) {
    this._session = value;
  }

  set cohort(value: Cohort) {
    this._cohort = value;
    this.update = true;
  }

  ngOnInit(): void {
    this.updateForm = this.formBuilder.group(<Cohort>{
      id: null,
      code: '',
      description: '',
      academicClassification: AcademicClassification.LEVEL_MASTER,

    });

    if (this.update) this.updateForm.patchValue(this._cohort);
  }

  save(cohort: Cohort, isValid: boolean) {
    console.log(JSON.stringify(cohort));
    cohort.code = this._cohort.code;

    if (!cohort.id) this.store.dispatch(this.actions.saveCohort(this._cohort));
    else this.store.dispatch(this.actions.updateCohort(cohort));
    this.dialog.close();

  }
}

