import { RaceCode } from './race-code.interface';
import { SetupActions } from './../setup.action';
import { Observable } from 'rxjs/Observable';
import { SetupModuleState } from './../index';
import { Store } from '@ngrx/store';
import { Component, OnInit } from '@angular/core';


@Component({
selector: 'pams-race-list-page',
templateUrl: './race-code-list.page.html',
})
export class RaceCodeListPage implements OnInit {

private RACE_CODES = "setupModuleState.raceCodes".split(".");
private raceCodes$ : Observable<RaceCode>;
private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
];

constructor(private store: Store<SetupModuleState>,
    private actions: SetupActions) {
    this.raceCodes$ = this.store.select(...this.RACE_CODES);
    }

    ngOnInit() {
    this.store.dispatch(this.actions.findRaceCodes());
    }

}


