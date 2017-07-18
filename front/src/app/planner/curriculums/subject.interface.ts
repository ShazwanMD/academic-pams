import {SubjectType} from '../subjects/subject-type.enum';
import {MetaObject} from '../../core/meta-object.interface';
export interface Subject extends MetaObject {
  ordinal: number;
  subjectType: SubjectType;
}
