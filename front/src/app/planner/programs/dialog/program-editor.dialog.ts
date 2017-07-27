import { Faculty } from '../../../shared/model/planner/faculty.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Program} from '../../../shared/model/planner/program.interface';
import {ProgramActions} from '../program.action';
import {MdDialogRef} from '@angular/material';
import {PlannerModuleState} from '../../index';
import {Store} from '@ngrx/store';
import {ProgramStatus} from '../../../shared/model/planner/program-status.enum';

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
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ProgramEditorDialog>) {
  }

  set program(value: Program) {
    this._program = value;
    this.edit = true;
  }

   set faculty (value: Faculty) {
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
    this.dialog.close();

  }
}
