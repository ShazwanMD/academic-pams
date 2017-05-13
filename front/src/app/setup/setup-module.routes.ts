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
    ]
  },
];
