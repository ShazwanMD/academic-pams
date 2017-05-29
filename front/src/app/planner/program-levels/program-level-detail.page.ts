import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';

import {PlannerModuleState} from "../index";

import {ProgramLevel} from "./program-level.interface";
import {ProgramLevelActions} from "./program-level.action";


@Component({
  selector: 'pams-program-level-detail',
  templateUrl: './program-level-detail.page.html',
})

export class ProgramLevelDetailPage implements OnInit {

  private PROGRAM_LEVEL: string[] = "plannerModuleState.programLevel".split(".");
  private programLevel$: Observable<ProgramLevel>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProgramLevelActions,
              private store: Store<PlannerModuleState>) {
    this.programLevel$ = this.store.select(...this.PROGRAM_LEVEL);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findProgramLevelByCode(code));
    });
  }

}
