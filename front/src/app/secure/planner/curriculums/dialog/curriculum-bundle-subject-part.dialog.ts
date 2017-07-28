import {BundleSubjectPart} from '../../../../shared/model/planner/bundle-subject-part.interface';
import {Course} from '../../../../shared/model/planner/course.interface';
import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Curriculum} from '../../../../shared/model/planner/curriculum.interface';
import {Subject} from '../../../../shared/model/planner/subject.interface';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';
import {CurriculumActions} from '../curriculum.action';

@Component({
  selector: 'pams-curriculum-bundle-subject-part',
  templateUrl: './curriculum-bundle-subject-part.dialog.html',
})

// deprecated
export class CurriculumBundleSubjectPartDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _bundleSubjectPart: BundleSubjectPart;
  private _subject: Subject;
  private _curriculum: Curriculum;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: CurriculumActions,
              private dialog: MdDialogRef<CurriculumBundleSubjectPartDialog>) {
  }

  set bundleSubjectPart(value: BundleSubjectPart) {
    this._bundleSubjectPart = value;
    this.edit = true;
  }

  set curriculum(value: Curriculum) {
    this._curriculum = value;
    this.edit = true;
  }

  set subject(value: Subject) {
    this._subject = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<BundleSubjectPart>{
      course: <Course>{},
    });

    if (this.edit) this.editorForm.patchValue(this._bundleSubjectPart);
  }

  save(bundleSubjectPart: BundleSubjectPart, isValid: boolean): void {
  }
}
