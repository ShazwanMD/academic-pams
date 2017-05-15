import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
// import {Program} from "../program.interface";
// import {ProgramActions} from "../program.action";;
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";
import {Store} from "@ngrx/store";
import {PlannerModuleState} from "../../index";
import {MdDialogRef} from "@angular/material";

@Component({
  selector: 'pams-program-creator',
  templateUrl: './program-creator.dialog.html',
})

export class ProgramCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialogRef<ProgramCreatorDialog>) {
  }

  ngOnInit(): void {
 
  }
}
