import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store, State} from "@ngrx/store";
import {Observable} from "rxjs";
import {AdmissionApplication} from "./admission-application.interface";

@Component({
  selector: 'pams-admission-application-center',
  templateUrl: './admission-application-center.page.html',
})

export class AdmissionApplicationCenterPage implements OnInit {

  private _identityService: IdentityService;
  private _commonService: CommonService;
  private _router: Router;
  private _route: ActivatedRoute;

  private store: Store<State>;
  private admissionApplications$: Observable<AdmissionApplication[]>;

  constructor(router: Router,
              route: ActivatedRoute,
              store: Store<State>,
              identityService: IdentityService,
              commonService: CommonService) {

    this._router = router;
    this._route = route;
    this._identityService = identityService;
    this._commonService = commonService;
    this.store = store;
    this.admissionApplications$ = this.store.select('admissionApplications');
  }

  goBack(route: string): void {
    this._router.navigate(['/admissionApplications']);
  }

  viewTask(admissionApplication: AdmissionApplication) {
    console.log("admissionApplication: " + admissionApplication.id);
    this._router.navigate(['/admission-applications-detail', admissionApplication.id]);
  }

  ngOnInit(): void {
    console.log("dispatching action");
    // this.store.dispatch();
  }
}

