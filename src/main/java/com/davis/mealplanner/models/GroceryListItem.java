package com.davis.mealplanner.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grocery_list_item")
public class GroceryListItem {
    @Id
    @Column(name = "grocery_list_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity", nullable = false)
    private String quantity;

    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "checked", nullable = false)
    private boolean checked;

    @ManyToMany
    private List<Recipe> recipes;

    @ManyToOne
    @JoinColumn(name = "grocery_id", referencedColumnName = "grocery_id", nullable = false)
    private Grocery grocery;
}
