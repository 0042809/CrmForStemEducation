package com.youdev.crmforstemeducation.dto.responce;

import lombok.Data;

@Data

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
}
