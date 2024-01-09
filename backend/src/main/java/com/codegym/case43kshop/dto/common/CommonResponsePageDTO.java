package com.codegym.case43kshop.dto.common;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommonResponsePageDTO<E> {
    private int pageNumber;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean success;
    private String message;
    private List<E> data;
}
