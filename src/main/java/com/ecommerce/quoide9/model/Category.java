package com.ecommerce.quoide9.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoryTitle;
    private String categoryDescription;

    @ManyToMany
    @JoinTable(
            name = "Category_Parent",
            joinColumns = @JoinColumn(name = "id_category", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_category_parent")
    )
    private List<Category> parentCategory;

    @ManyToMany
    @JoinTable(
            name = "Category_Parent",
            joinColumns = @JoinColumn(name = "id_category_parent", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_category")
    )
    private List<Category> subCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<Category> getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(List<Category> parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<Category> subCategory) {
        this.subCategory = subCategory;
    }
}
