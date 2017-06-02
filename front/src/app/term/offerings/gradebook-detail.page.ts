import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef, Input, EventEmitter, Output} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {OfferingUpdateDialog} from "./dialog/offering-update.dialog";
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
import {Enrollment} from "../enrollments/enrollment.interface";
import {Appointment} from "../appointments/appointment.interface";
import {Assessment} from "../assessments/assessment.interface";

@Component({
  selector: 'pams-gradebook-detail',
  templateUrl: './gradebook-detail.page.html',
})

export class GradebookDetailPage implements OnInit {

  private OFFERING: string[] = "termModuleState.offering".split(".");
  private GRADEBOOK_MATRICES: string[] = "termModuleState.gradebookMatrices".split(".");
  private offering$: Observable<Offering>;
  private gradebookMatrices$: Observable<Section>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: OfferingActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef) {

    this.offering$ = this.store.select(...this.OFFERING);
    this.gradebookMatrices$ = this.store.select(...this.GRADEBOOK_MATRICES);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { canonicalCode: string }) => {
      let canonicalCode: string = params.canonicalCode;
      this.store.dispatch(this.actions.findOfferingByCanonicalCode(canonicalCode));
    });

    this.offering$.subscribe((offering: Offering) => {
      if (offering.canonicalCode) this.store.dispatch(this.actions.findGradebookMatricessByOffering(offering))
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/offerings']);
  }
}

