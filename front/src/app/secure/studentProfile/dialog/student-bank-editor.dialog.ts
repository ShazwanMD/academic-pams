import { BankCode } from './../../../shared/model/common/bank-code.interface';
import { StudentProfileActions } from './../student-profile.action';
import {Cohort} from '../../../shared/model/planner/cohort.interface';
import {StudyMode} from '../../../shared/model/common/study-mode.interface';
import {Student} from '../../../shared/model/identity/student.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {StudentStatus} from '../../../shared/model/profile/student-status.enum';
import { StudentProfileModuleState } from "../index";

@Component({
  selector: 'pams-student-bank-editor',
  templateUrl: './student-bank-editor.dialog.html',
})
export class StudentBankEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _student: Student;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<StudentBankEditorDialog>,
              private store: Store<StudentProfileModuleState>,
              private actions: StudentProfileActions) {
  }

  set student(value: Student) {
    this._student = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Student>{
      id: null,
      identityNo: '',
      name: '',
      email: '',
      phone: '',
      mobile: '',
      fax: '',
      studyMode: <StudyMode>{},
      cohort: <Cohort>{},
      studentStatus: <StudentStatus>{},
      bankAccountNo:'',
      bankCode:<BankCode>{},

    });

    if (this.edit) this.editorForm.patchValue(this._student);
  }

  submit(student: Student, isValid: boolean) {
    console.log("submit button"+ JSON.stringify(student));
    this.store.dispatch(this.actions.updateStudentDetail(student));
    this.dialog.close();
  }
}
