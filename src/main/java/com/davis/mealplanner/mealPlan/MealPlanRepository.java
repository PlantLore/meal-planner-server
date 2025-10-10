package com.davis.mealplanner.mealPlan;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davis.mealplanner.models.MealPlan;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Integer> {
        // Find the most recently created MealPlan for a specific creator whose startDate is not in the future and endDate is not already past
        public Optional<MealPlan> findFirstByCreatorEmailAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByCreatedOnDesc(String creatorEmail, LocalDate startDate, LocalDate endDate);

        public List<MealPlan> findAllByCreatorEmailOrderByCreatedOnDesc(String emailFromJwt);
}
