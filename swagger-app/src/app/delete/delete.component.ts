import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  constructor(private service: ItemService) { }

  deleteItem(data) {
    this.service.deleteItem(data.id).subscribe(response => {
      alert(response.response);
    })
    
    
  }

  ngOnInit(): void {
  }

}
