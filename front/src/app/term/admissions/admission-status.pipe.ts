import {Pipe, PipeTransform} from '@angular/core';
import {AdmissionStatus} from "./admission-status.enum";

@Pipe({name: 'admissionStatusPipe'})
export class AdmissionStatusPipe implements PipeTransform {

    transform(value: AdmissionStatus): any {
        if (!value) return value;
        switch (AdmissionStatus[value.toString()]) {
            case AdmissionStatus.ADMITTED : {
                return 'Masuk';
            }
            case AdmissionStatus.POSTPONED : {
                return 'Tangguh';
            }
            case AdmissionStatus.SUSPENDED : {
                return 'Gantung';
            }
            default: {
                return value;
            }
        }
    }
}