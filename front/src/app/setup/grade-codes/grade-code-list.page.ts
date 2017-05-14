import { GradeCode } from './../../common/grade-codes/grade-code.interface';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';
import { Component, OnInit } from '@angular/core';
import { SetupModuleState } from './../index';
import { SetupActions } from './../setup.action';

@Component({
selector: 'pams-grade-list-page',
templateUrl: './grade-code-list.page.html',
})
export class GradeCodeListPage implements OnInit {
    private GRADE_CODES = "setupModuleState.gradeCodes".split(".");
    private gradeCodes$: Observable<GradeCode>;
    private columns: any[] =[
        {name: 'code', label:'Code'},
        {name: 'description', label:'Description'},
        {name:'action', label:''}
    ];

    constructor(private store: Store<SetupModuleState>,
                private actions: SetupActions){
                    this.gradeCodes$ = this.store.select(...this.GRADE_CODES);
                }

                ngOnInit() {
                    this.store.dispatch(this.actions.findGradeCodes());
                    this.store.dispatch(this.actions.changeTitle("Grade Codes"))
                }

                filter():void{}
}