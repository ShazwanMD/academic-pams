import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {PlannerService} from "../../../../services/planner.service";
import {Cohort} from "../cohort.interface";
import {CohortActions} from "../cohort.action";;
import {MetaState} from "../../../core/meta-state.enum";
import {Store} from "@ngrx/store";
import {PlannerModuleState} from "../../index";
import {MdDialogRef} from "@angular/material";
import {AcademicSession} from "../../../planner/academic-sessions/academic-session.interface";
//import {Program} from './../../programs/program.interface';

@Component({
    selector: 'pams-cohort-creator',
    templateUrl: './cohort-creator-creator.dialog.html',
})

export class CohortCreatorDialog implements OnInit {

    private creatorForm: FormGroup;


    constructor(private formBuilder: FormBuilder,
        private store: Store<PlannerModuleState>,
        private actions: CohortActions,
        private dialog: MdDialogRef<CohortCreatorDialog>) {
    }

    ngOnInit(): void {
        this.creatorForm = this.formBuilder.group(<Cohort>{
            id: null,
            code: '',
            description: '',
           // program: <Program>{},
            academicSession: <AcademicSession>{},

         });
     }


    save(cohort: Cohort, isValid: boolean) {
       this.store.dispatch(this.actions.saveCohort(cohort));
        this.dialog.close();
    
}
}
