package org.mvpigs.proyectoFinalBD.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * API Validation Error Model
 *
 * When a DTO is validated and there are validation errors an instance of this class is thrown. It contains an optional
 * list of validation errors
 */
public class ApiValidationError extends ApiError {

    private List<ApiValidationErrorDetail> validationErrorDetails;

    public ApiValidationError(String id, String code, HttpStatus httpStatus, String message) {

        this(id, code, httpStatus, message, null);
    }

    public ApiValidationError(String id, String code, HttpStatus httpStatus, String message,
                              List<ApiValidationErrorDetail> validationErrors) {

        super(id, code, httpStatus, message);

        this.validationErrorDetails = validationErrors;
    }

    public List<ApiValidationErrorDetail> getValidationErrorDetails() {
        return validationErrorDetails;
    }

    public void setValidationErrorDetails(List<ApiValidationErrorDetail> validationErrorDetails) {
        this.validationErrorDetails = validationErrorDetails;
    }
}