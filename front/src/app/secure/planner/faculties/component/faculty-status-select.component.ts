import { OnInit, Component, Input } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FacultyStatus } from '../../../../shared/model/planner/faculty-status.enum';

@Component({
    selector: 'pams-faculty-status-select',
    templateUrl: './faculty-status-select.component.html',
})

export class FacultyStatusSelectComponent implements OnInit {

    private statuses: FacultyStatus[] = <FacultyStatus[]>[];
    @Input() placeholder: string;
    @Input() innerFormControl: FormControl;

    constructor() {
        for (let n in FacultyStatus) {
            if (typeof FacultyStatus[n] === 'string')
                this.statuses.push(FacultyStatus[n.toString()]);
        }
    }

    ngOnInit() {
    }

    selectChangeEvent(event: FacultyStatus) {
        this.innerFormControl.setValue(event, { emitEvent: false });
    }
}
