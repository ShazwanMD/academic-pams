import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {IdentityService} from "../../services/identity.service";
import {CommonService} from "../../services/common.service";
import {ProfileService} from "../../services/profile.service";
import {Student} from "../identity/student.interface";
import {ProfileState} from "./profile.reducer";
import {ProfileActions} from "./profile.action";

@Component({
  selector: 'pams-profile-detail',
  templateUrl: 'profile-detail.page.html',
})

export class ProfileDetailPage implements OnInit {

  private _identityService: IdentityService;
  private _commonService: CommonService;
  private _profileService: ProfileService;
  private _router: Router;
  private _route: ActivatedRoute;
  private _actions: ProfileActions;
  private store: Store<ProfileState>;
  private student$: Observable<Student>;

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
    this.student$ = this.store.select('student');
  }

  ngOnInit(): void {
    this._route.params.subscribe((params: {identityNo: string}) => {
      let identityNo: string = params.identityNo;
      this.store.dispatch(this._actions.findProfile(identityNo));
    });
  }

  goBack(route: string): void {
    this._router.navigate(['/profiles']);
  }
}

