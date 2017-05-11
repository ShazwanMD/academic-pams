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

    private ACADEMICSESSION =   "plannerModuleState.academicSession".split(".");
    private academicSession$ : Observable <AcademicSession>;

    constructor (private router: Router,
                    private route: ActivatedRoute,
                    private actions: AcademicSessionActions,
                    private store: Store <PlannerModuleState>) 
                    {
                        this.academicSession$ = this.store.select (...this.ACADEMICSESSION);
                    }
ngOnInit() : void {
    this.route.params.subscribe((params: {code: string}) => {
        let code: string = params.code;
        this.store.dispatch (this.actions.findAcademicSession(code));
    });
}

goBack (route: string) : void {
    this.router.navigate(['/academic-sessions']);
}

}