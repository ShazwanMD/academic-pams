import { Guarantor } from './../guarantor.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {Student} from "../../identity/student.interface";
import {ProfileModuleState} from "../index";
import {ProfileActions} from "../profile.action";
import{GuarantorType} from "../guarantor-type.enum";

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
      guarantorType: GuarantorType.PRIMARY
    });

    if (this.edit) this.editorForm.patchValue(this._guarantor);
  }

  submit(guarantor: Guarantor, isValid: boolean) {
    //console.log("adding student guarantor");
    if(isValid)
    guarantor.id = this._guarantor.id;

    if(isValid) this.store.dispatch(this.actions.updateGuarantor(this._student, guarantor));
    else this.store.dispatch(this.actions.addGuarantor(this._student, guarantor));
    this.dialog.close();
  }
}
