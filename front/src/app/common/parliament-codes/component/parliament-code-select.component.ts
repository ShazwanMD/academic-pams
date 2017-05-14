import { ParliamentCode } from './../parliament-code.interface';
import { Observable } from 'rxjs/Observable';
import { Component, Input, OnInit } from '@angular/core';

import { Store } from '@ngrx/store';
import { FormControl } from '@angular/forms';
import { CommonActions } from './../../gender-codes/common.action';
import { CommonModuleState } from './../../index';


@Component({
    selector: 'pams-parliament-code-select',
    templateUrl: './parliament-code-select.component.html',
})

export class ParliamentCodeSelectComponent implements OnInit{

    private PARLIAMENT_CODE = "commonModuleState.parliamentCodes".split(".");
    @Input() placeHolder: string;
    @Input() innerFormControl: FormControl;
    parliamentCodes$: Observable<ParliamentCode[]>;

    constructor(private store: Store<CommonModuleState>,
                private actions: CommonActions){
                    this.parliamentCodes$ = this.store.select(...this.PARLIAMENT_CODE);

                }
                ngOnInit(){
                    this.store.dispatch(this.actions.findParliamentCodes());
                }
                selectChangeEvent(event: ParliamentCode){
                    this.innerFormControl.setValue(event,{emitEvent: false});
                }
}