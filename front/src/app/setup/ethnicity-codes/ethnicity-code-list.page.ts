import { EthnicityCode } from './../../common/ethnicity-codes/ethnicity-code.interface';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';
import { Component, OnInit } from '@angular/core';
import { SetupModuleState } from './../index';
import { SetupActions } from './../setup.action';

@Component({
selector: 'pams-ethnicity-list-page',
templateUrl: './ethnicity-code-list.page.html',
})
export class EthnicityCodeListPage implements OnInit {
    private ETHNICITY_CODES = "setupModuleState.ethnicityCodes".split(".");
    private ethnicityCodes$: Observable<EthnicityCode>;
    private columns: any[] =[
        {name: 'code', label:'Code'},
        {name: 'descriptionMs', label:'DescriptionMs'},
        {name: 'descriptionEn', label:'DescriptionEn'},
        {name:'action', label:''}
    ];

    constructor(private store: Store<SetupModuleState>,
                private actions: SetupActions){
                    this.ethnicityCodes$ = this.store.select(...this.ETHNICITY_CODES);
                }

                ngOnInit() {
                    this.store.dispatch(this.actions.findEthnicityCodes());
                    this.store.dispatch(this.actions.changeTitle("Ethnicity Codes"))
                }

                filter():void{}
}