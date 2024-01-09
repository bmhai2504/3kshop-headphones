package com.codegym.case43kshop.dto.common;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommonResponseListDTO<E>{
    private long totalElements;
    private boolean success;
    private String message;
    private List<E> data;
}
