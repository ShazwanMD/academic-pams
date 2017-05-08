import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Admission} from "./admission.interface";
import {AdmissionActions} from "./admission.action";
import {TermModuleState} from "../index";

@Component({
  selector: 'pams-admission-detail',
  templateUrl: './admission-detail.page.html',
})

export class AdmissionDetailPage implements OnInit {

  private ADMISSION = "termModuleState.offering".split(".");
  private admission$: Observable<Admission>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AdmissionActions,
              private store: Store<TermModuleState>) {

    this.admission$ = this.store.select(...this.ADMISSION);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: {canonicalCode: string}) => {
      let canonicalCode: string = params.canonicalCode;
     // this.store.dispatch(this.actions.findAdmissionByCanonicalCode(canonicalCode));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/admissions']);
  }
}

