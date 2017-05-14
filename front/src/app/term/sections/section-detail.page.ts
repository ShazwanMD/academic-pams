import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Section} from "./section.interface";
import {SectionActions} from "./section.action";
import {TermModuleState} from "../index";

@Component({
  selector: 'pams-section-detail',
  templateUrl: './section-detail.page.html',
})

export class SectionDetailPage implements OnInit {

  private SECTION = "termModuleState.section".split(".");
  private section$: Observable<Section>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: SectionActions,
              private termService: TermService,
              private store: Store<TermModuleState>) {

    this.section$ = this.store.select(...this.SECTION);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: {canonicalCode: string}) => {
      let canonicalCode: string = params.canonicalCode;
      this.store.dispatch(this.actions.findSectionByCanonicalCode(canonicalCode));
     //this.offering$ = this.termService.findOfferingByCanonicalCode(canonicalCode);


    });
  }

  goBack(route: string): void {
    this.router.navigate(['/sections']);
  }
}

