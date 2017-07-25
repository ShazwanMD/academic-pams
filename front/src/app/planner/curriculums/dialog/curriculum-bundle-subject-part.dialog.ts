import { BundleSubjectPart } from './../bundle-subject-part.interface';
import { SubjectActions } from './../../subjects/subject.action';
import { Course } from './../../courses/course.interface';
import { SingleSubject } from './../single-subject.interface';
import {Component, OnInit} from '@angular/core';
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

@Component({
  selector: 'pams-curriculum-bundle-subject-part',
  templateUrl: './curriculum-bundle-subject-part.dialog.html',
})

export class CurriculumBundleSubjectPartDialog implements OnInit {
   


    private editorForm: FormGroup;
    private edit: boolean = false;
    private  _bundleSubjectPart: BundleSubjectPart;
    private _subject: Subject;
    private _curriculum: Curriculum;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: SubjectActions,
              private dialog: MdDialogRef<CurriculumBundleSubjectPartDialog>) {
  }

    set bundleSubjectPart(value: BundleSubjectPart) {
    this. _bundleSubjectPart = value;
    this.edit = true;
  }

   set curriculum(value: Curriculum) {
    this._curriculum= value;
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

  save(bundleSubjectPart:  BundleSubjectPart, isValid: boolean): void {

    //   if (!bundleSubjectPart.id) this.store.dispatch(this.actions.addSubjectPart(this._curriculum, this.subject));
    //   else this.store.dispatch(this.actions.updateSubject(this.subject));
    // this.dialog.close();
    // console.log(this.subject);
    
  }
}
