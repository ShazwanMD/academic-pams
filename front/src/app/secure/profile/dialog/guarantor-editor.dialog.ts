import {Guarantor} from '../../../shared/model/profile/guarantor.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {Student} from '../../../shared/model/identity/student.interface';
import {ProfileModuleState} from '../index';
import {ProfileActions} from '../profile.action';
import {GuarantorType} from '../../../shared/model/profile/guarantor-type.enum';

@Component({
  selector: 'pams-guarantor-editor',
  templateUrl: './guarantor-editor.dialog.html',
})

export class GuarantorEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _student: Student;
  private _guarantor: Guarantor;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<GuarantorEditorDialog>,
              private store: Store<ProfileModuleState>,
              private actions: ProfileActions) {
  }

  set student(value: Student) {
    this._student = value;
  }

  set guarantor(value: Guarantor) {
    this._guarantor = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Guarantor>{
      id: null,
      name: '',
      identityNo: '',
      phone: '',
      guarantorType: GuarantorType.PRIMARY,
    });

    if (this.edit) this.editorForm.patchValue(this._guarantor);
  }

  submit(guarantor: Guarantor, isValid: boolean) {
    if (isValid)
      guarantor.id = this._guarantor.id;

    if (isValid) this.store.dispatch(this.actions.updateGuarantor(this._student, guarantor));
    else this.store.dispatch(this.actions.addGuarantor(this._student, guarantor));
    this.dialog.close();
  }
}
