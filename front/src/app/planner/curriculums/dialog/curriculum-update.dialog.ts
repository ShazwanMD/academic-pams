import {Program} from '../../programs/program.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Curriculum} from '../curriculum.interface';
import {CurriculumActions} from '../curriculum.action';
import {MdDialogRef} from '@angular/material';
import {PlannerModuleState} from '../../index';
import {Store} from '@ngrx/store';
import {AcademicSession} from '../../academic-sessions/academic-session.interface';
@Component({
  selector: 'pams-curriculum-update',
  templateUrl: './curriculum-update.dialog.html',
})

export class CurriculumUpdateDialog implements OnInit {
  private _session: AcademicSession;
  private _program: Program;
  private _curriculum: Curriculum;
  private updateForm: FormGroup;
  private update: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private actions: CurriculumActions,
              private store: Store<PlannerModuleState>,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CurriculumUpdateDialog>) {

  }

  set program(value: Program) {
    this._program = value;
  }

  set session(value: AcademicSession) {
    this._session = value;
  }

  set curriculum(value: Curriculum) {
    this._curriculum = value;
    this.update = true;
  }
  ngOnInit(): void {
    this.updateForm = this.formBuilder.group(<Curriculum>{
      id: null,
      code: '',
      description: '',
      coreCredit: 0,
      curriculumCredit: 0,
      electiveCredit: 0,
      generalCredit: 0,
      languageCredit: 0,
      otherCredit: 0,
      requiredCredit: 0,
      totalCredit: 0,
      period: 0,
      maxPeriod: 0,
      ordinal: 0,
      program: <Program>{}
  
    });
    if (this.update) this.updateForm.patchValue(this._curriculum);
  }

  submit(curriculum: Curriculum, isValid: boolean): void {
    console.log(JSON.stringify(curriculum));
    // curriculum.code = this._curriculum.code;

    console.log('updating curriculum');
    if (!curriculum.id) this.store.dispatch(this.actions.saveCurriculum(curriculum));
    else this.store.dispatch(this.actions.updateCurriculum(curriculum));
    this.dialog.close();

  }
}

