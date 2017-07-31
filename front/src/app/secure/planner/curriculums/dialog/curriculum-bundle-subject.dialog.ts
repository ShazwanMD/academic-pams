import {BundleSubject} from '../../../../shared/model/planner/bundle-subject.interface';
import {Course} from '../../../../shared/model/planner/course.interface';
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

@Component({
  selector: 'pams-curriculum-bundle-subject',
  templateUrl: './curriculum-bundle-subject.dialog.html',
})

export class CurriculumBundleSubjectDialog implements OnInit {

  private creatorForm: FormGroup;
  private create: boolean = false;
  private _subject: Subject;
  private _curriculum: Curriculum;
  private _bundleSubject: BundleSubject;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: CurriculumActions,
              private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CurriculumBundleSubjectDialog>) {
  }

  set curriculum(value: Curriculum) {
    this._curriculum = value;
  }

  set subject(value: Subject) {
    this._subject = value;
    this.create = true;
  }

  set bundleSubject(value: BundleSubject) {
    this._bundleSubject = value;
    this.create = true;
  }

  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group({
      id: undefined,
      ordinal: 0,
      subjectType: SubjectType.CORE,
      course: <Course>{},
      course1:<Course>{},
      curriculum: <Curriculum>{},
    });

    this.creatorForm.patchValue({'curriculum': this._curriculum});
    if (this.create) this.creatorForm.patchValue(this._bundleSubject);
  }

  submit(bundleSubject: BundleSubject, isValid: boolean): void {
    console.log('adding Bundle Subject');
    this.store.dispatch(this.actions.addBundleSubject(this._curriculum, bundleSubject));
    console.log('adding Subject jju' + this._curriculum);
    this.dialog.close();
  }
}

