import { Component, OnInit, ChangeDetectionStrategy,ViewContainerRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { IdentityService } from '../../../services';
import { TermService } from '../../../services';
import { CommonService } from '../../../services';
import { Store } from "@ngrx/store";
import { Observable } from "rxjs";
import { Section } from "./section.interface";
import { SectionActions } from "./section.action";
import { TermModuleState } from "../index";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {SectionUpdateTaskCreatorDialog} from "./dialog/section-update-task-creator.dialog";


@Component({
  selector: 'pams-section-detail',
  templateUrl: './section-detail.page.html',
})

export class SectionDetailPage implements OnInit {

  private SECTION = "termModuleState.section".split(".");
  private section$: Observable<Section>;
    private creatorDialogRef: MdDialogRef<SectionUpdateTaskCreatorDialog>;  

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
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '40%';
    config.height = '45%';
    config.position = {top: '3px'};
    this.creatorDialogRef = this.dialog.open(SectionUpdateTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }
    
  ngOnInit(): void {
    this.route.params.subscribe((params: { canonicalCode: string }) => {
      let canonicalCode: string = params.canonicalCode;
      this.store.dispatch(this.actions.findSectionByCanonicalCode(canonicalCode));
      //this.offering$ = this.termService.findOfferingByCanonicalCode(canonicalCode);


    });
  }

  goBack(route: string): void {
    this.router.navigate(['/sections']);
  }
}

