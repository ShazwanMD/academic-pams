import { ProfileModuleRoutes } from './../profile/profile-module.routes';
import { AuthenticationGuard } from './../identity/guard/authentication.guard';
import { Student } from './../../shared/model/identity/student.interface';
import { StudentProfileCenterPage } from './student-profile-center.page';
import { Routes, CanActivate } from '@angular/router';

export const StudentProfileModuleRoutes: Routes =[
    {path:'studentProfile', component: StudentProfileCenterPage, canActivate: [AuthenticationGuard]},
    ...ProfileModuleRoutes
]