import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TeamComponent } from './home/team/team.component';
import { LoginPageComponent } from './login/login-page.component';
import { SignUpPageComponent } from    './home/sign-up-page/sign-up-page.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'team', component: TeamComponent},
  {path:'**', redirectTo:'',pathMatch:'full'}
      {path:"", redirectTo:"login", pathMatch:"full"},
    {path:"login", component:LoginPageComponent},
    {path:"signUp", component:SignUpPageComponent},
    {path:"home", component:HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
