import { Offering } from './offerings/offering.interface';
import {Program} from './../planner/programs/program.interface';
import {Faculty} from './../planner/faculties/faculty.interface';
import {PlannerService} from './../../services/planner.service';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from '../../services';
import {TermService} from "../../services/term.service";
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';

@Component({
  selector: 'pams-term-page',
  templateUrl: './term.page.html',
})

export class TermPage implements OnInit {

// private OFFERINGS = "termModuleState.offerings".split(".");
  private offering$:Observable<Offering[]>;

  private _router: Router;
  private _route: ActivatedRoute;
  private _identityService: IdentityService;
  private _termService: TermService;
  

  constructor(router: Router,
              plannerService: PlannerService,
              route: ActivatedRoute,
              identityService: IdentityService,
           //   private store: Store<TermModuleState>,
           //   private actions: TermActions,
              private termService: TermService) {
    this._router = router;
    this._route = route;
    this._termService = termService;
   // this.offering$ = this.store.select(...this.OFFERINGS);
  }

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'canonicalCode', label: 'CanonicalCode'},
    {name: 'action', label: 'Action'}
  ];


  ngOnInit(): void {
    this._route.params.subscribe(() => {
    });
    this.offering$ = this.termService.findOfferings();
   // this.store.dispatch(this.actions.findOfferings());
  }
}
