import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../services';

@Component({
  selector: 'pams-setup-page',
  templateUrl: './setup.page.html',
})

export class SetupPage implements OnInit {

  private _router: Router;
  private _route: ActivatedRoute;
  private _identityService: IdentityService;

  constructor(  router: Router,
                identityService: IdentityService,
                route: ActivatedRoute) {

    this._router = router;
    this._route = route;
  }

  ngOnInit(): void {
    this._route.params.subscribe(() => {
    });
  }
}