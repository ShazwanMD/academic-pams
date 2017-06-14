import {Pipe, PipeTransform} from '@angular/core';
import {EnrollmentStanding} from "./enrollment-standing.enum";

@Pipe({name: 'enrollmentStandingPipe'})
export class EnrollmentStandingPipe implements PipeTransform {

    transform(value: EnrollmentStanding): any {
        if (!value) return value;
        switch (EnrollmentStanding[value.toString()]) {
            case EnrollmentStanding.HW : {
                return 'Hadir Wajib';
            }
             case EnrollmentStanding.UG : {
                 return 'Ulang Gred';
             }
             case EnrollmentStanding.UM : {
                 return 'Ulang Matapelajaran';
             }
            // case AcademicStanding.KS : {
            //     return 'KS';
            // }
            default: {
                return value;
            }
        }
    }
}