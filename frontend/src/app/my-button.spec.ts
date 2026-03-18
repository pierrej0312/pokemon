// src/app/my-button.spec.ts
import { describe, it, expect } from 'vitest';
import { TestBed } from '@angular/core/testing';
import { MyButton } from "./my-button.component";

describe('MyButton', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [MyButton] // standalone component
    });
  });

  it('should render button', () => {
    const fixture = TestBed.createComponent(MyButton);
    fixture.detectChanges();
    const el = fixture.nativeElement as HTMLElement;
    expect(el.querySelector('button')?.textContent).toBe('Click me');
  });
});
