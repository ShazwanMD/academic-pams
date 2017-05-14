import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {TermService} from "../../../../services/term.service";
import {Section} from "../../sections/section.interface";
import {AdmissionApplicationItem} from "../admission-application-item.interface";
import {AdmissionApplicationAction} from "../admission-application-action.enum";
import {TermModuleState} from "../../index";
import {AdmissionApplicationActions} from "../admission-application.action";
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {AdmissionApplication} from "../admission-application.interface";


@Component({
  selector: 'pams-admission-application-item-editor',
  templateUrl: './admission-application-item-editor.dialog.html',
})

export class AdmissionApplicationItemEditorDialog implements OnInit {

  private editForm: FormGroup;
  private _admissionApplicationItem: AdmissionApplicationItem;
  private _admissionApplication: AdmissionApplication;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<TermModuleState>,
              private actions: AdmissionApplicationActions,
              private dialog: MdDialogRef<AdmissionApplicationItemEditorDialog>) {

  }

  set admissionApplicationItem(value: AdmissionApplicationItem) {
    this._admissionApplicationItem = value;
  }

  set admissionApplication(value: AdmissionApplication) {
    this._admissionApplication = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<AdmissionApplicationItem>{
      id: null,
      description: '',
      action: AdmissionApplicationAction.ADD,
      section: <Section>{}
    });
    // this.editForm.patchValue(this._item);
  }

  save(item: AdmissionApplicationItem, isValid: boolean) {
    this.store.dispatch(this.actions.addAdmissionApplicationItem(this._admissionApplication, item))
    this.close();
  }

  close(): void {
    this.dialog.close();
  }
}
