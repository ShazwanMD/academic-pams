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
import {Enrollment} from "../enrollments/enrollment.interface";
import {Appointment} from "../appointments/appointment.interface";
import {Assessment} from "../assessments/assessment.interface";

@Component({
  selector: 'pams-offering-detail',
  templateUrl: './offering-detail.page.html',
})

export class OfferingDetailPage implements OnInit {

  private OFFERING: string[] = "termModuleState.offering".split(".");
  private SECTIONS: string[] = "termModuleState.sections".split(".");
  private ASSESSMENTS: string[] = "termModuleState.assessments".split(".");
  private ENROLLMENTS: string[] = "termModuleState.enrollments".split(".");
  private APPOINTMENTS: string[] = "termModuleState.appointments".split(".");

  private offering$: Observable<Offering>;
  private sections$: Observable<Section[]>;
  private assessments$: Observable<Assessment[]>;
  private appointments: Observable<Appointment[]>;
  private enrollments$: Observable<Enrollment[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: OfferingActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private dialogDelete: MdDialog) {

    this.offering$ = this.store.select(...this.OFFERING);
    this.sections$ = this.store.select(...this.SECTIONS);
    this.assessments$ = this.store.select(...this.ASSESSMENTS);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
    this.appointments = this.store.select(...this.APPOINTMENTS);
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

