import { GradeCode } from './../grade-code.interface';
import { Observable } from 'rxjs/Observable';
import { Component, Input, OnInit } from '@angular/core';

import { Store } from '@ngrx/store';
import { FormControl } from '@angular/forms';
import { CommonActions } from './../../gender-codes/common.action';
import { CommonModuleState } from './../../index';


@Component({
    selector: 'pams-grade-code-select',
    templateUrl: './grade-code-select.component.html',
})

export class GradeCodeSelectComponent implements OnInit{

    private GRADE_CODE = "commonModuleState.gradeCodes".split(".");
    @Input() placeHolder: string;
    @Input() innerFormControl: FormControl;
    gradeCodes$: Observable<GradeCode[]>;

    constructor(private store: Store<CommonModuleState>,
                private actions: CommonActions){
                    this.gradeCodes$ = this.store.select(...this.GRADE_CODE);

                }
                ngOnInit(){
                    this.store.dispatch(this.actions.findGradeCodes());
                }
                selectChangeEvent(event: GradeCode){
                    this.innerFormControl.setValue(event,{emitEvent: false});
                }
}