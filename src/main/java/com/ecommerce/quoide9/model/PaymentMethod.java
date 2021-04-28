package com.ecommerce.quoide9.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String paymentMethodDescription;

    @OneToMany(mappedBy= "paymentMethod")
    private List<CustomerPaymentMethod> customerPaymentMethodList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentMethodDescription() {
        return paymentMethodDescription;
    }

    public void setPaymentMethodDescription(String paymentMethodDescription) {
        this.paymentMethodDescription = paymentMethodDescription;
    }

    public List<CustomerPaymentMethod> getCustomerPaymentMethodList() {
        return customerPaymentMethodList;
    }

    public void setCustomerPaymentMethodList(List<CustomerPaymentMethod> customerPaymentMethodList) {
        this.customerPaymentMethodList = customerPaymentMethodList;
    }
}