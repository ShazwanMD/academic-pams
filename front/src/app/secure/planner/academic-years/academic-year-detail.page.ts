import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';

import {PlannerModuleState} from '../index';

import {AcademicYear} from '../../../shared/model/planner/academic-year.interface';
import {AcademicYearActions} from './academic-year.action';

@Component({
  selector: 'pams-academic-year-detail',
  templateUrl: './academic-year-detail.page.html',
})

export class AcademicYearDetailPage implements OnInit {

  private ACADEMIC_YEAR: string[] = 'plannerModuleState.academicYear'.split('.');
  private academicYear$: Observable<AcademicYear>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AcademicYearActions,
              private store: Store<PlannerModuleState>) {
    this.academicYear$ = this.store.select(...this.ACADEMIC_YEAR);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findAcademicYearByCode(code));
    });
  }

}
