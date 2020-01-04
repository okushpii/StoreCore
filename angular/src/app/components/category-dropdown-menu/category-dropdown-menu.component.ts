import { Component, OnInit } from '@angular/core';

import { Category } from '../../models/category';

@Component({
  selector: 'app-category-dropdown-menu',
  templateUrl: './category-dropdown-menu.component.html',
  styleUrls: ['./category-dropdown-menu.component.css']
})
export class CategoryDropdownMenuComponent implements OnInit {

  category:Category;

  constructor() { }

  ngOnInit() {
    this.category = {
      id: 12,
      name: "Snowboars",
      subCategories: [
        {
          id: 1,
          name: "lol",
          subCategories: []
        }
      ]
    };
  }

}
