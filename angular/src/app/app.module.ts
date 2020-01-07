import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {RouterModule} from "@angular/router";

import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {HeaderComponent} from './components/common/header/header.component';
import {TopBarComponent} from './components/common/header/top-bar/top-bar.component';
import {NavBarComponent} from './components/common/header/nav-bar/nav-bar.component';
import {CategoryDropdownMenuComponent} from './components/common/header/nav-bar/category-dropdown-menu/category-dropdown-menu.component';
import {HomePageComponent} from './components/home-page/home-page.component';
import { FooterComponent } from './components/common/footer/footer.component';
import { HomePageBodyComponent } from './components/home-page/home-page-body/home-page-body.component';


const routes = [
  {path: "", component: HomePageComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TopBarComponent,
    NavBarComponent,
    CategoryDropdownMenuComponent,
    HomePageComponent,
    FooterComponent,
    HomePageBodyComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
