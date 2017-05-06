import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Faculty} from "./faculty.interface";
import {FacultyActions} from "./faculty.action";
import {PlannerModuleState} from "../index";

@Component({
  selector: 'pams-faculty-center',
  templateUrl: './faculty-center.page.html',
})

export class FacultyCenterPage implements OnInit {

  private FACULTIES = "plannerModuleState.faculties".split(".");
  private faculties$: Observable<Faculty[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: FacultyActions,
              private store: Store<PlannerModuleState>) {
    this.faculties$ = this.store.select(...this.FACULTIES);
  }

  goBack(route: string): void {
    this.router.navigate(['/faculties']);
  }

  viewFaculty(faculty: Faculty) {
    console.log("faculty: " + faculty.id);
    this.router.navigate(['/faculties-detail', faculty.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findFaculties());
  }
}

