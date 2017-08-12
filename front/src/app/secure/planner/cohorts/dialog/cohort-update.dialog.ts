import {Program} from '../../../../shared/model/planner/program.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Cohort} from '../../../../shared/model/planner/cohort.interface';
import {CohortActions} from '../cohort.action';
import {MdDialogRef} from '@angular/material';
import {PlannerModuleState} from '../../index';
import {Store} from '@ngrx/store';
import {AcademicClassification} from '../../../../shared/model/planner/academic-classification.enum';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import { Course } from "../../../../shared/model/planner/course.interface";
@Component({
  selector: 'pams-cohort-update',
  templateUrl: './cohort-update.dialog.html',
})

export class CohortUpdateDialog implements OnInit {
  private _session: AcademicSession;
  private _program: Program;
  private _course: Course;
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
  
  set course(value: Course) {
      this._course = value;
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

    if ( !cohort.id ) this.store.dispatch( this.actions.saveCohort( this._program, this._course, cohort ) );
    else this.store.dispatch(this.actions.updateCohort(cohort));
    this.dialog.close();

  }
}

