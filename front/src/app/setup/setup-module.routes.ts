import { StudyModeListPage } from './study-modes/study-mode-list.page';
import { StudyMode } from './../common/study-modes/study-mode.interface';
import { EthnicityCodeListPage } from './ethnicity-codes/ethnicity-code-list.page';
import { NationalityCodeListPage } from './nationality-codes/nationality-code-list.page';
import { ReligionCodeListPage } from './religion-codes/religion-code-list.page';
import { GradeCodeListPage } from './grade-codes/grade-code-list.page';
import { DunCodeListPage } from './dun-codes/dun-code-list.page';
import { DunCode } from './../common/dun-codes/dun-code.interface';
import { ParliamentCodeListPage } from './parliament-codes/parliament-code-list.page';
import { StateCodeListPage } from './state-codes/state-code-list.page';
import {GenderCodeListPage} from './gender-codes/gender-code-list.page';
import {RaceCodeListPage} from './race-codes/race-code-list.page';
import {SetupModule} from './index';
import {Routes, RouterModule} from '@angular/router';
import {SetupPage} from "./setup.page";
import {BankCodeListPage} from "./bank-codes/bank-code-list.page";
import {CountryCodeListPage} from './country-codes/country-code-list.page';
import {MaritalCodeListPage} from "./marital-codes/marital-code-list.page";

export const SetupModuleRoutes: Routes = [
  {
    path: 'setup', component: SetupPage,
    children: [
      {path: 'bank-codes', component: BankCodeListPage},
      {path: 'marital-codes', component: MaritalCodeListPage},
      {path: 'country-codes', component: CountryCodeListPage},
      {path: 'race-codes', component: RaceCodeListPage},
      {path: 'gender-codes', component: GenderCodeListPage},
      {path: 'state-codes', component: StateCodeListPage},
      {path: 'parliament-codes', component: ParliamentCodeListPage},
      {path: 'dun-codes', component: DunCodeListPage},
      {path: 'grade-codes', component: GradeCodeListPage},
      {path: 'religion-codes', component: ReligionCodeListPage},
      {path: 'nationality-codes', component: NationalityCodeListPage},
      {path: 'ethnicity-codes', component: EthnicityCodeListPage},
    {path: 'study-modes', component: StudyModeListPage},
    ]
  },
];
