import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Section} from '../../../../shared/model/term/section.interface';
import {EnrollmentApplicationItem} from '../../../../shared/model/term/enrollment-application-item.interface';
import {EnrollmentApplicationAction} from '../../../../shared/model/term/enrollment-application-action.enum';
import {TermModuleState} from '../../index';
import {EnrollmentApplicationActions} from '../enrollment-application.action';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';

@Component({
  selector: 'pams-enrollment-application-item-editor',
  templateUrl: './enrollment-application-item-editor.dialog.html',
})

export class EnrollmentApplicationItemEditorDialog implements OnInit {

  private editForm: FormGroup;
  private _enrollmentApplicationItem: EnrollmentApplicationItem;
  private _enrollmentApplication: EnrollmentApplication;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<TermModuleState>,
              private actions: EnrollmentApplicationActions,
              private dialog: MdDialogRef<EnrollmentApplicationItemEditorDialog>) {

  }

  set enrollmentApplication(value: EnrollmentApplication) {
    this._enrollmentApplication = value;
  }

  set enrollmentApplicationItem(value: EnrollmentApplicationItem) {
    this._enrollmentApplicationItem = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<EnrollmentApplicationItem>{
      id: null,
      action: EnrollmentApplicationAction.ADD,
      section: <Section>{},
    });
    if (this.edit) this.editForm.patchValue(this._enrollmentApplicationItem);
  }

  save(item: EnrollmentApplicationItem, isValid: boolean) {
    console.log('enrollmentApplicationItem', item);
    console.log('enrollmentApplication', this._enrollmentApplication);
    this.store.dispatch(this.actions.addEnrollmentApplicationItem(this._enrollmentApplication, item));
    this.dialog.close();
  }
}
