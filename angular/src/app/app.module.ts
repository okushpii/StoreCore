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
import {FooterComponent} from './components/common/footer/footer.component';
import {HomePageBodyComponent} from './components/home-page/home-page-body/home-page-body.component';
import {ProductsPageComponent} from './components/products-page/products-page.component';
import {ProductsPageBodyComponent} from './components/products-page/products-page-body/products-page-body.component';
import { BreadcrumbsComponent } from './components/products-page/products-page-body/breadcrumbs/breadcrumbs.component';
import { ProductFacetsComponent } from './components/products-page/products-page-body/product-facets/product-facets.component';
import { ProductSortingComponent } from './components/products-page/products-page-body/product-sorting/product-sorting.component';
import { ProductGridComponent } from './components/products-page/products-page-body/product-grid/product-grid.component';
import { ProductPaginationComponent } from './components/products-page/products-page-body/product-pagination/product-pagination.component';


const routes = [
  {path: "", component: HomePageComponent},
  {path: "products/:categoryId", component: ProductsPageComponent}
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
    ProductsPageComponent,
    ProductsPageBodyComponent,
    BreadcrumbsComponent,
    ProductFacetsComponent,
    ProductSortingComponent,
    ProductGridComponent,
    ProductPaginationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    RouterModule.forRoot(routes, {'onSameUrlNavigation': "reload"})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
