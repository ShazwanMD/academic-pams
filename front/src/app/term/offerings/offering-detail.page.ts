import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Offering} from "./offering.interface";
import {OfferingActions} from "./offering.action";
import {TermModuleState} from "../index";

@Component({
  selector: 'pams-offering-detail',
  templateUrl: './offering-detail.page.html',
})

export class OfferingDetailPage implements OnInit {

  private OFFERING = "termModuleState.offering".split(".");
  private offering$: Observable<Offering>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: OfferingActions,
              private store: Store<TermModuleState>) {

    this.offering$ = this.store.select(...this.OFFERING);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: {canonicalCode: string}) => {
      let canonicalCode: string = params.canonicalCode;
      this.store.dispatch(this.actions.findOfferingByCanonicalCode(canonicalCode));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/offerings']);
  }
}

