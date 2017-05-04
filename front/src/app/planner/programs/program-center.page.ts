import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Program} from "./program.interface";
import {ProgramActions} from "./program.action";
import {PlannerModuleState} from "../index";

@Component({
  selector: 'pams-program-center',
  templateUrl: './program-center.page.html',
})

export class ProgramCenterPage implements OnInit {

  
  private PROGRAMS = "plannerModuleState.programs".split(".");
  private programs$: Observable<Program[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProgramActions,
              private store: Store<PlannerModuleState>) {

    this.programs$ = this.store.select(...this.PROGRAMS);
  }

  goBack(route: string): void {
    this.router.navigate(['/programs']);
  }

  viewProgram(program: Program) {
    console.log("program: " + program.id);
    this.router.navigate(['/programs-detail', program.id]);
  }

  ngOnInit(): void {
    console.log("find programs");
    this.store.dispatch(this.actions.findPrograms());
  }
}

