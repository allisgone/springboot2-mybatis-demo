package com.winterchen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnMsg<T> {
    private int code;

    private T body;

    private String errorMsg;

}
