import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Faculty} from "./faculty.interface";
import {FacultyActions} from "./faculty.action";
import {PlannerState} from "../index";

@Component({
  selector: 'pams-faculty-center',
  templateUrl: './faculty-center.page.html',
})

export class FacultyCenterPage implements OnInit {

  private _commonService: CommonService;
  private _router: Router;
  private _route: ActivatedRoute;
  private _actions: FacultyActions;
  private store: Store<PlannerState>;
  private faculties$: Observable<Faculty[]>;

  constructor(router: Router,
              route: ActivatedRoute,
              actions: FacultyActions,
              store: Store<PlannerState>,
              commonService: CommonService) {

    this._router = router;
    this._route = route;
    this._commonService = commonService;
    this._actions = actions;
    this.store = store;
    this.faculties$ = this.store.select('faculties');
  }

  goBack(route: string): void {
    this._router.navigate(['/faculties']);
  }

  viewFaculty(faculty: Faculty) {
    console.log("faculty: " + faculty.id);
    this._router.navigate(['/faculties-detail', faculty.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this._actions.loadFaculties());
  }
}

