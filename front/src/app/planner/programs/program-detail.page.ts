import {ProgramUpdateDialog} from './dialog/program-update.dialog';
import {MdDialogConfig} from '@angular/material';
import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";

import {Program} from "./program.interface";
import {ProgramActions} from "./program.action";

import {PlannerModuleState} from "../index";
import {PlannerService} from '../../../services';

@Component({
  selector: 'pams-program-detail',
  templateUrl: './program-detail.page.html',
})

export class ProgramDetailPage implements OnInit {

  private PROGRAM: string[] = "plannerModuleState.program".split(".");
  private program$: Observable<Program>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProgramActions,
              private store: Store<PlannerModuleState>) {

    this.program$ = this.store.select(...this.PROGRAM);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findProgram(code));
      this.store.dispatch(this.actions.updateProgram(code));
    });
  }

}

