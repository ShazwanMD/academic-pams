import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {Program} from "../program.interface";
import {ProgramActions} from "../program.action";;
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";
import {Store} from "@ngrx/store";
import {PlannerModuleState} from "../../index";
import {MdDialogRef} from "@angular/material";
import { create } from '@angular/language-service/language-service';

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
              private dialog: MdDialogRef<ProgramCreatorDialog>) {
  }


    set program(value: Program) {
        this._program = value;
        this.create = true;
    }

   ngOnInit(): void {
          this.creatorForm= this.formBuilder.group(<Program>{
       id: null,
       code: '',
       title: '',
       titleMs: '',
       titleEn: '',
     });

        if (this.create) this.creatorForm.patchValue(this._program);
  }
  
   save(code: Program, isValid: boolean) {

console.log(code.code);

        if (!code.id) this.store.dispatch(this.actions.saveProgram(code));
        else  this.store.dispatch(this.actions.updateProgram(code));
        this.dialog.close();
}
}
