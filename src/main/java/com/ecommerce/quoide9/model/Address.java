package com.ecommerce.quoide9.model;

import com.ecommerce.quoide9.view.CustomJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonView({CustomJsonView.VueCustomer.class})
    private int streetNumber;
    @JsonView({CustomJsonView.VueCustomer.class})
    private String streetName;

    @ManyToOne
    @JsonView({CustomJsonView.VueCustomer.class})
    @JoinColumn(name = "id_country")
    private Country country;

    @ManyToMany(mappedBy = "addressList")
    private List<Customer> customerList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
