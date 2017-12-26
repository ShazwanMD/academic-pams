import { Pipe, PipeTransform } from '@angular/core';


@Pipe({name: 'academicSessionPipe'})
export class AcademicSessionPipe implements PipeTransform {

    transform(value: boolean): any {
        if(value){
            return 'OPEN';
        } 
        else if(!value){
            return 'CLOSED';
        }else{
            return 'UNKNOWN'
        }
        // switch(value[value.toString()]) {
        //     case true : {
        //         return 'OPEN';
        //     }
        //     case false : {
        //         return 'CLOSED';
        //     }
        // }
    }
}