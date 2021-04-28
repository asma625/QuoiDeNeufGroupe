package com.ecommerce.quoide9.model;

import com.ecommerce.quoide9.view.CustomJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String gender;
    @JsonView({CustomJsonView.VueCustomer.class})
    private String firstname;
    @JsonView({CustomJsonView.VueCustomer.class})
    private String lastname;
    private String email;
    private String loginPassword;
    private String phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "Customer_address",
            joinColumns = @JoinColumn(name = "id_customer", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_address", referencedColumnName = "id")
    )
    @JsonView({CustomJsonView.VueCustomer.class})
    private List<Address> addressList;

    @OneToMany(mappedBy = "customer")
    @JsonView({CustomJsonView.VueCustomer.class})
    private List<SearchHistory> searchHistoryList;

    @ManyToMany
    @JoinTable(
            name = "Customer_notification",
            joinColumns = @JoinColumn(name = "id_customer", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_notification", referencedColumnName = "id")
    )
    private List<Notification> notificationList;

    @OneToMany(mappedBy = "customer")
    private List<VisitProduct> visitProductList;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orderList;

    @OneToMany(mappedBy = "customer")
    private List<CustomerPaymentMethod> customerPaymentMethodList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<SearchHistory> getSearchHistoryList() {
        return searchHistoryList;
    }

    public void setSearchHistoryList(List<SearchHistory> searchHistoryList) {
        this.searchHistoryList = searchHistoryList;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    public List<VisitProduct> getVisitProductList() {
        return visitProductList;
    }

    public void setVisitProductList(List<VisitProduct> visitProductList) {
        this.visitProductList = visitProductList;
    }
}
