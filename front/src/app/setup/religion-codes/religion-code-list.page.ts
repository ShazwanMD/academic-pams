import { ReligionCode } from './../../common/religion-codes/religion-code.interface';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';
import { Component, OnInit } from '@angular/core';
import { SetupModuleState } from './../index';
import { SetupActions } from './../setup.action';

@Component({
selector: 'pams-religion-list-page',
templateUrl: './religion-code-list.page.html',
})
export class ReligionCodeListPage implements OnInit {
    private RELIGION_CODES = "setupModuleState.religionCodes".split(".");
    private religionCodes$: Observable<ReligionCode>;
    private columns: any[] =[
        {name: 'code', label:'Code'},
        {name: 'descriptionMs', label:'DescriptionMs'},
        {name: 'descriptionEn', label:'DescriptionEn'},
        {name:'action', label:''}
    ];

    constructor(private store: Store<SetupModuleState>,
                private actions: SetupActions){
                    this.religionCodes$ = this.store.select(...this.RELIGION_CODES);
                }

                ngOnInit() {
                    this.store.dispatch(this.actions.findReligionCodes());
                    this.store.dispatch(this.actions.changeTitle("Religion Codes"))
                }

                filter():void{}
}