import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {TermService} from '../../../../services';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Section} from '../../../shared/model/term/section.interface';
import {SectionActions} from './section.action';
import {TermModuleState} from '../index';
import {MdDialog} from '@angular/material';
import {Appointment} from '../../../shared/model/term/appointment.interface';
import {Enrollment} from '../../../shared/model/term/enrollment.interface';
import {Offering} from '../../../shared/model/term/offering.interface';

@Component({
  selector: 'pams-section-detail',
  templateUrl: './section-detail.page.html',
})

export class SectionDetailPage implements OnInit {

  private OFFERING: string[] = 'termModuleState.offering'.split('.');
  private SECTION: string[] = 'termModuleState.section'.split('.');
  private ENROLLMENTS: string[] = 'termModuleState.enrollments'.split('.');
  private APPOINTMENTS: string[] = 'termModuleState.appointments'.split('.');
  private APPOINTMENT: string[] = 'termModuleState.appointment'.split('.');
  private offering$: Observable<Offering>;
  private section$: Observable<Section>;
  private appointments$: Observable<Appointment[]>;
  private appointment$: Observable<Appointment>;
  private enrollments$: Observable<Enrollment[]>;

  @Input() section: Section;
  @Input() offering: Offering;
  @Input() appointment: Appointment;


  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: SectionActions,
              private termService: TermService,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.section$ = this.store.select(...this.SECTION);
    this.offering$ = this.store.select(...this.OFFERING);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
    this.appointments$ = this.store.select(...this.APPOINTMENTS);
    this.appointment$ = this.store.select(...this.APPOINTMENT);
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
