package com.codegym.case43kshop.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartItemResponseDTO {
    private long id;
    private long productID;
    private String productName;
    private int price;
    private int quantity;
    private int subPrice;
    private boolean status;
}
