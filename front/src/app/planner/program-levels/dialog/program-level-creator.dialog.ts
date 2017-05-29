import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";

import {ProgramLevel} from '../program-level.interface';
import {PlannerModuleState} from "../../index";
import {ProgramLevelActions} from "../program-level.action";

@Component({
  selector: 'pams-program-level-creator',
  templateUrl: './program-level-creator.dialog.html',
})

export class ProgramLevelCreatorDialog implements OnInit {

  private createForm: FormGroup;
  private create: boolean = false;
  private _programLevel: ProgramLevel;

  constructor(private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<PlannerModuleState>,
              private actions: ProgramLevelActions,
              private dialog: MdDialogRef<ProgramLevelCreatorDialog>) {
  }

  set programLevel(value: ProgramLevel) {
    this._programLevel = value;
    this.create = true;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<ProgramLevel>{
      id: null,
      code: '',
      description: '',
    });

    if (this.create) this.createForm.patchValue(this._programLevel);
  }

  save(programLevel: ProgramLevel, isValid: boolean) {
    console.log("saving program level");
    if (!programLevel.id) this.store.dispatch(this.actions.saveProgramLevel(programLevel));
    else this.store.dispatch(this.actions.updateProgramLevel(programLevel));
    this.dialog.close();
  }
}
