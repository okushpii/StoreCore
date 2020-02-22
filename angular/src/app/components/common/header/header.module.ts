import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HeaderComponent} from "./header.component";
import {TopBarComponent} from "./top-bar/top-bar.component";
import {NavBarComponent} from "./nav-bar/nav-bar.component";
import {CategoryDropdownMenuComponent} from "./nav-bar/category-dropdown-menu/category-dropdown-menu.component";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    HeaderComponent,
    TopBarComponent,
    NavBarComponent,
    CategoryDropdownMenuComponent,
  ],
  imports: [
    CommonModule,
    NgbModule,
    RouterModule,
  ],
  exports: [
    HeaderComponent,
    TopBarComponent,
    NavBarComponent,
    CategoryDropdownMenuComponent
  ]
})
export class HeaderModule { }
