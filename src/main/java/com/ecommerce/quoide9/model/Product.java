package com.ecommerce.quoide9.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  productName;
    private double productPrice;
    private String  productDescription;
    private String  otherProductDetails;
    private boolean sale;
    private Date created;
    private Date modified;
    private Date deleted;

    @OneToMany(mappedBy = "product")
    private List<VisitProduct> visitProductList;

    @OneToMany(mappedBy = "product")
    private List<Notification> listNotification;

    @ManyToMany
    @JoinTable(
            name = "Product_Search_history",
            joinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_search_history", referencedColumnName = "id")
    )
    private List<SearchHistory> searchHistoryList;

    @ManyToMany
    @JoinTable(
            name = "Product_feature",
            joinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_feature", referencedColumnName = "id")
    )
    private List<Feature> featureList;

    @ManyToMany(mappedBy = "productList")
    private List<CategoryProduct> categoryProductList;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct>  orderProductList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getOtherProductDetails() {
        return otherProductDetails;
    }

    public void setOtherProductDetails(String otherProductDetails) {
        this.otherProductDetails = otherProductDetails;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    public List<VisitProduct> getVisitProductList() {
        return visitProductList;
    }

    public void setVisitProductList(List<VisitProduct> visitProductList) {
        this.visitProductList = visitProductList;
    }

    public List<Notification> getListNotification() {
        return listNotification;
    }

    public void setListNotification(List<Notification> listNotification) {
        this.listNotification = listNotification;
    }

    public List<SearchHistory> getSearchHistoryList() {
        return searchHistoryList;
    }

    public void setSearchHistoryList(List<SearchHistory> searchHistoryList) {
        this.searchHistoryList = searchHistoryList;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public List<CategoryProduct> getCategoryProductList() {
        return categoryProductList;
    }

    public void setCategoryProductList(List<CategoryProduct> categoryProductList) {
        this.categoryProductList = categoryProductList;
    }

    public List<OrderProduct> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProduct> orderProductList) {
        this.orderProductList = orderProductList;
    }
}
