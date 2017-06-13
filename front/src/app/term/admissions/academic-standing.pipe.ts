import {Pipe, PipeTransform} from '@angular/core';
import {AcademicStanding} from "./academic-standing.enum";

@Pipe({name: 'academicStandingPipe'})
export class AcademicStandingPipe implements PipeTransform {

    transform(value: AcademicStanding): any {
        if (!value) return value;
        switch (AcademicStanding[value.toString()]) {
            case AcademicStanding.TBD : {
                return 'Tiada';
            }
            // case AcademicStanding.KB : {
            //     return 'KB';
            // }
            // case AcademicStanding.KG : {
            //     return 'KG';
            // }
            // case AcademicStanding.KS : {
            //     return 'KS';
            // }
            default: {
                return value;
            }
        }
    }
}