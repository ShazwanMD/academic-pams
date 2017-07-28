import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';

import {PlannerModuleState} from '../index';

import {AcademicSession} from '../../../shared/model/planner/academic-session.interface';
import {AcademicSessionActions} from './academic-session.action';

@Component({
  selector: 'pams-academic-session-detail',
  templateUrl: './academic-session-detail.page.html',
})

export class AcademicSessionDetailPage implements OnInit {

  private ACADEMIC_SESSION: string[] = 'plannerModuleState.academicSession'.split('.');
  private academicSession$: Observable<AcademicSession>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AcademicSessionActions,
              private store: Store<PlannerModuleState>) {
    this.academicSession$ = this.store.select(...this.ACADEMIC_SESSION);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findAcademicSessionByCode(code));
    });
  }

}
