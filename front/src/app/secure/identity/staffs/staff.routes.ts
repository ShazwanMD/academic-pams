import {Routes, RouterModule} from '@angular/router';
import {StaffDetailPage} from './staff-detail.page';
import {StaffCenterPage} from './staff-center.page';

// Route Configuration
export const StaffRoutes: Routes = [
  {path: 'identity/staffs', component: StaffCenterPage},
  {path: 'identity/staffs/:identityNo', component: StaffDetailPage},
];
