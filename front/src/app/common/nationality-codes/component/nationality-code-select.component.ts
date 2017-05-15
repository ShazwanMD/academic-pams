import { NationalityCode } from './../nationality-code.interface';
import { Observable } from 'rxjs/Observable';
import { Component, Input, OnInit } from '@angular/core';

import { Store } from '@ngrx/store';
import { FormControl } from '@angular/forms';
import { CommonActions } from './../../gender-codes/common.action';
import { CommonModuleState } from './../../index';


@Component({
    selector: 'pams-nationality-code-select',
    templateUrl: './nationality-code-select.component.html',
})

export class NationalityCodeSelectComponent implements OnInit {

    private NATIONALITY_CODE = "commonModuleState.nationalityCodes".split(".");
    @Input() placeHolder: string;
    @Input() innerFormControl: FormControl;
    nationalityCodes$: Observable<NationalityCode[]>;

    constructor(private store: Store<CommonModuleState>,
        private actions: CommonActions) {
        this.nationalityCodes$ = this.store.select(...this.NATIONALITY_CODE);

    }
    ngOnInit() {
        this.store.dispatch(this.actions.findNationalityCodes());
    }
    selectChangeEvent(event: NationalityCode) {
        this.innerFormControl.setValue(event, { emitEvent: false });
    }
}