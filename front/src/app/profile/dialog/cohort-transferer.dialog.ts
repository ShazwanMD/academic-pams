import {Guardian} from './../guardian.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {Student} from "../../identity/student.interface";
import {ProfileModuleState} from "../index";
import {ProfileActions} from "../profile.action";
import {GuardianType} from "../guardian-type.enum";
import {Cohort} from "../../planner/cohorts/cohort.interface";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {TransferCohort} from "../transfer-cohort.interface";

@Component({
  selector: 'pams-guardian-editor',
  templateUrl: './guardian-editor.dialog.html',
})

export class CohortTransfererDialog implements OnInit {

  private transferForm: FormGroup;
  private _student: Student;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CohortTransfererDialog>,
              private store: Store<ProfileModuleState>,
              private actions: ProfileActions) {
  }

  set student(value: Student) {
    this._student = value;
  }

  ngOnInit(): void {
    this.transferForm = this.formBuilder.group(<TransferCohort>{
      from: <Cohort>{},
      to: <Cohort>{},
      academicSession: <AcademicSession>{}
    });
    this.transferForm.patchValue({to: this._student.cohort});
  }

  transfer(transferer: TransferCohort, isValid: boolean) {
    this.store.dispatch(this.actions.transferCohort(this._student, transferer));
    this.dialog.close();
  }
}
