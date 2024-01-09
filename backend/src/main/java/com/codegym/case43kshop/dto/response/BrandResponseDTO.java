package com.codegym.case43kshop.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandResponseDTO {
    private long id;
    private String name;
    private String image;
}
