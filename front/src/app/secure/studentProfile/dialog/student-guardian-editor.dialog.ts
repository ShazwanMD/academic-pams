import {Guardian} from '../../../shared/model/profile/guardian.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {Student} from '../../../shared/model/identity/student.interface';
import {GuardianType} from '../../../shared/model/profile/guardian-type.enum';
import { StudentProfileActions } from "../student-profile.action";
import { StudentProfileModuleState } from "../index";

@Component({
  selector: 'pams-student-guardian-editor',
  templateUrl: './student-guardian-editor.dialog.html',
})

export class StudentGuardianEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _student: Student;
  private _guardian: Guardian;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<StudentGuardianEditorDialog>,
              private store: Store<StudentProfileModuleState>,
              private actions: StudentProfileActions) {
  }

  set student(value: Student) {
    this._student = value;
  }

  set guardian(value: Guardian) {
    this._guardian = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Guardian>{
      id: null,
      name: '',
      identityNo: '',
      phone: '',
      guardianType: GuardianType.GUARDIAN,
    });

    if (this.edit) this.editorForm.patchValue(this._guardian);
  }

  submit(guardian: Guardian, isValid: boolean) {
      console.log(this._student.identityNo);

    if (isValid)
      guardian.id = this._guardian.id;

    if (isValid) this.store.dispatch(this.actions.updateStudentGuardian(this._student.identityNo, guardian));
    else this.store.dispatch(this.actions.addStudentGuardian(this._student.identityNo, guardian));
    this.dialog.close();
  }
}
