import { HomeComponent } from './home/home.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'
import { RouterModule, Routes } from '@angular/router'
import { AppComponent } from './app.component';
//import{ GroupComponent } from './group/group.component'
import { NavbarComponent } from './navbar/navbar.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { TransactionComponent } from './transaction/transaction.component';
import { ActivitiesComponent } from './activities/activities.component';
import { ViewComponent } from './view/view.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { SplitComponent } from './split/split.component';
import { RegistrationComponent } from './registration/registration.component'; 
import { from } from 'rxjs';

const routes: Routes = [
    {
        path: "",
        component: HomeComponent
    },
    {
        path: "signin",
        component: SignInComponent
    },
    {
        path: "signup",
        component: SignUpComponent
    },
    {
        path: "transaction",
        component: TransactionComponent

    },
    {
        path: "activities",
        component: ActivitiesComponent
    },
    
    {
        path: "view",
        component: ViewComponent
    },
    {
        path: "welcome",
        component: WelcomeComponent
    },
    {
        path: "split",
        component: SplitComponent
    },
    // {
    //     path: "group",
    //     component: GroupComponent
    // }
    {
        path: "registration",
        component: RegistrationComponent
    },
]

@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        SignUpComponent,
        SignInComponent,
        HomeComponent,
       // GroupComponent,
        TransactionComponent,
        ActivitiesComponent,
        ViewComponent,
        WelcomeComponent,
        SplitComponent,
        RegistrationComponent,

    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        RouterModule.forRoot(routes)
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }