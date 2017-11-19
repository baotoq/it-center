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
    invoice.loading = true;
    this.dashboardService.confirmInvoice(invoice)
      .finally(() => invoice.loading = false)
      .subscribe(() => {
        this.invoices = this.invoices.filter(i => i.id !== invoice.id);
      });
  }

  onCancel(invoice) {
    invoice.cancelLoading = true;
    this.dashboardService.cancelInvoice(invoice)
      .finally(() => invoice.cancelLoading = false)
      .subscribe(() => {
        this.invoices = this.invoices.filter(i => i.id !== invoice.id);
      });
  }
}
