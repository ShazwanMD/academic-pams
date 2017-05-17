import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Offering} from "./offering.interface";
import {OfferingActions} from "./offering.action";
import {TermModuleState} from "../index";
import {Section} from "../sections/section.interface";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {OfferingUpdateTaskCreatorDialog} from "./dialog/offering-update-task-creator.dialog";

@Component({
  selector: 'pams-offering-detail',
  templateUrl: './offering-detail.page.html',
})

export class OfferingDetailPage implements OnInit {

  private OFFERING = "termModuleState.offering".split(".");
  private SECTIONS = "termModuleState.sections".split(".");


  private offering$: Observable<Offering>;
  private sections$: Observable<Section[]>;
  private creatorDialogRef: MdDialogRef<OfferingUpdateTaskCreatorDialog>;   

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: OfferingActions,
              private termService: TermService,
              private store: Store<TermModuleState>,
               private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.offering$ = this.store.select(...this.OFFERING);
    this.sections$ = this.store.select(...this.SECTIONS);
  }

     showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '40%';
    config.height = '90%';
    config.position = {top: '3px'};
    this.creatorDialogRef = this.dialog.open(OfferingUpdateTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }
    
  ngOnInit(): void {
    this.route.params.subscribe((params: { canonicalCode: string }) => {
      let canonicalCode: string = params.canonicalCode;
      this.store.dispatch(this.actions.findOfferingByCanonicalCode(canonicalCode));

    });
  }

  goBack(route: string): void {
    this.router.navigate(['/offerings']);
  }
}

