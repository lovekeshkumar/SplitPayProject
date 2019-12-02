import { HomeComponent } from './home/home.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'
import { RouterModule, Routes } from '@angular/router'
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { TransactionComponent } from './transaction/transaction.component';
import { ActivitiesComponent } from './activities/activities.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
    {
        path: "",
        component: WelcomeComponent
    },
    {
        path: "home",
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
        path: "activities/:type",
        component: ActivitiesComponent
    },
    {
        path: "home",
        component: HomeComponent
    }
]

@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        SignUpComponent,
        SignInComponent,
        HomeComponent,
        TransactionComponent,
        ActivitiesComponent,
        WelcomeComponent
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