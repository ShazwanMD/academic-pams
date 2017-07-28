import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {IdentityService} from '../../../services';

@Component({
  selector: 'pams-identity',
  templateUrl: './identity.component.html',
  viewProviders: [IdentityService],
})

export class IdentityComponent implements OnInit {

  private _router: Router;
  private _route: ActivatedRoute;
  private _identityService: IdentityService;

  items: Object[];

  constructor(router: Router,
              route: ActivatedRoute,
              identityService: IdentityService) {
    this._router = router;
    this._route = route;
    this._identityService = identityService;
  }

  ngOnInit(): void {
    this._route.params.subscribe(() => {
    });
  }
}
