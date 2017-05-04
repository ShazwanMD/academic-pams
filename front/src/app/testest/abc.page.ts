import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../services';
import {ProfileService} from "../../services/profile.service";

@Component({
  selector: 'pams-abc-page',
  templateUrl: './abc.page.html',
})

export class AbcPage implements OnInit {
 private _router: Router;
  private _route: ActivatedRoute;
  private _identityService: IdentityService;
  private _profileService: ProfileService;
    constructor(router: Router,
              route: ActivatedRoute,
        private profileService:ProfileService) {


 this._router = router;
    this._route = route;
        this.profileService.findStudents

    }
 ngOnInit(): void {
    this._route.params.subscribe(() => {
    });
 }
}