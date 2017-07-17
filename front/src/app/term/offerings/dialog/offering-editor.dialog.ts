import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Offering} from '../offering.interface';
import {OfferingActions} from '../offering.action';
import {MdDialogRef} from '@angular/material';
import {Store} from '@ngrx/store';
import {Course} from '../../../planner/courses/course.interface';
import {Program} from '../../../planner/programs/program.interface';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-offering-editor',
  templateUrl: './offering-editor.dialog.html',
})

export class OfferingEditorDialog implements OnInit {

  private createForm: FormGroup;
  private _program: Program;
  private _course: Course;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: OfferingActions,
              public dialog: MdDialogRef<OfferingEditorDialog>) {
    // no op
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      id: [undefined],
      code: [''],
      canonicalCode: [''],
      capacity: ['', Validators.required],
      titleMs: [''],
      titleEn: [''],
      academicSession: [undefined, Validators.required],
      course: [undefined, Validators.required],
      program: [undefined, Validators.required],
    });
  }

  submit(offering: Offering, isValid: boolean): void {
    // workaround
    this._program = offering.program;
    this._course = offering.course;

    offering.canonicalCode = this._program.code + '-' + this._course.code;
    offering.code = this._course.code;
    offering.titleMs = this._course.titleMs;
    offering.titleEn = this._course.titleEn;

    this.store.dispatch(this.actions.saveOffering(this._program, this._course, offering));
    console.log('Save a new offering');
    this.dialog.close();
  }
}

