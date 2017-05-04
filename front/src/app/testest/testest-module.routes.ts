import {Routes, RouterModule} from '@angular/router';
import {TestPage} from "./test.page";
import {AbcPage} from "./abc.page";


export const TestModuleRoutes: Routes = [
  {path: 'testest', component: TestPage},
  {path: 'testabc', component: AbcPage},
];