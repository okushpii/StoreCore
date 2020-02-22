import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {ProductPageModule} from "./components/products-page/product-page.module";
import {HomePageModule} from "./components/home-page/home-page.module";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    ProductPageModule,
    HomePageModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
