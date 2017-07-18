import {MetaObject} from '../../core/meta-object.interface';
import {FacultyStatus} from './faculty-status.enum';

export interface Faculty extends MetaObject {
  code: string;
  name: string;
  description: string;
  prefix: string;
  status: FacultyStatus;
}
