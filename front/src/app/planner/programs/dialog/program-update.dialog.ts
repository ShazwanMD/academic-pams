import { Component, ViewContainerRef, OnInit, AfterViewInit } from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {Program} from "../program.interface";
import {ProgramActions} from "../program.action";
import {MdDialogRef} from "@angular/material";
import {PlannerModuleState} from "../../index";
import {Store} from "@ngrx/store";


@Component({
  selector: 'pams-program-update',
  templateUrl: './program-update.dialog.html',
})

export class ProgramUpdateDialog implements OnInit {

  private _program: Program;
  private updateForm: FormGroup;
  private update: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private actions: ProgramActions,
              private store: Store<PlannerModuleState>,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ProgramUpdateDialog >) {
            
  }

 set program(value: Program) {
        this._program = value;
        this.update = true;
  }

     ngOnInit(): void {
      this.updateForm = this.formBuilder.group(<Program>{
       id: null,
       code: '',
       title: '',
       titleMs: '',
       titleEn: '',
     });
     
       if (this.update) this.updateForm.patchValue(this._program);
  }
     
      save(code: Program, isValid: boolean) {
        if (!code.id) this.store.dispatch(this.actions.saveProgram(code));
        else  this.store.dispatch(this.actions.updateProgram(code));
        this.dialog.close();
   
   }
}

