import { ParliamentCode } from './../../common/parliament-codes/parliament-code.interface';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';
import { Component, OnInit } from '@angular/core';
import { SetupModuleState } from './../index';
import { SetupActions } from './../setup.action';

@Component({
selector: 'pams-parliament-list-page',
templateUrl: './parliament-code-list.page.html',
})
export class ParliamentCodeListPage implements OnInit {
    private PARLIAMENT_CODES:string[] = "setupModuleState.parliamentCodes".split(".");
    private parliamentCodes$: Observable<ParliamentCode>;
    private columns: any[] =[
        {name: 'code', label:'Code'},
        {name: 'description', label:'Description'},
        {name:'action', label:''}
    ];

    constructor(private store: Store<SetupModuleState>,
                private actions: SetupActions){
                    this.parliamentCodes$ = this.store.select(...this.PARLIAMENT_CODES);
                }

                ngOnInit() {
                    this.store.dispatch(this.actions.findParliamentCodes());
                    this.store.dispatch(this.actions.changeTitle("Parliament Codes"))
                }

                filter():void{}
}
