import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Gradebook} from '../../../shared/model/term/gradebook.interface';
import {Appointment} from '../../../shared/model/term/appointment.interface';
import {GradebookActions} from './gradebook.action';
import {TermModuleState} from '../index';
import {MdDialog} from '@angular/material';

@Component({
  selector: 'pams-gradebook-detail',
  templateUrl: './gradebook-detail.page.html',
})

export class GradebookDetailPage implements OnInit {
  private GRADEBOOK: string[] = 'termModuleState.gradebook'.split('.');
  private APPOINTMENT: string[] = 'termModuleState.appointment'.split('.');
  private gradebook$: Observable<Gradebook>;
  private appointment$: Observable<Appointment>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: GradebookActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.gradebook$ = this.store.select(...this.GRADEBOOK);
    this.appointment$ = this.store.select(...this.APPOINTMENT);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { id: string }) => {
      let id: string = params.id;
      this.store.dispatch(this.actions.findGradebookById(id));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/gradebooks']);
  }
}

