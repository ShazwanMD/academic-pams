import { TermService } from './../../../services/term.service';
import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Offering} from "./offering.interface";
import {OfferingActions} from "./offering.action";
import {TermModuleState} from "../index";

@Component({
  selector: 'pams-offering-center',
  templateUrl: './offering-center.page.html',
})
export class OfferingCenterPage implements OnInit {

  private OFFERINGS = "termModuleState.offerings".split(".");
  private offerings$: Observable<Offering[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: OfferingActions,
              private termService: TermService,
              private store: Store<TermModuleState>) {
    this.offerings$ = this.store.select(...this.OFFERINGS);
  }

  goBack(route: string): void {
    this.router.navigate(['/offerings']);
  }

  viewOffering(offering: Offering) {
    console.log("offering: " + offering.id);
    this.router.navigate(['/offerings-detail', offering.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findOfferings());
  // this.offerings$ = this.termService.findOfferings();

  }
}

