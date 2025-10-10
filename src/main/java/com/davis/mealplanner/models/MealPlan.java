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
@Table(name = "meal_plan")
public class MealPlan {
    @Id
    @Column(name = "meal_plan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "creator_email", nullable = false)
    private String creatorEmail;

    @Column(name = "created_on", nullable = false)
    private LocalDate createdOn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "meal_plan_id", referencedColumnName = "meal_plan_id")
    private List<MealPlanDay> mealPlanDays;
}
