import {Routes, RouterModule} from '@angular/router';

import {MainComponent} from './main/main.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {LoginComponent} from './login/login.component';
import {PlannerModuleRoutes} from "./planner/planner-module.routes";
import {HomeModuleRoutes} from "./home/home-module.routes";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {
    path: '', component: MainComponent,
    children: [
      ...HomeModuleRoutes,
      ...PlannerModuleRoutes,
    ]
  },
];

export const appRoutingProviders: any[] = [];

export const appRoutes: any = RouterModule.forRoot(routes, {useHash: false});
