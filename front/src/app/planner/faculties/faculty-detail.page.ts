import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Faculty} from '../../shared/model/planner/faculty.interface';
import {FacultyActions} from './faculty.action';
import {PlannerModuleState} from '../index';

@Component({
  selector: 'pams-faculty-detail',
  templateUrl: './faculty-detail.page.html',
})

export class FacultyDetailPage implements OnInit {

  private FACULTY: string[] = 'plannerModuleState.faculty'.split('.');
  private faculty$: Observable<Faculty>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: FacultyActions,
              private store: Store<PlannerModuleState>) {

    this.faculty$ = this.store.select(...this.FACULTY);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findFacultyByCode(code));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/faculties']);
  }
}

