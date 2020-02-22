import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ProductsPageComponent} from "./products-page.component";
import {ProductsPageBodyComponent} from "./products-page-body/products-page-body.component";
import {BreadcrumbsComponent} from "./products-page-body/breadcrumbs/breadcrumbs.component";
import {ProductFacetsComponent} from "./products-page-body/product-facets/product-facets.component";
import {ProductSortingComponent} from "./products-page-body/product-sorting/product-sorting.component";
import {ProductGridComponent} from "./products-page-body/product-grid/product-grid.component";
import {ProductPaginationComponent} from "./products-page-body/product-pagination/product-pagination.component";
import {RouterModule} from "@angular/router";
import {HeaderModule} from "../common/header/header.module";
import {FooterModule} from "../common/footer/footer.module";

@NgModule({
  declarations: [
    ProductsPageComponent,
    ProductsPageBodyComponent,
    BreadcrumbsComponent,
    ProductFacetsComponent,
    ProductSortingComponent,
    ProductGridComponent,
    ProductPaginationComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    HeaderModule,
    FooterModule
  ],
  exports: [
    ProductsPageComponent,
    ProductsPageBodyComponent,
    BreadcrumbsComponent,
    ProductFacetsComponent,
    ProductSortingComponent,
    ProductGridComponent,
    ProductPaginationComponent,
  ]
})
export class ProductPageModule { }
