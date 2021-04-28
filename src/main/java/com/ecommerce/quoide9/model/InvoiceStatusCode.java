package com.ecommerce.quoide9.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class InvoiceStatusCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String invoiceStatusDescription;


    @OneToMany(mappedBy="invoiceStatusCode")
    private List<Invoice> invoiceList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceStatusDescription() {
        return invoiceStatusDescription;
    }

    public void setInvoiceStatusDescription(String invoiceStatusDescription) {
        this.invoiceStatusDescription = invoiceStatusDescription;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
}