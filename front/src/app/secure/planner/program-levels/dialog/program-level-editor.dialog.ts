import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';

import {ProgramLevel} from '../../../../shared/model/planner/program-level.interface';
import {PlannerModuleState} from '../../index';
import {ProgramLevelActions} from '../program-level.action';

@Component({
  selector: 'pams-program-level-editor',
  templateUrl: './program-level-editor.dialog.html',
})

export class ProgramLevelEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _programLevel: ProgramLevel;

  constructor(private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PlannerModuleState>,
              private actions: ProgramLevelActions,
              private dialog: MdDialogRef<ProgramLevelEditorDialog>) {
  }

  set programLevel(value: ProgramLevel) {
    this._programLevel = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<ProgramLevel>{
      id: null,
      code: '',
      description: '',
    });

    if (this.edit) this.editorForm.patchValue(this._programLevel);
  }

  submit(programLevel: ProgramLevel, isValid: boolean) {
    console.log('updating program level');
    if (!programLevel.id) this.store.dispatch(this.actions.saveProgramLevel(programLevel));
    else this.store.dispatch(this.actions.updateProgramLevel(programLevel));
    this.dialog.close();
  }
}

