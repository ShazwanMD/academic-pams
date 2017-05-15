import { CountryCode } from './../country-codes/country-code.interface';
import { MetaObject } from "../../core/meta-object.interface";
export interface StateCode extends MetaObject {
  code: string;
  description: string;
  countryCode: CountryCode;

}