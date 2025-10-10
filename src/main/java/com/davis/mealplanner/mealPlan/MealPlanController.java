package com.davis.mealplanner.mealPlan;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davis.mealplanner.exceptions.CurrentMealPlanNotFoundException;
import com.davis.mealplanner.exceptions.MealPlanIdNotFoundException;
import com.davis.mealplanner.exceptions.UnauthorizedAuthenticationException;
import com.davis.mealplanner.models.MealPlan;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mealplan")
public class MealPlanController {

    private final MealPlanService mealPlanService;

    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @GetMapping
    public ResponseEntity<List<MealPlan>> getMealPlans() throws UnauthorizedAuthenticationException {
        return ResponseEntity.ok(mealPlanService.getMealPlans());
    }

    @GetMapping("{id}")
    public ResponseEntity<MealPlan> getMealPlanById(@PathVariable("id") int mealPlanId) {
        return ResponseEntity.ok(mealPlanService.getMealPlanById(mealPlanId));
    }

    @GetMapping("/current")
    public ResponseEntity<MealPlan> getCurrentMealPlan()
            throws UnauthorizedAuthenticationException, CurrentMealPlanNotFoundException {
        return ResponseEntity.ok(mealPlanService.getCurrentMealPlan());
    }

    @PutMapping
    public ResponseEntity<MealPlan> upsertMealPlan(@Valid @RequestBody MealPlan mealPlan)
            throws UnauthorizedAuthenticationException {
        MealPlan upsertedMealPlan = mealPlanService.upsertMealPlan(mealPlan);

        HttpStatus status;
        if (mealPlan.getId() == upsertedMealPlan.getId()) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.CREATED;
        }

        return ResponseEntity.status(status).body(upsertedMealPlan);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMealPlan(@PathVariable("id") int mealPlanId)
            throws UnauthorizedAuthenticationException, MealPlanIdNotFoundException {
        this.mealPlanService.deleteMealPlan(mealPlanId);
        return ResponseEntity.noContent().build();
    }
}
