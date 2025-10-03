package com.davis.mealplanner.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grocery_list")
public class GroceryList {
    @Id
    @Column(name = "grocery_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "creator_email", nullable = false)
    private String creatorEmail;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "grocery_list_id", referencedColumnName = "grocery_list_id", nullable = false)
    private List<GroceryListSection> grocerySections;
}
