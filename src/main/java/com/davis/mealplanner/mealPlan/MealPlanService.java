package com.davis.mealplanner.mealPlan;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davis.mealplanner.models.MealPlan;

@Service
public class MealPlanService {
    
    private final MealPlanRepository mealPlanRepository;

    public MealPlanService(MealPlanRepository mealPlanRepository) {
        this.mealPlanRepository = mealPlanRepository;
    }

    public List<MealPlan> getMealPlans() {
        return mealPlanRepository.findAll();
    }
}
