import {Program} from './../program.interface';
import {Faculty} from './../../faculties/faculty.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {ProgramActions} from "../program.action";
;
import {Store} from "@ngrx/store";
import {PlannerModuleState} from "../../index";
import {MdDialogRef} from "@angular/material";
import {ProgramStatus} from "../program-status.enum";

@Component({
  selector: 'pams-program-creator',
  templateUrl: './program-creator.dialog.html',
})

export class ProgramCreatorDialog implements OnInit {

  private creatorForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: ProgramActions,
              private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ProgramCreatorDialog>) {
  }

  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group(<Program>{
      id: null,
      code: '',
      titleMs: '',
      titleEn: '',
      status: ProgramStatus.INACTIVATED,
      faculty: <Faculty>{},
    });
  }

  submit(program: Program, isValid: boolean) {
    console.log(JSON.stringify(program));
    this.store.dispatch(this.actions.saveProgram(program));
    this.dialog.close();
  }
}
