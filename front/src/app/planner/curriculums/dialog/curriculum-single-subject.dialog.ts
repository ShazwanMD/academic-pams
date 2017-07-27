import {Course} from '../../courses/course.interface';
import {SingleSubject} from '../single-subject.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Curriculum} from '../curriculum.interface';
import {Subject} from '../subject.interface';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';
import {CurriculumActions} from '../curriculum.action';
import {SubjectType} from '../subject-type.enum';

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
              private actions: CurriculumActions,
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
      type: 'single',
      ordinal: 0,
      subjectType: SubjectType.CORE,
      course: <Course>{},
    });

    if (this.create) {
      this.creatorForm.patchValue(this._singleSubject);
    }
  }

  submit(singleSubject: SingleSubject, isValid: boolean): void {
    console.log('adding singlesubject');
    console.log('subject type: ' + singleSubject.subjectType);
    console.log('course: ' + singleSubject.course.code);
    this.store.dispatch(this.actions.addSingleSubject(this._curriculum, singleSubject));
    console.log('adding single subject to ' + this._curriculum);
    this.dialog.close();
  }
}
