import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadItemComponent } from './read-item.component';

describe('ReadItemComponent', () => {
  let component: ReadItemComponent;
  let fixture: ComponentFixture<ReadItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReadItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReadItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
