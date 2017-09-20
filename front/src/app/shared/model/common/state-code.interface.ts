import { CountryCode } from './country-code.interface';
import { MetaObject } from '../../../core/meta-object.interface';
export interface StateCode extends MetaObject {
  code: string;
  descriptionEn: string;
  descriptionMs: string;
  countryCode: CountryCode;

}
