import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {TermService} from '../../../../services';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Section} from '../../../shared/model/term/section.interface';
import {TermModuleState} from '../index';
import {MdDialog} from '@angular/material';
import {Appointment} from '../../../shared/model/term/appointment.interface';
import {Enrollment} from '../../../shared/model/term/enrollment.interface';
import {Offering} from '../../../shared/model/term/offering.interface';
import { EnrollmentApplicationItem } from "../../../shared/model/term/enrollment-application-item.interface";
import { EnrollmentApplicationActions } from "./enrollment-application.action";

@Component({
  selector: 'pams-item-detail',
  templateUrl: './item-detail.page.html',
})

export class ItemDetailPage implements OnInit {

  private OFFERING: string[] = 'termModuleState.offering'.split('.');
  private SECTION: string[] = 'termModuleState.section'.split('.');
  private ENROLLMENTS: string[] = 'termModuleState.enrollments'.split('.');
  private APPOINTMENTS: string[] = 'termModuleState.appointments'.split('.');
  private APPOINTMENT: string[] = 'termModuleState.appointment'.split('.');
  private ITEM: string[] = 'termModuleState.item'.split('.');

  private offering$: Observable<Offering>;
  private section$: Observable<Section>;
  private appointments$: Observable<Appointment[]>;
  private appointment$: Observable<Appointment>;
  private enrollments$: Observable<Enrollment[]>;
  private item$: Observable<EnrollmentApplicationItem>;

  @Input() section: Section;
  @Input() offering: Offering;
  @Input() appointment: Appointment;


  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentApplicationActions,
              private termService: TermService,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.section$ = this.store.select(...this.SECTION);
    this.offering$ = this.store.select(...this.OFFERING);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
    this.appointments$ = this.store.select(...this.APPOINTMENTS);
    this.appointment$ = this.store.select(...this.APPOINTMENT);
    this.item$ = this.store.select(...this.ITEM);
  }

  showDialog(): void {
  }

  showDialogDel(): void {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { id: string }) => {
      let id: string = params.id;
      this.store.dispatch(this.actions.findEnrollmentApplicationById(id));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/sections']);
  }
}
