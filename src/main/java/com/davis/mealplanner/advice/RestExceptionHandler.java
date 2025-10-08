package com.davis.mealplanner.advice;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.davis.mealplanner.exceptions.CurrentMealPlanNotFoundException;
import com.davis.mealplanner.exceptions.IllegalGrocerySectionException;
import com.davis.mealplanner.exceptions.IllegalMealTypeException;
import com.davis.mealplanner.exceptions.MealPlanIdNotFoundException;
import com.davis.mealplanner.exceptions.UnauthorizedAuthenticationException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException methodArgumentNotValidException,
        HttpHeaders headers,
        HttpStatusCode status,
        WebRequest request
    ) {
        String errorMessage = "Invalid Data Format";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(IllegalGrocerySectionException.class)
    public ResponseEntity<String> handleIllegalGrocerySectionException(
        HttpServletRequest request,
        IllegalGrocerySectionException illegalGrocerySectionException
    ) {
        String errorMessage = illegalGrocerySectionException.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(IllegalMealTypeException.class)
    public ResponseEntity<String> handleIllegalMealTypeException(
        HttpServletRequest request,
        IllegalMealTypeException illegalMealTypeException
    ) {
        String errorMessage = illegalMealTypeException.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException illegalArgumentException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
    }

    @ExceptionHandler(MealPlanIdNotFoundException.class)
    public ResponseEntity<String> handleMealPlanIdNotFoundExcpetion(HttpServletRequest request, MealPlanIdNotFoundException mealPlanIdNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mealPlanIdNotFoundException.getMessage());
    }

    @ExceptionHandler(CurrentMealPlanNotFoundException.class)
    public ResponseEntity<String> handleCurrentMealPlanNotFoundException(HttpServletRequest request, CurrentMealPlanNotFoundException currentMealPlanNotFoundException) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(currentMealPlanNotFoundException.getMessage());
    }

    @ExceptionHandler(UnauthorizedAuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(HttpServletRequest request, UnauthorizedAuthenticationException authenticationException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authenticationException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(HttpServletRequest request, Exception exception) {
        String errorMessage = "Something Went Wrong";

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(Error.class)
    public ResponseEntity<String> handleGenericError(HttpServletRequest request, Error error) {
        String errorMessage = "Fatal Internal Server Error Occurred";

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
