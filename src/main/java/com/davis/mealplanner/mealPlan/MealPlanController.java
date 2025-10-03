package com.davis.mealplanner.mealPlan;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davis.mealplanner.models.MealPlan;

@RestController
@RequestMapping("/mealplan")
public class MealPlanController {
    
    private final MealPlanService mealPlanService;

    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @GetMapping
    public ResponseEntity<List<MealPlan>> getMealPlans() {
        return ResponseEntity.ok(mealPlanService.getMealPlans());
    }
}
