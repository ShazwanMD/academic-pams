import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Admission} from "./admission.interface";
import {AdmissionActions} from "./admission.action";
import {TermModuleState} from "../index";

@Component({
  selector: 'pams-admission-detail',
  templateUrl: './admission-detail.page.html',
})

export class AdmissionDetailPage implements OnInit {

  private ADMISSION = "termModuleState.admission".split(".");
  private admission$: Observable<Admission>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AdmissionActions,
              private store: Store<TermModuleState>) {

    this.admission$ = this.store.select(...this.ADMISSION);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: {id: string}) => {
      let id: string = params.id;
     this.store.dispatch(this.actions.findAdmissionById(id));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/admissions']);
  }
}

