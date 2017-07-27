import {SubjectActions} from './../../subjects/subject.action';
import {Course} from './../../courses/course.interface';
import {SingleSubject} from './../single-subject.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Curriculum} from '../curriculum.interface';
import {Subject} from '../subject.interface';
import {CurriculumActions} from '../curriculum.action';
;
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';
import {AcademicSession} from '../../academic-sessions/academic-session.interface';
import {Program} from '../../programs/program.interface';
import {SubjectType} from "../../subjects/subject-type.enum";

@Component({
  selector: 'pams-curriculum-single-subject',
  templateUrl: './curriculum-single-subject.dialog.html',
})

export class CurriculumSingleSubjectDialog implements OnInit {

  private creatorForm: FormGroup;
  private create: boolean = false;
  private _subject: Subject;
  private _curriculum: Curriculum;
  private _singleSubject: SingleSubject;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: SubjectActions,
              private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CurriculumSingleSubjectDialog>) {
  }

  set curriculum(value: Curriculum) {
    this._curriculum = value;
  }

  set subject(value: Subject) {
    this._subject = value;
    this.create = true;
  }

  set singleSubject(value: SingleSubject) {
    this._singleSubject = value;
    this.create = true;
  }

  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group({
      id: undefined,
      ordinal: 0,
      subjectType: SubjectType.CORE,
      course: <Course>{},
      curriculum: <Curriculum>{},
    });

    this.creatorForm.patchValue({'curriculum': this._curriculum});
    if (this.create) {
      this.creatorForm.patchValue(this._singleSubject);
    }
  }

  submit(singleSubject: SingleSubject, isValid: boolean): void {
    console.log('adding singleubject');
    this.store.dispatch(this.actions.addSingleSubject(this._curriculum, singleSubject));
    console.log('adding single subject to ' + this._curriculum);
    this.dialog.close();
  }
}

