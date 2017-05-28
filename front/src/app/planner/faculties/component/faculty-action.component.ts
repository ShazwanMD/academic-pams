import { Store } from '@ngrx/store';
import { MdSnackBar } from '@angular/material';
import { MdDialog } from '@angular/material';
import { PlannerModuleState } from '../..';
import { Observable } from 'rxjs/Observable';
import { ChangeDetectionStrategy, Component, Input, ViewContainerRef } from '@angular/core';

import { FacultyActions } from "./../faculty.action";
import { Faculty } from "./../faculty.interface";


@Component({
    selector: 'pams-faculty-action',
    templateUrl: './faculty-action.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})

export class FacultyActionComponent {

    private FACULTY: string[] = "plannerModuleState.faculty".split(".");

    @Input() faculty: Faculty;

    constructor(private actions: FacultyActions,
        private store: Store<PlannerModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog,
        private snackBar: MdSnackBar) {

    }

    activate(): void {
        let snackBarRef = this.snackBar.open("Activating Faculty", "OK");
        snackBarRef.afterDismissed().subscribe(() =>
            this.store.dispatch(this.actions.activateFaculty(this.faculty)));
    }

    deactivate(): void {
        let snackBarRef = this.snackBar.open("Deactivating Faculty", "OK");
        snackBarRef.afterDismissed().subscribe(() =>
            this.store.dispatch(this.actions.deactivateFaculty(this.faculty)));
    }
}