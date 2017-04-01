import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../services';
import {TermService} from "../../services/term.service";

@Component({
  selector: 'pams-term-page',
  templateUrl: './term.page.html',
})

export class TermPage implements OnInit {

  private _router: Router;
  private _route: ActivatedRoute;
  private _identityService: IdentityService;
  private _termService: TermService;

  constructor(router: Router,
              route: ActivatedRoute,
              identityService: IdentityService,
              termService: TermService) {
    this._router = router;
    this._route = route;
    this._termService = termService;
  }

  ngOnInit(): void {
    this._route.params.subscribe(() => {
    });
  }
}
