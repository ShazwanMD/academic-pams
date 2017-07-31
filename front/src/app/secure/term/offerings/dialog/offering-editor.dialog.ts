import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Offering} from '../../../../shared/model/term/offering.interface';
import {OfferingActions} from '../offering.action';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {Store} from '@ngrx/store';
import {Course} from '../../../../shared/model/planner/course.interface';
import {Program} from '../../../../shared/model/planner/program.interface';
import {TermModuleState} from '../../index';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'pams-offering-editor',
  templateUrl: './offering-editor.dialog.html',
})

export class OfferingEditorDialog implements OnInit {

  private createForm: FormGroup;
  private _program: Program;
  private _course: Course;
  private _offering: Offering;
  private str: string;
  private OFFERINGS: string[] = 'termModuleState.offerings'.split('.');
  private offerings$: Observable<Offering[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private snackBar: MdSnackBar,
              private actions: OfferingActions,
              public dialog: MdDialogRef<OfferingEditorDialog>) {
    this.offerings$ = this.store.select(...this.OFFERINGS);

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

    console.log(this.store.dispatch(this.actions.saveOffering(this._program, this._course, offering)));
    console.log(this.actions.saveOfferingSuccess(offering));

    this.dialog.close();

    //this.store.dispatch(this.actions.saveOffering( this._program, this._course, offering));
    //console.log(this.actions.isOfferingExists(offering));

   }
}
