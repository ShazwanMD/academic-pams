import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Program} from "./program.interface";
import {ProgramActions} from "./program.action";
import {PlannerState} from "../index";

@Component({
  selector: 'pams-program-detail',
  templateUrl: './program-detail.page.html',
})

export class ProgramDetailPage implements OnInit {

  private _identityService: IdentityService;
  private _commonService: CommonService;
  private _router: Router;
  private _route: ActivatedRoute;
  private _actions: ProgramActions;
  private store: Store<PlannerState>;
  private program$: Observable<Program>;

  constructor(router: Router,
              route: ActivatedRoute,
              actions: ProgramActions,
              store: Store<PlannerState>,
              identityService: IdentityService,
              commonService: CommonService) {

    this._router = router;
    this._route = route;
    this._identityService = identityService;
    this._commonService = commonService;
    this._actions = actions;
    this.store = store;
    this.program$ = this.store.select('program');
  }

  ngOnInit(): void {
    this._route.params.subscribe((params: {code: string}) => {
      let code: string = params.code;
      console.log("Code in pdp: " + code);
      this.store.dispatch(this._actions.findProgram(code));
    });
  }

  goBack(route: string): void {
    this._router.navigate(['/programs']);
  }
}

