import {MetaObject} from '../../core/meta-object.interface';
import {SubjectType} from './subject-type.enum';
export interface Subject extends MetaObject {
  type: string;
  ordinal: number;
  subjectType: SubjectType;
  selected?: boolean;
}
