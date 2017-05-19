import {TermService} from './../../../services/term.service';
import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Offering} from "./offering.interface";
import {OfferingActions} from "./offering.action";
import {TermModuleState} from "../index";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {OfferingCreateTaskCreatorDialog} from "./dialog/offering-create-task-creator.dialog";

@Component({
  selector: 'pams-offering-center',
  templateUrl: './offering-center.page.html',
})
export class OfferingCenterPage implements OnInit {

  private OFFERINGS: string[] = "termModuleState.offerings".split(".");
  private offerings$: Observable<Offering[]>;
  private creatorDialogRef: MdDialogRef<OfferingCreateTaskCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: OfferingActions,
              private termService: TermService,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.offerings$ = this.store.select(...this.OFFERINGS);
  }

  goBack(route: string): void {
    this.router.navigate(['/offerings']);
  }

  viewOffering(offering: Offering) {
    console.log("offering: " + offering.id);
    this.router.navigate(['/offerings-detail', offering.id]);
  }

  filter(): void {

  }

  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '70%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(OfferingCreateTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findOfferings());
    // this.offerings$ = this.termService.findOfferings();

  }
}

