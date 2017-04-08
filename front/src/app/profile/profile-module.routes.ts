import {Routes, RouterModule} from '@angular/router';
import {ProfileDetailPage} from "./profile-detail.page";
import {ProfileCenterPage} from "./profile-center.page";

export const ProfileModuleRoutes: Routes = [
  {path: 'profile', component: ProfileCenterPage},
  {path: 'profile/:matricNo', component: ProfileDetailPage},
];
