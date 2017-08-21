import {Cohort} from '../../../../shared/model/planner/cohort.interface';
import {StudyCenter} from '../../../setup/study-centers/study-center.interface';
import {Student} from '../../../../shared/model/identity/student.interface';
import {ActivatedRoute, Router} from '@angular/router';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {TermModuleState} from '../../index';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {Admission} from '../../../../shared/model/term/admission.interface';
import {AdmissionActions} from '../admission.action';
import {AcademicStanding} from '../../../../shared/model/term/academic-standing.enum';
import {AdmissionStatus} from '../../../../shared/model/term/admission-status.enum';
import { AdmissionApplication } from "../../../../shared/model/term/admission-application.interface";

@Component({
  selector: 'pams-assign-supervisor',
  templateUrl: './assign-supervisor.dialog.html',
})

export class AssignSupervisorDialog implements OnInit {

  private creatorForm: FormGroup;
  private create: boolean = false;
  private edit: boolean = false;
  private _admission: Admission;
  private cohort: Cohort;
  

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: AdmissionActions,
              private dialog: MdDialogRef<AssignSupervisorDialog>,
              private router: Router,
              private route: ActivatedRoute,
              private vcf: ViewContainerRef) {
  }

  set admission(value: Admission) {
    this._admission = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group( {
      id: undefined,
      staff: ['', Validators.required],
    /*
      ordinal: 0,
      cohort: <Cohort>{},  
      academicSession: <AcademicSession>{},
      studyCenter: <StudyCenter>{},
      student: <Student>{},*/
    });

    if (this.edit) this.creatorForm.patchValue(this._admission);
  }

  save(admissionApplication: AdmissionApplication, isValid: boolean) {
    console.log('adding admission');
    console.log(JSON.stringify(admissionApplication));
    
    this.store.dispatch(this.actions.updateAdmissionApplication(admissionApplication));
    this.dialog.close();
    console.log(admissionApplication);
  }
}
