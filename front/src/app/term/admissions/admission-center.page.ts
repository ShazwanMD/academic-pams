import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Store } from "@ngrx/store";
import { Observable } from "rxjs";
import { Admission } from "./admission.interface";
import { AdmissionActions } from "./admission.action";
import { TermModuleState } from "../index";

@Component({
  selector: 'pams-admission-center',
  templateUrl: './admission-center.page.html',
})
export class AdmissionCenterPage implements OnInit {

  private ADMISSIONS = "termModuleState.admissions".split(".");
  private admissions$: Observable<Admission[]>;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private actions: AdmissionActions,
    private store: Store<TermModuleState>) {
    this.admissions$ = this.store.select(...this.ADMISSIONS);
  }

  goBack(route: string): void {
    this.router.navigate(['/admissions']);
  }

  viewAdmission(admission: Admission) {
    console.log("admission: " + admission.id);
    this.router.navigate(['/admissions-detail', admission.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findAdmissions());
  }
}

