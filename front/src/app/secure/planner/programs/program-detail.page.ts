import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';

import {Program} from '../../../shared/model/planner/program.interface';
import {ProgramActions} from './program.action';

import {PlannerModuleState} from '../index';

@Component({
  selector: 'pams-program-detail',
  templateUrl: './program-detail.page.html',
})

export class ProgramDetailPage implements OnInit {

  private PROGRAM: string[] = 'plannerModuleState.program'.split('.');
  private program$: Observable<Program>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProgramActions,
              private store: Store<PlannerModuleState>) {
    this.program$ = this.store.select(...this.PROGRAM);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findProgramByCode(code));
    });
  }
}

