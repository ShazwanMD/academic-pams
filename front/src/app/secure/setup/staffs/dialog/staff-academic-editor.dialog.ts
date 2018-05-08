import { ActorType } from './../../../../shared/model/identity/actor-type.enum';
import { Staff } from './../../../../shared/model/identity/staff.interface';

import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';
import { StaffActions } from '../../../identity/staffs/staff.action';

@Component({
  selector: 'pams-staff-academic-editor',
  templateUrl: './staff-academic-editor.dialog.html',
})

export class StaffAcademicEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _staff: Staff;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<StaffAcademicEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions,
            private actionsStaff: StaffActions) {
  }

  set staff(value: Staff) {
    this._staff = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group({
      id: null,
      identityNo: ['', Validators.required],
      email: ['', Validators.required],
      name: ['', Validators.required],
      phone:'',
      mobile:'',
      fax: '',
      actorType:ActorType.STAFF,
      title:'',
      category:'',  
    });

    if (this.edit) this.editorForm.patchValue(this._staff);
  }


  submit(staff: Staff, isValid: boolean) {
    if (!staff.id) this.store.dispatch(this.actionsStaff.saveAcademicStaff(staff));
    else this.store.dispatch(this.actionsStaff.updateAcademicStaff(staff));
    this.dialog.close();
  }
}
