import {MdSnackBar} from '@angular/material/snack-bar';
import {Course} from '../../../../shared/model/planner/course.interface';
import {SingleSubject} from '../../../../shared/model/planner/single-subject.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Curriculum} from '../../../../shared/model/planner/curriculum.interface';
import {Subject} from '../../../../shared/model/planner/subject.interface';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';
import {CurriculumActions} from '../curriculum.action';
import {SubjectType} from '../../../../shared/model/planner/subject-type.enum';
import { CurriculumSingleSubjectDialog } from "./curriculum-single-subject.dialog";

@Component({
  selector: 'pams-curriculum-elective-subject-dialog',
  templateUrl: './curriculum-elective-subject.dialog.html',
})

export class CurriculumElectiveSubjectDialog implements OnInit {

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
              private snackBar: MdSnackBar,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CurriculumElectiveSubjectDialog>) {
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
      subjectType: SubjectType.ELECTIVE,
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

    let snackBarRef = this.snackBar.open( 'New Subject: ' + singleSubject.course.code + ' has been inserted', '', { duration: 3000 } );
    snackBarRef.afterDismissed().subscribe(() => {
    } );
  }
}
