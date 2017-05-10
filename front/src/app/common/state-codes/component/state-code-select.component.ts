import { StateCode } from './../state-code.interface';
import { Observable } from 'rxjs/Observable';
import { Component, Input, OnInit } from '@angular/core';

import { Store } from '@ngrx/store';
import { FormControl } from '@angular/forms';
import { CommonActions } from './../../gender-codes/common.action';
import { CommonModuleState } from './../../index';


@Component({
    selector: 'pams-state-code-select',
    templateUrl: './state-code-select.component.html',
})

export class StateCodeSelectComponent implements OnInit{

    private STATE_CODE = "commonModuleState.stateCodes".split(".");
    @Input() placeHolder: string;
    @Input() innerFormControl: FormControl;
    stateCodes$: Observable<StateCode[]>;

    constructor(private store: Store<CommonModuleState>,
                private actions: CommonActions){
                    this.stateCodes$ = this.store.select(...this.STATE_CODE);

                }
                ngOnInit(){
                    this.store.dispatch(this.actions.findStateCodes());
                }
                selectChangeEvent(event: StateCode){
                    this.innerFormControl.setValue(event,{emitEvent: false});
                }
}