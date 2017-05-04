import {Routes, RouterModule} from '@angular/router';
import {ProfileDetailPage} from "./profile-detail.page";
import {ProfileCenterPage} from "./profile-center.page";
import {test1Page} from "./test1.page";

export const ProfileModuleRoutes: Routes = [
  {path: 'test1Page', component: test1Page},
    {path: 'profile', component: ProfileCenterPage},
  // {path: 'profile/:matricNo', component: ProfileDetailPage},
];




