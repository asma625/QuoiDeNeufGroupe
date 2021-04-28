package com.ecommerce.quoide9.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String featureName;
    private String featureDescription;

    @ManyToMany(mappedBy = "featureList")
    private List<CategoryFeature> categoryFeatureList;

    @ManyToMany(mappedBy = "featureList")
    private List<Product> productList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(String featureDescription) {
        this.featureDescription = featureDescription;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<CategoryFeature> getCategoryFeatureList() {
        return categoryFeatureList;
    }

    public void setCategoryFeatureList(List<CategoryFeature> categoryFeatureList) {
        this.categoryFeatureList = categoryFeatureList;
    }
}