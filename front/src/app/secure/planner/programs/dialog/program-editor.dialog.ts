import {Faculty} from '../../../../shared/model/planner/faculty.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Program} from '../../../../shared/model/planner/program.interface';
import {ProgramActions} from '../program.action';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {PlannerModuleState} from '../../index';
import {Store} from '@ngrx/store';
import {ProgramStatus} from '../../../../shared/model/planner/program-status.enum';

@Component({
  selector: 'pams-program-editor',
  templateUrl: './program-editor.dialog.html',
})

export class ProgramEditorDialog implements OnInit {
  private _program: Program;
  private _faculty: Faculty;
  private editForm: FormGroup;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private actions: ProgramActions,
              private store: Store<PlannerModuleState>,
              private snackBar: MdSnackBar,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ProgramEditorDialog>) {
  }

  set program(value: Program) {
    this._program = value;
    this.edit = true;
  }

  set faculty(value: Faculty) {
    this._faculty = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Program>{
      id: undefined,
      code: '',
      titleMs: '',
      titleEn: '',
      status: ProgramStatus.NEW,
    });

    if (this.edit) this.editForm.patchValue(this._program);
  }

  submit(program: Program, isValid: boolean) {
    console.log(JSON.stringify(program));
    if (!program.id) this.store.dispatch(this.actions.saveProgram(program));
    else  this.store.dispatch(this.actions.updateProgram(program));
    let snackBarRef = this.snackBar.open( 'New Program: ' + program.code + ' has been updated', '', { duration: 3000 } );
    snackBarRef.afterDismissed().subscribe(() => {
   } );
    this.dialog.close();

  }
}
