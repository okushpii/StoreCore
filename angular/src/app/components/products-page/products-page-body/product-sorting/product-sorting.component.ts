import {Component, OnInit} from '@angular/core';
import {SortingService} from "../../../../services/sorting.service";
import {Sorting} from "../../../../models/sorting";
import {ActivatedRoute} from "@angular/router";

const sortingGroup = "pdp";
const sortingParam = "sorting";

@Component({
  selector: 'app-product-sorting',
  templateUrl: './product-sorting.component.html',
  styleUrls: ['./product-sorting.component.css']
})


export class ProductSortingComponent implements OnInit {

  sortingList: Sorting[];

  constructor(
    private route: ActivatedRoute,
    private sortingService: SortingService
  ) {
  }

  ngOnInit() {
    this.loadSorting();
  }

  loadSorting() {
    this.sortingService.find(sortingGroup).subscribe(s => {
      this.sortingList = s;
    })
  }

  getSelectedSortingName(sortingList: Sorting[]): string {
    return this.sortingService.getSelectedSortingName(sortingList, sortingParam);
  }

  sortingIsSelected(sorting: Sorting): boolean {
    return this.sortingService.sortingIsSelected(sorting, sortingParam);
  }
}
