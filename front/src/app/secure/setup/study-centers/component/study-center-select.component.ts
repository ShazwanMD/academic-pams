import { SetupModuleState } from '../../index';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import { SetupActions } from '../../setup.action';
import { Store } from '@ngrx/store';
import { Component, Input, OnInit } from '@angular/core';
import { StudyCenter } from '../study-center.interface';

@Component({
    selector: 'pams-study-center-select',
    templateUrl: './study-center-select.component.html',
})

export class StudyCentreSelectComponent implements OnInit {

    private STUDY_CENTER: string[] = "setupModuleState.studyCenters".split(".");
    @Input() placeholder: string;
    @Input() innerFormControl: FormControl;
    studyCenters$: Observable<StudyCenter[]>;

    constructor(private store: Store<SetupModuleState>,
        private actions: SetupActions) {
        this.studyCenters$ = this.store.select(...this.STUDY_CENTER);
    }

    ngOnInit() {
        this.store.dispatch(this.actions.findStudyCenters());
    }

    selectChangeEvent(event: StudyCenter) {
        this.innerFormControl.setValue(event, { emitEvent: false });
    }
}


