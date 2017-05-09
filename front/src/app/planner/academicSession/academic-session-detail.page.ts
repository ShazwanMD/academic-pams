import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";

import {PlannerService} from '../../../services';
import {PlannerModuleState} from "../index";

import {AcademicSession} from "./academic-session.interface";
import {AcademicSessionActions} from "./academic-session.action";


@Component ({
    selector: 'pams-academic-session-detail',
    templateUrl: './academic-session-detail.page.html',
})

export class AcademicSessionDetailPage implements OnInit {

    private SESSION =   "plannerModuleState.session".split(".");
    private session$ : Observable <AcademicSession>;

    constructor (private router: Router,
                    private route: ActivatedRoute,
                    private actions: AcademicSessionActions,
                    private store: Store <PlannerModuleState>) 
                    {
                        this.session$ = this.store.select (...this.SESSION);
                    }
ngOnInit() : void {
    this.route.params.subscribe((params: {code: string}) => {
        let code: string = params.code;
        this.store.dispatch (this.actions.findSession(code));
    });
}

goBack (route: string) : void {
    this.router.navigate(['/sessions']);
}

}