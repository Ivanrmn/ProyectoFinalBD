package org.mvpigs.proyectoFinalBD.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


    /**
     * Api Error Model
     */public class ApiError {

        @ApiModelProperty(example = "26f89b0c-e7b7-4a7d-87dc-e8a4024cd8be")
        private String id;

        @ApiModelProperty(example = "BAS-API-01")
        private String code;

        @ApiModelProperty(dataType = "java.util.Date", example = "2017-12-23T08:29:31.367Z")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime date;

        @ApiModelProperty(example = "500")
        private int httpStatus;

        @ApiModelProperty(example = "Internal Server Error")
        private String httpErrorMessage;

        @ApiModelProperty(example = "Something really bad happened")
        private String message;

        public ApiError(String id, String code, HttpStatus httpStatus, String message) {

            this.id = id;
            this.code = code;
            this.date = LocalDateTime.now();
            this.httpStatus = httpStatus.value();
            this.httpErrorMessage = httpStatus.getReasonPhrase();
            this.message = message;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public int getHttpStatus() {
            return httpStatus;
        }

        public void setHttpStatus(int httpStatus) {
            this.httpStatus = httpStatus;
        }

        public String getHttpErrorMessage() {
            return httpErrorMessage;
        }

        public void setHttpErrorMessage(String httpErrorMessage) {
            this.httpErrorMessage = httpErrorMessage;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }