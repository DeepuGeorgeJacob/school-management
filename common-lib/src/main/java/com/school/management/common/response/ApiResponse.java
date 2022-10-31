package com.school.management.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class ApiResponse<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}
