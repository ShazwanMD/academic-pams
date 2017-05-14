import { ReligionCode } from './../religion-code.interface';
import { Observable } from 'rxjs/Observable';
import { Component, Input, OnInit } from '@angular/core';

import { Store } from '@ngrx/store';
import { FormControl } from '@angular/forms';
import { CommonActions } from './../../gender-codes/common.action';
import { CommonModuleState } from './../../index';


@Component({
    selector: 'pams-religion-code-select',
    templateUrl: './religion-code-select.component.html',
})

export class ReligionCodeSelectComponent implements OnInit{

    private RELIGION_CODE = "commonModuleState.religionCodes".split(".");
    @Input() placeHolder: string;
    @Input() innerFormControl: FormControl;
   religionCodes$: Observable<ReligionCode[]>;

    constructor(private store: Store<CommonModuleState>,
                private actions: CommonActions){
                    this.religionCodes$ = this.store.select(...this.RELIGION_CODE);

                }
                ngOnInit(){
                    this.store.dispatch(this.actions.findStateCodes());
                }
                selectChangeEvent(event: ReligionCode){
                    this.innerFormControl.setValue(event,{emitEvent: false});
                }
}