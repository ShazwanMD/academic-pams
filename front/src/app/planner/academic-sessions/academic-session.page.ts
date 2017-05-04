import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {AcademicSession} from "./AcademicSession.interface";
import {AcademicSessionActions} from "./AcademicSession.action";
import {PlannerModuleState} from "../index";

@Component({
  selector: 'pams-AcademicSession-center',
  templateUrl: './AcademicSession-center.page.html',
})

export class AcademicSessionCenterPage implements OnInit {

  private ACADEMICSESSIONS = "plannerModuleState.AcademicSessions".split(".");

  private _commonService: CommonService;
  private _router: Router;
  private _route: ActivatedRoute;
  private _actions: CourseActions;
  private store: Store<PlannerModuleState>;
  private courses$: Observable<AcademicSession[]>;

  constructor(router: Router,
              route: ActivatedRoute,
              actions: CourseActions,
              store: Store<PlannerModuleState>,
              commonService: CommonService) {

    this._router = router;
    this._route = route;
    this._commonService = commonService;
    this._actions = actions;
    this.store = store;
    this.AcademicSessions$ = this.store.select(...this.ACADEMICSESSIONS );
  }

  goBack(route: string): void {
    this._router.navigate(['/AcademicSessions']);
  }

  viewAcademicSession(AcademicSession: AcademicSession) {
    console.log("AcademicSession: " + AcademicSession.id);
    this._router.navigate(['/AcademicSessions-detail', AcademicSession.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this._actions.findCourses());
  }
}

