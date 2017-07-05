import {Curriculum} from '../../curriculums/curriculum.interface';

import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Subject} from "../subject.interface";
// import {SubjectActions} from "../subject.action";
import {MdDialogRef} from "@angular/material";
import {PlannerModuleState} from "../../index";
import {Store} from "@ngrx/store";


@Component({
  selector: 'pams-subject-editor',
  templateUrl: './subject-editor.dialog.html',
})

export class SubjectEditorDialog implements OnInit {
  private _subject: Subject;
  private editForm: FormGroup;
  private edit: boolean = false;
  private _curriculum: Curriculum;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              // private actions: SubjectActions,
              private store: Store<PlannerModuleState>,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<SubjectEditorDialog>) {
  }

  set Subject(value: Subject) {
    this._subject = value;
    this.edit = true;
  }
  

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Subject>{
       id: null,
    //  subjectType: SubjectType.CORE,
      curriculum: <Curriculum>{},
     
    });

    if (this.edit) this.editForm.patchValue(this._subject);
  }

  // submit(subject: Subject, isValid: boolean) {

  //   console.log(JSON.stringify(subject));
  //   if (!subject.id) this.store.dispatch(this.actions.addSubject(this._curriculum,subject));
  //   else  this.store.dispatch(this.actions.updateSubject(subject));
  //   this.dialog.close();

  // }
}

 