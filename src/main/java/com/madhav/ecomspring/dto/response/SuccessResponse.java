package com.madhav.ecomspring.dto.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SuccessResponse extends BaseApiResponse {
    private Object data;

    public SuccessResponse(int status, String message, String path, Object data) {
        super(status, message, path);
        this.data = data;
    }
}
