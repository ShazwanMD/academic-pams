import {MetaObject} from '../../../core/meta-object.interface';
import {GuardianType} from './guardian-type.enum';
export interface Guardian extends MetaObject {
  name: string;
  identityNo: string;
  phone: string;
  guardianType: GuardianType;
}
