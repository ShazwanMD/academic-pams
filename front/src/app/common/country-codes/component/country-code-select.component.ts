import { Observable } from 'rxjs/Observable';
import { Component, Input, OnInit } from '@angular/core';

import { Store } from '@ngrx/store';
import { FormControl } from '@angular/forms';
import { CommonActions } from './../../gender-codes/common.action';
import { CommonModuleState } from './../../index';
import { CountryCode } from './../country-code.interface';

@Component({
    selector: 'pams-country-code-select',
    templateUrl: './country-code-select.component.html',
})

export class CountryCodeSelectComponent implements OnInit{

    private COUNTRY_CODE = "commonModuleState.countryCodes".split(".");
    @Input() placeHolder: string;
    @Input() innerFormControl: FormControl;
    countryCodes$: Observable<CountryCode[]>;

    constructor(private store: Store<CommonModuleState>,
                private actions: CommonActions){
                    this.countryCodes$ = this.store.select(...this.COUNTRY_CODE);

                }
                ngOnInit(){
                    this.store.dispatch(this.actions.findCountryCodes());
                }
                selectChangeEvent(event: CountryCode){
                    this.innerFormControl.setValue(event,{emitEvent: false});
                }
}