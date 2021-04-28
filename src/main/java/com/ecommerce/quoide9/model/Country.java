package com.ecommerce.quoide9.model;

import com.ecommerce.quoide9.view.CustomJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonView({CustomJsonView.VueCustomer.class})
    private String name;
    @JsonView({CustomJsonView.VueCustomer.class})
    private String code;

    @OneToMany(mappedBy = "country")
    private List<Address> addressList;

    @OneToMany(mappedBy = "country")
    private List<State> stateList;


    /*public Country() {}

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }
}
