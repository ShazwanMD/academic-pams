import {SubjectType} from './subject-type.enum';
import {SubjectElectiveStatus} from './subject-elective-status.enum';
import {MetaObject} from '../../../core/meta-object.interface';
export interface Subject extends MetaObject {
  type: string;
  ordinal: number;
  subjectType: SubjectType;
  subjectElectiveStatus: SubjectElectiveStatus;
  selected?: boolean;
}
