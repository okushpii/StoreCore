import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {HomePageComponent} from "./components/home-page/home-page.component";
import {ProductsPageComponent} from "./components/products-page/products-page.component";


const routes = [
  {path: "", component: HomePageComponent},
  {path: "products/:categoryId", component: ProductsPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {'onSameUrlNavigation': "reload"}),],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
