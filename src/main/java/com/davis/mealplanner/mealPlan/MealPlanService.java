package com.davis.mealplanner.mealPlan;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davis.mealplanner.exceptions.CurrentMealPlanNotFoundException;
import com.davis.mealplanner.exceptions.MealPlanIdNotFoundException;
import com.davis.mealplanner.exceptions.UnauthorizedAuthenticationException;
import com.davis.mealplanner.models.MealPlan;
import com.davis.mealplanner.security.SecurityUtils;

@Service
public class MealPlanService {

    private final MealPlanRepository mealPlanRepository;

    public MealPlanService(MealPlanRepository mealPlanRepository) {
        this.mealPlanRepository = mealPlanRepository;
    }

    public List<MealPlan> getMealPlans() throws UnauthorizedAuthenticationException {
        return mealPlanRepository.findAllByCreatorEmailOrderByCreatedOnDesc(SecurityUtils.getEmailFromJwt());
    }

    public MealPlan getMealPlanById(int mealPlanId) {
        return mealPlanRepository.findById(mealPlanId).orElseThrow(() -> new MealPlanIdNotFoundException(mealPlanId));
    }

    public MealPlan getCurrentMealPlan() throws UnauthorizedAuthenticationException, CurrentMealPlanNotFoundException {
        return mealPlanRepository
                .findFirstByCreatorEmailAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByCreatedOnDesc(
                        SecurityUtils.getEmailFromJwt(), java.time.LocalDate.now(), java.time.LocalDate.now())
                .orElseThrow(() -> new CurrentMealPlanNotFoundException());
    }

    public MealPlan upsertMealPlan(MealPlan mealPlan) throws UnauthorizedAuthenticationException {
        MealPlan existingMealPlan = null;
        if (mealPlan.getId() != null) {
            existingMealPlan = mealPlanRepository.findById(mealPlan.getId()).orElse(null);
        }
        if (existingMealPlan == null) {
            mealPlan.setCreatedOn(java.time.LocalDate.now());
            mealPlan.setCreatorEmail(SecurityUtils.getEmailFromJwt());
        } else if (!existingMealPlan.getCreatorEmail().equals(SecurityUtils.getEmailFromJwt())) {
            throw new UnauthorizedAuthenticationException();
        }

        return mealPlanRepository.save(mealPlan);
    }

    public void deleteMealPlan(int mealPlanId) throws UnauthorizedAuthenticationException, MealPlanIdNotFoundException {
        MealPlan mealPlan = mealPlanRepository.findById(mealPlanId)
                .orElseThrow(() -> new MealPlanIdNotFoundException(mealPlanId));

        if (!mealPlan.getCreatorEmail().equals(SecurityUtils.getEmailFromJwt())) {
            throw new UnauthorizedAuthenticationException();
        }

        mealPlanRepository.deleteById(mealPlanId);
    }
}
