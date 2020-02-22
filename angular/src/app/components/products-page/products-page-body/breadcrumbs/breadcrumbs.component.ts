import {Component, OnInit} from '@angular/core';
import {Category} from "../../../../models/category";
import {ActivatedRoute} from "@angular/router";
import {CategoryService} from "../../../../services/category.service";

@Component({
  selector: 'app-breadcrumbs',
  templateUrl: './breadcrumbs.component.html',
  styleUrls: ['./breadcrumbs.component.css']
})
export class BreadcrumbsComponent implements OnInit {

  category: Category;

  constructor(
    private route: ActivatedRoute,
    private categoryService: CategoryService
  ) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(p => {
      let categoryCode = p.get("categoryId");
        this.getCategory(categoryCode);
    });
  }

  getCategory(code: string) {
    this.categoryService.find(code).subscribe(c => {
      this.category = c;
    });
  }

}
