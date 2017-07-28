import {Pipe, PipeTransform} from '@angular/core';
import {AssessmentCategory} from '../../../shared/model/term/assessment-category.enum';

@Pipe({name: 'assessmentCategoryPipe'})
export class AssessmentCategoryPipe implements PipeTransform {

  transform(value: AssessmentCategory): any {
    if (!value) return value;
    switch (AssessmentCategory[value.toString()]) {
      case AssessmentCategory.COURSE_WORK : {
        return 'Kerja Kursus';
      }
      case AssessmentCategory.EXAM_WORK : {
        return 'Peperiksaan Akhir';
      }
      default: {
        return 'Ralat';
      }
    }
  }
}
