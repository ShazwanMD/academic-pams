import { TermService } from './../../../services/term.service';
import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Section} from "./section.interface";
import {SectionActions} from "./section.action";
import {TermModuleState} from "../index";

@Component({
  selector: 'pams-section-center',
  templateUrl: './section-center.page.html',
})
export class SectionCenterPage implements OnInit {

  private SECTIONS = "termModuleState.sections".split(".");
  private sections$: Observable<Section[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: SectionActions,
              private termService: TermService,
              private store: Store<TermModuleState>) {
    this.sections$ = this.store.select(...this.SECTIONS);
  }

  goBack(route: string): void {
    this.router.navigate(['/sections']);
  }

  viewSection(section: Section) {
    console.log("section: " + section.id);
    this.router.navigate(['/sections-detail', section.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findSections());
  // this.offerings$ = this.termService.findOfferings();

  }
}

