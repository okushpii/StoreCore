export class Category {
  code:string;
  name:string;
  childCategories:Category[];
  superCategory: Category;
}
