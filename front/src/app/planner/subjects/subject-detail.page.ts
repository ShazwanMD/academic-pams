import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Subject} from "./subject.interface";
// import {SubjectActions} from "./subject.action";
import {PlannerModuleState} from "../index";

@Component({
  selector: 'pams-subject-detail',
  templateUrl: './subject-detail.page.html',
  
})

export class SubjectDetailPage implements OnInit {

  private SUBJECT: string[] = "plannerModuleState.subject".split(".");
  private subject$: Observable<Subject>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              // private actions: SubjectActions,
              private store: Store<PlannerModuleState>) {
    this.subject$ = this.store.select(...this.SUBJECT);
  }

  ngOnInit(): void {
    // this.route.params.subscribe((params: { id: string }) => {
    //   let id: string = params.id;
    //   this.store.dispatch(this.actions.findSubjectById(id));
    // });
  }

 // goBack(route: string): void {
   // this.router.navigate(['/Subjects']);
  }


