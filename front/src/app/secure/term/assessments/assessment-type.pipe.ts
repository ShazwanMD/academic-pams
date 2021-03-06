import {Pipe, PipeTransform} from '@angular/core';
import {AssessmentType} from '../../../shared/model/term/assessment-type.enum';

@Pipe({name: 'assessmentTypePipe'})
export class AssessmentTypePipe implements PipeTransform {

  transform(value: AssessmentType): any {
    if (!value) return value;
    switch (AssessmentType[value.toString()]) {
      case AssessmentType.HOMEWORK : {
          return 'HOMEWORK';
          //return 'Kerja Rumah';
      }
      case AssessmentType.QUIZ : {
          return 'QUIZ';
          //return 'Kuiz';
      }
      case AssessmentType.FINAL_EXAM : {
          return 'FINAL_EXAM';
          //return 'Peperiksaan Akhir';
      }
      default: {
        return value;
      }
    }
  }
}
