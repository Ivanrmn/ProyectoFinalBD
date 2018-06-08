package org.mvpigs.proyectoFinalBD.controller;

import io.swagger.annotations.ApiModelProperty;

public class ApiValidationErrorDetail {
    @ApiModelProperty(example = "id")
    private String item;

    @ApiModelProperty(example = "Cannot be null")
    private String message;

    public ApiValidationErrorDetail(String item, String message) {
        this.item = item;
        this.message = message;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
