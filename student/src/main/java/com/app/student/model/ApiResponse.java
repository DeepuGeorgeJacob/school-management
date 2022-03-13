package com.app.student.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class ApiResponse<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}
