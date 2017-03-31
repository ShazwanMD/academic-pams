import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../services';
import {PlannerService} from "../../services/planner.service";

@Component({
  selector: 'pams-planner-page',
  templateUrl: './planner.page.html',
})

export class PlannerPage implements OnInit {

  private _router: Router;
  private _route: ActivatedRoute;
  private _identityService: IdentityService;
  private _plannerService: PlannerService;

  constructor(router: Router,
              route: ActivatedRoute,
              identityService: IdentityService,
              plannerService: PlannerService) {
    this._router = router;
    this._route = route;
    this._plannerService = plannerService;
  }

  ngOnInit(): void {
    this._route.params.subscribe(() => {
    });
  }
}
