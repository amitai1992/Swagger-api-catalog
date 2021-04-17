import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  constructor(private service: ItemService) { }

  // send delete request to the server on click 
  deleteItem(data) {
    this.service.deleteItem(data.id).subscribe(response => {
      alert(response.response);
    })
    
    
  }

  ngOnInit(): void {
  }

}
