import { Cohort } from '../../../../shared/model/planner/cohort.interface';
import { StudyCenter } from '../../../setup/study-centers/study-center.interface';
import { Student } from '../../../../shared/model/identity/student.interface';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, ViewContainerRef, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Store } from '@ngrx/store';
import { MdDialogRef } from '@angular/material';
import { TermModuleState } from '../../index';
import { AcademicSession } from '../../../../shared/model/planner/academic-session.interface';
import { Admission } from '../../../../shared/model/term/admission.interface';
import { AdmissionActions } from '../admission.action';
import { AcademicStanding } from '../../../../shared/model/term/academic-standing.enum';
import { AdmissionStatus } from '../../../../shared/model/term/admission-status.enum';

@Component({
  selector: 'pams-admission-create-task-creator',
  templateUrl: './admission-create-task-creator.dialog.html',
})

export class AdmissionCreateTaskCreatorDialog implements OnInit {

  private creatorForm: FormGroup;
  private create: boolean = false;
  private edit: boolean = false;
  private _admission: Admission;
  private session: AcademicSession;
  private cohort: Cohort;
  private student: Student;
  private studyCenter: StudyCenter;

  constructor(private formBuilder: FormBuilder,
    private store: Store<TermModuleState>,
    private actions: AdmissionActions,
    private dialog: MdDialogRef<AdmissionCreateTaskCreatorDialog>,
    private router: Router,
    private route: ActivatedRoute,
    private vcf: ViewContainerRef) {
  }

  set admission(value: Admission) {
    this._admission = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group(<Admission>{
      id: undefined,
      gpa: 0,
      cgpa: 0,
      creditTaken: 0,
      creditEarned: 0,
      ordinal: 0,
      standing: AcademicStanding.TBD,
      status: AdmissionStatus.ADMITTED,
      cohort: <Cohort>{},
      academicSession: <AcademicSession>{},
      studyCenter: <StudyCenter>{},
      student: <Student>{},
    });

    if (this.edit) this.creatorForm.patchValue(this._admission);
  }

  save(admission: Admission, isValid: boolean) {
     console.log('adding admission');
     console.log(JSON.stringify(admission));
     if (!admission.id) this.store.dispatch(this.actions.saveAdmission(admission));
      else this.store.dispatch(this.actions.updateAdmission(admission));
     this.dialog.close();
     console.log(admission);
  }
}
