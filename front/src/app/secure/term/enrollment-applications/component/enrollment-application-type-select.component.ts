import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {EnrollmentApplicationType} from '../../../../shared/model/term/enrollment-application-type.enum';

@Component({
    selector: 'pams-enrollment-application-type-select',
    templateUrl: './enrollment-application-type-select.component.html',
})
export class EnrollmentApplicationTypeSelectComponent implements OnInit {

    private enrollmentApplicationTypes: EnrollmentApplicationType[] = <EnrollmentApplicationType[]>[];

    @Input() placeholder: string;
    @Input() innerFormControl: FormControl;

    constructor() {
        for (let n in EnrollmentApplicationType) {
            if (typeof EnrollmentApplicationType[n] === 'string')
                this.enrollmentApplicationTypes.push(EnrollmentApplicationType[n.toString()]);
        }
    }

    ngOnInit() {
    }

    selectChangeEvent(event: EnrollmentApplicationType) {
        this.innerFormControl.setValue(event, { emitEvent: false });
    }
}

