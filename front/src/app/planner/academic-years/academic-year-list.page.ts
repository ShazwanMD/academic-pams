import { Store } from '@ngrx/store';
import { MdDialog, MdDialogRef } from '@angular/material';
import { AcademicYearActions } from "./academic-year.action";
import { PlannerModuleState } from "./../index";
import { AcademicYear } from "./academic-year.interface";
import { Observable } from 'rxjs/Rx';
import { Component, ViewContainerRef, OnInit } from '@angular/core';


@Component({
    selector: 'pams-academic-year-page',
    templateUrl: 'academic-year-list.page.html',
})

export class AcademicYearListPage implements OnInit {

    private ACADEMIC_YEARS: string[] = "plannerModuleState.academicYears".split(".");
    private academicYears$: Observable<AcademicYear>;

    constructor(private store: Store<PlannerModuleState>,
        private actions: AcademicYearActions,
        private vcf: ViewContainerRef,
        private dialog: MdDialog) {
        this.academicYears$ = this.store.select(...this.ACADEMIC_YEARS);
    }

    ngOnInit() {
        this.store.dispatch(this.actions.findAcademicYears());
    }

}