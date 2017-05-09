import { SetupActions } from './../../setup.action';
import { SetupModuleState } from './../../index';
import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {RaceCode} from "../race-code.interface";

// pascalCase: RaceCode
// snakeCase: race_code
// camelCase: raceCode
// kebabCase: race-code


@Component({
selector: 'pams-race-code-select',
templateUrl: './race-code-select.component.html',
})
export class RaceCodeSelectComponent implements OnInit {

private RACE_CODE = "setupModuleState.raceCode".split(".");
@Input() placeholder: string;
@Input() innerFormControl: FormControl;
raceCodes$: Observable<RaceCode[]>;

constructor(private store: Store<SetupModuleState>,
    private actions: SetupActions) {
    this.raceCodes$ = this.store.select(...this.RACE_CODE);
    }

    ngOnInit() {
    this.store.dispatch(this.actions.findRaceCodes());
    }

    selectChangeEvent(event: RaceCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
    }
}

