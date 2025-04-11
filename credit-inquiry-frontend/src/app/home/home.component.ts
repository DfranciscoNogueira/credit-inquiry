import { Component, OnInit } from '@angular/core';
import { CreditService } from '../_services/credit.service';
import { CreditModel } from '../_model/credit.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  searchForm: FormGroup;
  credits?: CreditModel[] = [];

  constructor(private creditService: CreditService, private fb: FormBuilder) {
    this.searchForm = this.fb.group({
      numberSearch: ['', [Validators.required, Validators.pattern('^[0-9]*$')]], // Apenas números
      searchType: ['numeroCredito', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  allowOnlyNumbers(event: KeyboardEvent): void {
    const allowedKeys = ['Backspace', 'Tab', 'ArrowLeft', 'ArrowRight', 'Delete'];
    if (!/^\d$/.test(event.key) && !allowedKeys.includes(event.key)) {
        event.preventDefault();
    }
  }

  search(): void {
    if (this.searchForm.valid) {

      const searchType = this.searchForm.value.searchType;
      const numberSearch = this.searchForm.value.numberSearch;

      if (searchType === 'numeroCredito') {
        this.creditService.findByNumberCredit(numberSearch).subscribe({
          next: (data) => {
            this.credits = data;
          },
          error: (err) => this.logErro(err)
        });
      } else {
        this.creditService.findByNumberNfse(numberSearch).subscribe({
          next: (data) => {
            this.credits = data;
          },
          error: (err) => this.logErro(err)
        });
      }

    } else {
      alert('Por favor, preencha todos os campos corretamente!');
    }
  }

  logErro(error: any) {
    console.error('Erro ao buscar dados:', error);
  }

  clearInputs(): void {
    this.searchForm.reset({
      searchType: 'numeroCredito',
      numberSearch: ''
    });
    this.credits = [];
  }

}
