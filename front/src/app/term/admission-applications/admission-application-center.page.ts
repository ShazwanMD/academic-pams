import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
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
  private admissionApplications$: Observable<AdmissionApplication[]>;

  constructor(router: Router,
              route: ActivatedRoute,
              identityService: IdentityService,
              commonService: CommonService) {

    this._router = router;
    this._route = route;
    this._identityService = identityService;
    this._commonService = commonService;
    // this.admissionApplications$ = this.store.select('admissionApplications');
  }

  goBack(route: string): void {
    this._router.navigate(['/admissionApplications']);
  }
  
   showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(EnrollmentApplicationTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
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

