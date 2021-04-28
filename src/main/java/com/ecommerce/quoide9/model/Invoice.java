package com.ecommerce.quoide9.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date invoiceDate;
    private String invoiceDetails;

    @OneToOne(mappedBy = "invoice")
    private Payment payment;

    @OneToOne(mappedBy = "invoice")
    private Shipment shipment;

    @OneToOne
    @JoinColumn(name = "id_order")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "id_invoice_status_code")
    private InvoiceStatusCode invoiceStatusCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(String invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public Payment getPayments() {
        return payment;
    }

    public void setPayments(Payment payments) {
        this.payment = payments;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public InvoiceStatusCode getInvoiceStatusCode() {
        return invoiceStatusCode;
    }

    public void setInvoiceStatusCode(InvoiceStatusCode invoiceStatusCode) {
        this.invoiceStatusCode = invoiceStatusCode;
    }
}