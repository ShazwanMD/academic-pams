import { Program } from './../program.interface';
import {Faculty} from './../../faculties/faculty.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {ProgramActions} from "../program.action";
;
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";
import {Store} from "@ngrx/store";
import {PlannerModuleState} from "../../index";
import {MdDialogRef} from "@angular/material";
import {create} from '@angular/language-service/language-service';

@Component({
  selector: 'pams-program-creator',
  templateUrl: './program-creator.dialog.html',
})

export class ProgramCreatorDialog implements OnInit {

  private creatorForm: FormGroup;
  private create: boolean = false;
  private _program: Program;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: ProgramActions,
              private router: Router,
              private route: ActivatedRoute,
               private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ProgramCreatorDialog>) {
  }


  set program(value: Program) {
    this._program = value;
    this.create = true;
  }

  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group(<Program>{
      id: null,
      code: '',
      titleMs: '',
      titleEn: '',
      faculty: <Faculty>{},
    });

    if (this.create) this.creatorForm.patchValue(this._program);
  }

  save(program: Program, isValid: boolean) {
    console.log(program.id);

    if (!program.id) this.store.dispatch(this.actions.saveProgram(program));
    else  this.store.dispatch(this.actions.updateProgram(program));
    this.dialog.close();
  }
}