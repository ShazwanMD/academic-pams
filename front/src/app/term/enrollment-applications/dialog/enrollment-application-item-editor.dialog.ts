import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Section} from "../../sections/section.interface";
import {EnrollmentApplicationItem} from "../enrollment-application-item.interface";
import {EnrollmentApplicationAction} from "../enrollment-application-action.enum";
import {TermModuleState} from "../../index";
import {EnrollmentApplicationActions} from "../enrollment-application.action";
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {EnrollmentApplication} from "../enrollment-application.interface";


@Component({
  selector: 'pams-enrollment-application-item-editor',
  templateUrl: './enrollment-application-item-editor.dialog.html',
})

export class EnrollmentApplicationItemEditorDialog implements OnInit {

  private editForm: FormGroup;
  private _enrollmentApplicationItem: EnrollmentApplicationItem;
  private _enrollmentApplication: EnrollmentApplication;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<TermModuleState>,
              private actions: EnrollmentApplicationActions,
              private dialog: MdDialogRef<EnrollmentApplicationItemEditorDialog>) {

  }

  set enrollmentApplicationItem(value: EnrollmentApplicationItem) {
    this._enrollmentApplicationItem = value;
  }

  set enrollmentApplication(value: EnrollmentApplication) {
    this._enrollmentApplication = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<EnrollmentApplicationItem>{
      id: null,
      action: EnrollmentApplicationAction.ADD,
      section: <Section>{}
    });
    // this.editForm.patchValue(this._item);
  }

  save(item: EnrollmentApplicationItem, isValid: boolean) {
    this.store.dispatch(this.actions.addEnrollmentApplicationItem(this._enrollmentApplication, item))
    this.close();
  }

  close(): void {
    this.dialog.close();
  }
}
