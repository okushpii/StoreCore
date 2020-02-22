import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HomePageComponent} from "./home-page.component";
import {HomePageBodyComponent} from "./home-page-body/home-page-body.component";
import {RouterModule} from "@angular/router";
import {HeaderModule} from "../common/header/header.module";
import {FooterModule} from "../common/footer/footer.module";


@NgModule({
  declarations: [
    HomePageComponent,
    HomePageBodyComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    HeaderModule,
    FooterModule
  ],
  exports: [
    HomePageComponent,
    HomePageBodyComponent
  ]
})
export class HomePageModule {
}
