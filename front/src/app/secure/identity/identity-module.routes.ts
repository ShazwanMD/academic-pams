import {Routes, RouterModule} from '@angular/router';
import {IdentityComponent} from './identity.component';
import {StaffRoutes} from './staffs/staff.routes';

// Route Configuration
export const IdentityModuleRoutes: Routes = [
  {path: 'identity', component: IdentityComponent},
  ...StaffRoutes,
];
