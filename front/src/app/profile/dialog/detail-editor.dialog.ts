import { StudyMode } from './../../common/study-modes/study-mode.interface';
import { ProfileActions } from './../profile.action';
import {ProfileModuleState} from "./../index";
import { Student } from './../../identity/student.interface';

import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";


@Component({
  selector: 'pams-detail-editor',
  templateUrl: './detail-editor.dialog.html',
})
export class DetailEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _student: Student;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<DetailEditorDialog>,
              private store: Store<ProfileModuleState>,
              private actions: ProfileActions) {
  }

  set student(value: Student) {
    this._student = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Student>{
      id: null,
      identityNo:'',
      name: '',
      email: '',
      phone:'',
      mobile:'',
      fax:''
  
    });

    if (this.edit) this.editorForm.patchValue(this._student);
  }

  submit(student: Student, isValid: boolean) {
    console.log(student);
    //console.log("student email: " + student.email);
    this.store.dispatch(this.actions.updateStudent(student));
    this.dialog.close();
  }
}
