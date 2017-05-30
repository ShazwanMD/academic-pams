import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {TermService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Section} from "./section.interface";
import {SectionActions} from "./section.action";
import {TermModuleState} from "../index";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";

@Component({
  selector: 'pams-section-detail',
  templateUrl: './section-detail.page.html',
})

export class SectionDetailPage implements OnInit {

  private SECTION: string[] = "termModuleState.section".split(".");
  private section$: Observable<Section>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: SectionActions,
              private termService: TermService,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.section$ = this.store.select(...this.SECTION);
  }

  showDialog(): void {
  }

  showDialogDel(): void {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { canonicalCode: string }) => {
      let canonicalCode: string = params.canonicalCode;
      this.store.dispatch(this.actions.findSectionByCanonicalCode(canonicalCode));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/sections']);
  }
}

