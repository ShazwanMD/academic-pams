import {Routes, RouterModule} from '@angular/router';

import {MainComponent} from './main/main.component';
import {LoginComponent} from './login/login.component';
import {HomeModuleRoutes} from "./home/home-module.routes";
import {ProfileModuleRoutes} from "./profile/profile-module.routes";
import {GraduationModuleRoutes} from "./graduation/graduation-module.routes";
import {TermModuleRoutes} from "./term/term-module.routes";
import {PlannerModuleRoutes} from "./planner/planner-module.routes";


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {
    path: '', component: MainComponent,
    children: [
      ...HomeModuleRoutes,
      ...ProfileModuleRoutes,
      ...PlannerModuleRoutes,
      ...TermModuleRoutes,
      ...GraduationModuleRoutes,
      
    ]
  },
];

export const appRoutingProviders: any[] = [];

export const appRoutes: any = RouterModule.forRoot(routes, {useHash: false});
