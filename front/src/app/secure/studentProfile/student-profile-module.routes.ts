import { StudentProfileExamPage } from './student-profile-exam.page';
import { StudentProfileDetailPage } from './student-profile-detail.page';
import { ProfileModuleRoutes } from './../profile/profile-module.routes';
import { AuthenticationGuard } from './../identity/guard/authentication.guard';
import { Student } from './../../shared/model/identity/student.interface';
import { StudentProfileCenterPage } from './student-profile-center.page';
import { Routes, CanActivate } from '@angular/router';
import { StudentAdmissionApplicationCenterPage } from "../term/admission-applications/admission-application-center2.page";

export const StudentProfileModuleRoutes: Routes =[
    {path:'studentProfile', component: StudentProfileCenterPage, canActivate: [AuthenticationGuard]},
    {path:'academicSessions', component:StudentProfileDetailPage},
    {path: 'academicSessionExamPage/:id', component:StudentProfileExamPage},
    {path: 'term/admission-applications/admission-application-center2/:id', component: StudentAdmissionApplicationCenterPage},
   
    ...ProfileModuleRoutes
]