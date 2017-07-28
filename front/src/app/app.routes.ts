import {Routes, RouterModule} from '@angular/router';
import {ProfileModuleRoutes} from './secure/profile/profile-module.routes';
import {IdentityModuleRoutes} from './secure/identity/identity-module.routes';
import {GraduationModuleRoutes} from './secure/graduation/graduation-module.routes';
import {TermModuleRoutes} from './secure/term/term-module.routes';
import {PlannerModuleRoutes} from './secure/planner/planner-module.routes';
import {SetupModuleRoutes} from './secure/setup/setup-module.routes';
import {HomePage} from './home/home.page';
import {LoginPage} from './login/login.page';
import {ForgetPasswordPage} from './login/forget-password.page';
import {DashboardPage} from './secure/dashboard.page';
import {SecurePage} from './secure/secure.page';
import {AuthenticationGuard} from './secure/identity/guard/authentication.guard';

const routes: Routes = [
  {path: '', component: HomePage},
  {path: 'login', component: LoginPage},
  {path: 'forget-password', component: ForgetPasswordPage},
  {
    path: 'secure', component: SecurePage, canActivate: [AuthenticationGuard],
    children: [
      {path: '', component: DashboardPage},
      ...ProfileModuleRoutes,
      ...PlannerModuleRoutes,
      ...IdentityModuleRoutes,
      ...TermModuleRoutes,
      ...GraduationModuleRoutes,
      ...SetupModuleRoutes,
    ],
  },
];

export const appRoutingProviders: any[] = [];

export const appRoutes: any = RouterModule.forRoot(routes, {useHash: false});
