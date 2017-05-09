import { RaceCodeListPage } from './race-codes/race-code-list.page';
import { MaritalCodeListPage } from './marital-codes/marital-code-list.page';
import { CountryCodeListPage } from './country-codes/country-code-list.page';
import { GenderCodeListPage } from './gender-codes/gender-code-list.page';
import {Routes, RouterModule} from '@angular/router';
import {SetupPage} from "./setup.page";




export const SetupModuleRoutes: Routes = [
  {path: 'setup', component: SetupPage},
   {path: 'setup/gender-codes', component: GenderCodeListPage},
     {path: 'setup/country-codes', component: CountryCodeListPage},
     {path: 'setup/marital-codes', component: MaritalCodeListPage},
     {path: 'setup/race-codes', component: RaceCodeListPage}
 

];