import {Injectable} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sorting} from "../models/sorting";
import {ActivatedRoute} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class SortingService {

  private sortingUrl: string = "http://localhost:8080/api/sorting/group";
  private EMPTY: string = "";

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute
  ) {
  }

  find(group: string): Observable<Sorting[]> {
    return this.http.get<Sorting[]>(SortingService.buildUrlWithGroup(this.sortingUrl, group));
  }

  private static buildUrlWithGroup(url:string, group:string): string{
    return url + "/" + group;
  }

  getSelectedSortingName(sortingList: Sorting[], sortingParam: string): string {
    if (!sortingList) {
      return this.EMPTY;
    }
    let selectedSorting;
    sortingList.forEach(s => {
      if (this.sortingIsSelected(s, sortingParam)) {
        selectedSorting = s;
      }
    });
    return selectedSorting ? selectedSorting.name : this.getDefaultSorting(sortingList);
  }

  private getDefaultSorting(sortingList: Sorting[]) {
    let defaultSorting;
    sortingList.forEach(s => {
      if (s.byDefault) {
        defaultSorting = s;
      }
    });
    return defaultSorting ? defaultSorting.name : this.EMPTY;
  }

  sortingIsSelected(sorting: Sorting, sortingParam: string): boolean {
    let result = false;
    this.route.queryParams.subscribe(p => {
      let sortingCode = p[sortingParam];
      result = sortingCode == sorting.code;
    });
    return result;
  }

}
