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

  private _identityService: IdentityService;
  private _commonService: CommonService;
  private _router: Router;
  private _route: ActivatedRoute;
  private _actions: ProgramActions;
  private store: Store<PlannerModuleState>;
  private programs$: Observable<Program[]>;

  constructor(router: Router,
              route: ActivatedRoute,
              actions: ProgramActions,
              store: Store<PlannerModuleState>,
              identityService: IdentityService,
              commonService: CommonService) {

    this._router = router;
    this._route = route;
    this._identityService = identityService;
    this._commonService = commonService;
    this._actions = actions;
    this.store = store;
    this.programs$ = this.store.select('programs');
  }

  goBack(route: string): void {
    this._router.navigate(['/programs']);
  }

  viewProgram(program: Program) {
    console.log("program: " + program.id);
    this._router.navigate(['/programs-detail', program.id]);
  }

  ngOnInit(): void {
    console.log("find programs");
    this.store.dispatch(this._actions.findPrograms());
  }
}

