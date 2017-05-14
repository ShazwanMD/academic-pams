import { EthnicityCode } from './../ethnicity-code.interface';
import { Observable } from 'rxjs/Observable';
import { Component, Input, OnInit } from '@angular/core';

import { Store } from '@ngrx/store';
import { FormControl } from '@angular/forms';
import { CommonActions } from './../../gender-codes/common.action';
import { CommonModuleState } from './../../index';


@Component({
    selector: 'pams-ethnicity-code-select',
    templateUrl: './ethnicity-code-select.component.html',
})

export class EthnicityCodeSelectComponent implements OnInit{

    private ETHNICITY_CODE = "commonModuleState.ethnicityCodes".split(".");
    @Input() placeHolder: string;
    @Input() innerFormControl: FormControl;
    ethnicityCodes$: Observable<EthnicityCode[]>;

    constructor(private store: Store<CommonModuleState>,
                private actions: CommonActions){
                    this.ethnicityCodes$ = this.store.select(...this.ETHNICITY_CODE);

                }
                ngOnInit(){
                    this.store.dispatch(this.actions.findEthnicityCodes());
                }
                selectChangeEvent(event: EthnicityCode){
                    this.innerFormControl.setValue(event,{emitEvent: false});
                }
}