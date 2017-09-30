import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';

import {PlannerModuleState} from '../index';

import {AcademicSession} from '../../../shared/model/planner/academic-session.interface';
import {AcademicSessionActions} from './academic-session.action';
import { Graduation } from "../../../shared/model/graduation/graduation.interface";

@Component({
  selector: 'pams-academic-session-graduation-detail',
  templateUrl: './academic-session-graduation-detail.page.html',
})

export class AcademicSessionGraduationDetailPage implements OnInit {

  private ACADEMIC_SESSION: string[] = 'plannerModuleState.academicSession'.split('.');
  private GRADUATIONS: string[] = 'plannerModuleState.graduations'.split('.');
  private academicSession$: Observable<AcademicSession>;
  private graduations$: Observable<Graduation>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AcademicSessionActions,
              private store: Store<PlannerModuleState>) {
    this.academicSession$ = this.store.select(...this.ACADEMIC_SESSION);
    this.graduations$ = this.store.select(...this.GRADUATIONS);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findAcademicSessionByCode(code));
    });
  }

}
