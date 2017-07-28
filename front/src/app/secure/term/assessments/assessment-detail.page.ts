import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {TermService} from '../../../../services';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Assessment} from '../../../shared/model/term/assessment.interface';
import {AssessmentActions} from './assessment.action';
import {TermModuleState} from '../index';
import {MdDialog} from '@angular/material';

@Component({
  selector: 'pams-assessment-detail',
  templateUrl: './assessment-detail.page.html',
})

export class AssessmentDetailPage implements OnInit {

  private ASSESSMENT: string[] = 'termModuleState.assessment'.split('.');
  private assessment$: Observable<Assessment>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AssessmentActions,
              private termService: TermService,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.assessment$ = this.store.select(...this.ASSESSMENT);
  }

  showDialog(): void {
  }

  showDialogDel(): void {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { id: number }) => {
      let id: number = params.id;
      this.store.dispatch(this.actions.findAssessmentById(id));
      console.log(id);
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/assessments']);
  }
}

