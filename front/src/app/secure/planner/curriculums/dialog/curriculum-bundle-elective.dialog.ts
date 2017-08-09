
import { CurriculumBundleSubjectPartDialog } from './curriculum-bundle-subject-part.dialog';
import { MdDialog, MdDialogConfig } from '@angular/material/dialog';
import { BundleSubjectPart } from '../../../../shared/model/planner/bundle-subject-part.interface';
import { BundleSubject } from '../../../../shared/model/planner/bundle-subject.interface';
import { Course } from '../../../../shared/model/planner/course.interface';
import {Observable} from 'rxjs';
import { Component, OnInit,Input, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Curriculum } from '../../../../shared/model/planner/curriculum.interface';
import { Subject } from '../../../../shared/model/planner/subject.interface';
import { Store } from '@ngrx/store';
import { PlannerModuleState } from '../../index';
import { MdDialogRef } from '@angular/material';
import { CurriculumActions } from '../curriculum.action';
import { SubjectType } from '../../../../shared/model/planner/subject-type.enum';

@Component({
  selector: 'pams-curriculum-bundle-elective',
  templateUrl: './curriculum-bundle-elective.dialog.html',
})

export class CurriculumBundleElectiveDialog implements OnInit {
   
  private creatorForm: FormGroup;
  private create: boolean = false;
  private _subject: Subject;
  private _curriculum: Curriculum;
  private _bundleSubject: BundleSubject;
  private subjects$: Observable<Subject[]>;
  private bundleSubjects$: Observable<Subject[]>;
   private bundleSubjectPartDialogRef: MdDialogRef<CurriculumBundleSubjectPartDialog>;

   

  constructor(private formBuilder: FormBuilder,
    private store: Store<PlannerModuleState>,
    private actions: CurriculumActions,
    private router: Router,
    private vcf: ViewContainerRef,
    private route: ActivatedRoute,
    private dialogPart: MdDialog,
    private dialog: MdDialogRef<CurriculumBundleElectiveDialog>, )
    
     {
  }

  set curriculum(value: Curriculum) {
    this._curriculum = value;
  }


  ngOnInit(): void {
    
  }


  submit(bundleSubject: BundleSubject,isValid: boolean): void {

    console.log('subjectBundle: ' + bundleSubject);
    this.store.dispatch(this.actions.addBundleSubject(this._curriculum, bundleSubject));
    this.dialog.close();
  }
}

