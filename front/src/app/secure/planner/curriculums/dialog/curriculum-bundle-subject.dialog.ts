import {CurriculumBundleSubjectPartDialog} from './curriculum-bundle-subject-part.dialog';
import {MdDialog, MdDialogConfig} from '@angular/material/dialog';
import {BundleSubjectPart} from '../../../../shared/model/planner/bundle-subject-part.interface';
import {BundleSubject} from '../../../../shared/model/planner/bundle-subject.interface';
import {Course} from '../../../../shared/model/planner/course.interface';
import { Component,  OnInit,  ViewContainerRef} from '@angular/core';
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
              private vcf: ViewContainerRef,
              private route: ActivatedRoute,
              private dialog: MdDialogRef<CurriculumBundleSubjectDialog>,) {
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
      type: 'bundle',
      ordinal: 0,
      subjectType: SubjectType.ELECTIVE,
      bundleSubjectPart: <BundleSubjectPart>{},
      course:<Course>{}
    });

    if (this.create) this.creatorForm.patchValue(this._bundleSubject);
  }


  submit(bundleSubject: BundleSubject, isValid: boolean): void {
   
    console.log('subject type: ' + bundleSubject.subjectType);
    this.store.dispatch(this.actions.addBundleSubject(this._curriculum, bundleSubject));
    this.dialog.close();
  }
}
