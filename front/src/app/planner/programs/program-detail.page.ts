import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Program} from "./program.interface";
import {ProgramActions} from "./program.action";
import {PlannerModuleState} from "../index";

@Component({
  selector: 'pams-program-detail',
  templateUrl: './program-detail.page.html',
})

export class ProgramDetailPage implements OnInit {


  private PROGRAM = "plannerModuleState.program".split(".");
  private program$: Observable<Program>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProgramActions,
              private store: Store<PlannerModuleState>) {

    this.program$ = this.store.select(...this.PROGRAM);
    console.log("test log ");

    // (program$ | async).code
    this.program$.subscribe(program => console.log("program: " + program.code))
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: {code: string}) => {
      let code: string = params.code;
      console.log("Code in pdp: " + code);
      this.store.dispatch(this.actions.findProgram(code));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/programs']);
  }
}

