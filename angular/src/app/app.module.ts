import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import  {NgbModule} from "@ng-bootstrap/ng-bootstrap";

import { AppComponent } from './app.component';
import {HeaderComponent} from './components/header/header.component';
import {TopBarComponent} from './components/top-bar/top-bar.component';
import {NavBarComponent} from './components/nav-bar/nav-bar.component';
import {CategoryDropdownMenuComponent} from './components/category-dropdown-menu/category-dropdown-menu.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TopBarComponent,
    NavBarComponent,
    CategoryDropdownMenuComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
