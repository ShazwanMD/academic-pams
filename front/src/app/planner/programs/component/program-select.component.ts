import { Component, Input, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Store } from "@ngrx/store";
import { FormControl } from "@angular/forms";
import { ProgramActions } from "../program.action";
import { TermModuleState } from "../../index";
import { Program } from "../program.interface";


@Component({
    selector: 'pams-program-select',
    templateUrl: './program-select.component.html',
})
export class ProgramSelectComponent implements OnInit {

    private PROGRAMS = "termModuleState.programs".split(".");
    private programs$: Observable<Program[]>;
    @Input() placeholder: string;
    @Input() innerFormControl: FormControl;

    constructor(private store: Store<TermModuleState>,
        private actions: ProgramActions) {
        this.programs$ = this.store.select(...this.PROGRAMS);
    }

    ngOnInit() {
        this.store.dispatch(this.actions.findPrograms());
    }

    selectChangeEvent(event: Program) {
        this.innerFormControl.setValue(event, { emitEvent: false });
    }
}

