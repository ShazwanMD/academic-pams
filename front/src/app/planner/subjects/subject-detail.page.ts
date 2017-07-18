import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {PlannerModuleState} from '../index';
import {Subject} from '../curriculums/subject.interface';

@Component({
  selector: 'pams-subject-detail',
  templateUrl: './subject-detail.page.html',

})

export class SubjectDetailPage implements OnInit {

  private SUBJECT: string[] = 'plannerModuleState.subject'.split('.');
  private subject$: Observable<Subject>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              // private actions: SubjectActions,
              private store: Store<PlannerModuleState>) {
    this.subject$ = this.store.select(...this.SUBJECT);
  }

  ngOnInit(): void {
  }
}

