import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ProductService} from "../../../../services/product.service";
import {Product} from "../../../../models/product";

@Component({
  selector: 'app-product-grid',
  templateUrl: './product-grid.component.html',
  styleUrls: ['./product-grid.component.css']
})
export class ProductGridComponent implements OnInit {

  products: Product[];

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService
  ) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(p => {
      let categoryCode = p.get("categoryId");
      this.fetchProducts(categoryCode);
    });
  }

  private fetchProducts(categoryCode: string) {
    this.productService.find(categoryCode).subscribe(p => {
      this.products = p;
    });
  }
}
