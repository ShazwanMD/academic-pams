import {Curriculum} from '../../curriculums/curriculum.interface';

import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Subject} from '../../curriculums/subject.interface';
import {MdDialogRef} from '@angular/material';
import {PlannerModuleState} from '../../index';
import {Store} from '@ngrx/store';

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
              private store: Store<PlannerModuleState>,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<SubjectEditorDialog>) {
  }

  set Subject(value: Subject) {
    this._subject = value;
    this.edit = true;
  }

  set Curriculum(value: Curriculum) {
    this._curriculum = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group({
      curriculum: <Curriculum>{},

    });

    if (this.edit) {
      this.editForm.patchValue(this._subject);
    }
  }
}

