import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';
import { Component, OnInit } from '@angular/core';
import { SetupModuleState } from './../index';
import { SetupActions } from './../setup.action';
import { StateCode } from './../../common/state-codes/state-code.interface';



@Component({
selector: 'pams-state-list-page',
templateUrl: './state-code-list.page.html',
})
export class StateCodeListPage implements OnInit {
    private STATE_CODES = "setupModuleState.stateCodes".split(".");
    private stateCodes$: Observable<StateCode>;
    private columns: any[] =[
        {name: 'code', label:'Code'},
        {name: 'description', label:'Description'},
        {name:'action', label:''}
    ];

    constructor(private store: Store<SetupModuleState>,
                private actions: SetupActions){
                    this.stateCodes$ = this.store.select(...this.STATE_CODES);
                }

                ngOnInit() {
                    this.store.dispatch(this.actions.findStateCodes());
                    this.store.dispatch(this.actions.changeTitle("State Codes"))
                }

                filter():void{}
}