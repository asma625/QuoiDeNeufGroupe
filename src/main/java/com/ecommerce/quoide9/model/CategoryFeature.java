package com.ecommerce.quoide9.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class CategoryFeature extends Category{

    @ManyToMany
    @JoinTable(
            name = "Features_in_category",
            joinColumns = @JoinColumn(name = "id_category", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_feature", referencedColumnName = "id")
    )
    private List<Feature> featureList;

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }
}