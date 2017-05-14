import { NationalityCode } from './../../common/nationality-codes/nationality-code.interface';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';
import { Component, OnInit } from '@angular/core';
import { SetupModuleState } from './../index';
import { SetupActions } from './../setup.action';

@Component({
selector: 'pams-nationality-list-page',
templateUrl: './nationality-code-list.page.html',
})
export class NationalityCodeListPage implements OnInit {
    private NATIONALITY_CODES = "setupModuleState.nationalityCodes".split(".");
    private nationalityCodes$: Observable<NationalityCode>;
    private columns: any[] =[
        {name: 'code', label:'Code'},
        {name: 'descriptionMs', label:'DescriptionMs'},
        {name: 'descriptionEn', label:'DescriptionEn'},
        {name:'action', label:''}
    ];

    constructor(private store: Store<SetupModuleState>,
                private actions: SetupActions){
                    this.nationalityCodes$ = this.store.select(...this.NATIONALITY_CODES);
                }

                ngOnInit() {
                    this.store.dispatch(this.actions.findNationalityCodes());
                    this.store.dispatch(this.actions.changeTitle("Nationality Codes"))
                }

                filter():void{}
}