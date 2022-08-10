import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'clientCategory'
})
export class ClientCategoryPipe implements PipeTransform {

  transform(ca: number, param?: string): string {
    if(param == "description") {
      if(ca < 0) {
        return 'Client en négatif';
      } else if (ca > 0) {
        return 'Client en positif';
      } else {
        return "Client neutre";
      }
    }

    if(ca < 0) {
      return 'red';
    } else if (ca > 0) {
      return 'blue';
    } else {
      return "green";
    }
  }

}
