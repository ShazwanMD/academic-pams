import { Guardian } from '../../../shared/model/profile/guardian.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {Student} from '../../../shared/model/identity/student.interface';
import {ProfileModuleState} from '../index';
import {ProfileActions} from '../profile.action';
import {GuardianType} from '../../../shared/model/profile/guardian-type.enum';

@Component({
  selector: 'pams-guardian-editor',
  templateUrl: './guardian-editor.dialog.html',
})

export class GuardianEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _student: Student;
  private _guardian: Guardian;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<GuardianEditorDialog>,
              private store: Store<ProfileModuleState>,
              private actions: ProfileActions) {
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

    if (isValid)
    guardian.id = this._guardian.id;

    if (isValid) this.store.dispatch(this.actions.updateGuardian(this._student, guardian));
    else this.store.dispatch(this.actions.addGuardian(this._student, guardian));
    this.dialog.close();
  }
}
