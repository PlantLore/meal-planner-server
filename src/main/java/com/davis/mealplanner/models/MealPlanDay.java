package com.davis.mealplanner.models;

import java.time.LocalDate;
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
@Table(name = "meal_plan_day")
public class MealPlanDay {
    @Id
    @Column(name = "meal_plan_day_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "day_date", nullable = false)
    private LocalDate day;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "meal_plan_day_id", referencedColumnName = "meal_plan_day_id")
    private List<Meal> meals;
}
