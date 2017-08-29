import {Guardian} from '../../../shared/model/profile/guardian.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar} from '@angular/material';
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
              private snackBar: MdSnackBar,
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
    this.editorForm = this.formBuilder.group({
      id: [undefined],
      name: ['', Validators.required],
      identityNo: ['', Validators.required],
      phone: ['', Validators.required],
      guardianType: ['', Validators.required],
      
    });

    if (this.edit) this.editorForm.patchValue(this._guardian);
  }

  submit(guardian: Guardian, isValid: boolean) {

    if (isValid)
      guardian.id = this._guardian.id;

    if (isValid) this.store.dispatch(this.actions.updateGuardian(this._student, guardian));
    else this.store.dispatch(this.actions.addGuardian(this._student, guardian));
    this.dialog.close();
    let snackBarRef = this.snackBar.open( 'New Guardian has been saved', '', { duration: 3000 } );
    snackBarRef.afterDismissed().subscribe(() => {
    } );
  }
}
