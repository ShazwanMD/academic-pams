import { GenderCodeListPage } from './gender-codes/gender-code-list.page';
import {Routes, RouterModule} from '@angular/router';
import {SetupPage} from "./setup.page";



export const SetupModuleRoutes: Routes = [
  {path: 'setup', component: SetupPage},
   {path: 'setup/gender-codes', component: GenderCodeListPage}
 

];