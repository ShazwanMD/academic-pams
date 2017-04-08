import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store, State} from "@ngrx/store";
import {Observable} from "rxjs";
import {EnrollmentApplication} from "./enrollment-application.interface";

@Component({
  selector: 'pams-enrollment-application-center',
  templateUrl: './enrollment-application-center.page.html',
})

export class EnrollmentApplicationCenterPage implements OnInit {

  private _identityService: IdentityService;
  private _commonService: CommonService;
  private _router: Router;
  private _route: ActivatedRoute;
  private enrollmentApplications$: Observable<EnrollmentApplication[]>;

  constructor(router: Router,
              route: ActivatedRoute,
              identityService: IdentityService,
              commonService: CommonService) {

    this._router = router;
    this._route = route;
    this._identityService = identityService;
    this._commonService = commonService;
    // this.enrollmentApplications$ = this.store.select('enrollmentApplications');
  }

  goBack(route: string): void {
    this._router.navigate(['/enrollmentApplications']);
  }

  viewTask(enrollmentApplication: EnrollmentApplication) {
    console.log("enrollmentApplication: " + enrollmentApplication.id);
    this._router.navigate(['/enrollmentApplications-detail', enrollmentApplication.id]);
  }

  ngOnInit(): void {
    console.log("dispatching action");
    // this.store.dispatch();
  }
}

