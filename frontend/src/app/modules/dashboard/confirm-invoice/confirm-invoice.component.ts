import { Component, OnInit } from '@angular/core';
import { Invoice } from '../../../models/invoice';
import { DashboardService } from '../dashboard.service';
import { LoadingService } from '../../../components/loading/loading.service';

@Component({
  selector: 'app-confirm-invoice',
  templateUrl: './confirm-invoice.component.html',
  styleUrls: ['./confirm-invoice.component.scss'],
})
export class ConfirmInvoiceComponent implements OnInit {
  invoices: Invoice[];

  constructor(private loadingService: LoadingService,
              private dashboardService: DashboardService) {
  }

  ngOnInit() {
    this.loadingService.spinnerStart();
    this.dashboardService.getAllInvoice()
      .finally(() => this.loadingService.spinnerStop())
      .subscribe(resp => {
        this.invoices = resp.filter(item => item.confirmed === false);
      });
  }

  onConfirm(invoice) {
    this.loadingService.spinnerStart();
    this.dashboardService.confirmInvoice(invoice).subscribe(() => {
      this.ngOnInit();
    });
  }
}
