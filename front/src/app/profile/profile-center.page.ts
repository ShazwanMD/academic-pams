import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {IdentityService} from "../../services/identity.service";
import {CommonService} from "../../services/common.service";
import {ProfileService} from "../../services/profile.service";
import {ProfileState} from "./profile.reducer";
import {ProfileActions} from "./profile.action";
import {Student} from "../identity/student.interface";

@Component({
  selector: 'pams-profile-center',
  templateUrl: 'profile-center.page.html',
})

export class ProfileCenterPage implements OnInit {

  private _identityService: IdentityService;
  private _commonService: CommonService;
  private _profileService: ProfileService;
  private _router: Router;
  private _route: ActivatedRoute;
  private _actions: ProfileActions;
  private store: Store<ProfileState>;
  private profiles: Observable<Student[]>;

  constructor(router: Router,
              route: ActivatedRoute,
              actions: ProfileActions,
              store: Store<ProfileState>,
              identityService: IdentityService,
              commonService: CommonService) {

    this._router = router;
    this._route = route;
    this._identityService = identityService;
    this._commonService = commonService;
    this._actions = actions;
    this.store = store;
    this.profiles = this.store.select('students');
  }

  goBack(route: string): void {
    this._router.navigate(['/profiles']);
  }

  viewProfile(student: Student) {
    console.log("profile: " + student.identityNo);
    this._router.navigate(['/profiles-detail', student.identityNo]);
  }

  ngOnInit(): void {
    console.log("find profiles");
    this.store.dispatch(this._actions.findProfiles());
  }
}

