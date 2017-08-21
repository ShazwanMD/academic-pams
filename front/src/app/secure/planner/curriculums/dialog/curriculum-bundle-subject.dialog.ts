import {MdSnackBar} from '@angular/material/snack-bar';
import { CurriculumBundleSubjectPartDialog } from './curriculum-bundle-subject-part.dialog';
import { MdDialog, MdDialogConfig } from '@angular/material/dialog';
import { BundleSubjectPart } from '../../../../shared/model/planner/bundle-subject-part.interface';
import { BundleSubject } from '../../../../shared/model/planner/bundle-subject.interface';
import { Course } from '../../../../shared/model/planner/course.interface';
import {Observable} from 'rxjs';
import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Curriculum } from '../../../../shared/model/planner/curriculum.interface';
import { Subject } from '../../../../shared/model/planner/subject.interface';
import { Store } from '@ngrx/store';
import { PlannerModuleState } from '../../index';
import { MdDialogRef } from '@angular/material';
import { CurriculumActions } from '../curriculum.action';
import { SubjectType } from '../../../../shared/model/planner/subject-type.enum';
import { SubjectElectiveStatus } from "../../../../shared/model/planner/subject-elective-status.enum";

@Component({
  selector: 'pams-curriculum-bundle-subject',
  templateUrl: './curriculum-bundle-subject.dialog.html',
})

export class CurriculumBundleSubjectDialog implements OnInit {

    private bundleSubjectPartDialogRef: MdDialogRef<CurriculumBundleSubjectPartDialog>;
    private BUNDLE_SUBJECT: string[] = 'plannerModuleState.bundleSubjects'.split('.');

  private creatorForm: FormGroup;
  private create: boolean = false;
  private _subject: Subject;
  private _curriculum: Curriculum;
  private _bundleSubject: BundleSubject;
  private bundleSubjects$: Observable<Subject[]>;
  private _bundleSubjectPart: BundleSubjectPart;

  constructor(private formBuilder: FormBuilder,
    private store: Store<PlannerModuleState>,
    private actions: CurriculumActions,
    private router: Router,
    private vcf: ViewContainerRef,
    private snackBar: MdSnackBar,
    private route: ActivatedRoute,
    private dialogPart: MdDialog,
    private dialog: MdDialogRef<CurriculumBundleSubjectDialog>, )
    
     {
        this.bundleSubjects$= this.store.select(...this.BUNDLE_SUBJECT);
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

  set bundleSubjectPart(value: BundleSubjectPart) {
    this._bundleSubjectPart = value;
    this.create = true;
  }

  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group({
      id: '',
      type: 'bundle',
      ordinal: 0,
      description:'',
      subjectType: SubjectType.ELECTIVE,
      subjectElectiveStatus: <SubjectElectiveStatus>{},
    });

    if (this.create) this.creatorForm.patchValue(this._bundleSubject);
  }

    showBundleSubjectPartDialog(bundleSubjectPart: BundleSubjectPart): void {
      console.log("open");
      console.log(this._curriculum);
    let config: MdDialogConfig = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '65px'};
    this.bundleSubjectPartDialogRef = this.dialogPart.open(CurriculumBundleSubjectPartDialog, config);
    this.bundleSubjectPartDialogRef.componentInstance.curriculum = this._curriculum;
    this.bundleSubjectPartDialogRef.afterClosed().subscribe((res) => {
      // no op
    });

  }


  submit(bundleSubject: BundleSubject,isValid: boolean): void {

    console.log('subjectBundle: ' + bundleSubject.subjectType);
    console.log('curriculum: ' + this._curriculum.academicSession);
    this.store.dispatch(this.actions.addBundleSubject(this._curriculum, bundleSubject));
    this.dialog.close();

    let snackBarRef = this.snackBar.open( 'New Subject Elective: ' + bundleSubject.subjectElectiveStatus + ' has been inserted', '', { duration: 3000 } );
    snackBarRef.afterDismissed().subscribe(() => {
    } );
  }
}
