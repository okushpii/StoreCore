import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../models/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productsByCategoryUrl: string = "http://localhost:8080/api/products/c";

  constructor(
    private http: HttpClient
  ) {
  }

  find(categoryCode: string): Observable<Product[]> {
    return this.http.get<Product[]>(this.productsByCategoryUrl + '/' + categoryCode);
  }
}
