import {Routes} from '@angular/router';
import {ProfileDetailPage} from './profile-detail.page';
import {AdvisoryDetailPage} from './advisory-detail.page';
import {ProfileCenterPage} from './profile-center.page';
import { AdvisoryCenterPage } from "./advisory-center.page";

export const ProfileModuleRoutes: Routes = [
  {path: 'profile', component: ProfileCenterPage},
  {path: 'profile/advisory', component: AdvisoryCenterPage},
  {path: 'profile/profile-detail/:identityNo', component: ProfileDetailPage},
  {path: 'profile/advisory-detail/:identityNo', component: AdvisoryDetailPage},
];

