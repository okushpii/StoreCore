import { Component, OnInit } from '@angular/core';
import { CategoryService } from "../../services/category.service";
import {Category} from "../../models/category";


@Component({
  selector: 'app-category-dropdown-menu',
  templateUrl: './category-dropdown-menu.component.html',
  styleUrls: ['./category-dropdown-menu.component.css']
})
export class CategoryDropdownMenuComponent implements OnInit {

  categories:Category[];

  constructor(
    private categoryService:CategoryService
  ) { }

  ngOnInit() {
    this.categoryService.findAll().subscribe(result => {
      this.categories = result;
    });
  }

}
