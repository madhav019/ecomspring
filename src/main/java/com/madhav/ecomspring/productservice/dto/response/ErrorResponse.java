package com.madhav.ecomspring.productservice.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse extends BaseApiResponse {
    private String error;

    public ErrorResponse(int status, String error, String message, String path) {
        super(status, message, path);
        this.error = error;
    }
}
