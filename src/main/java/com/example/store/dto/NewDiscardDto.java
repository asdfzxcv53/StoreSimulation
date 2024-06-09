package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class NewDiscardDto {
    private String discardDate;
    private String discardTypeCode;
    private String empCode;
    private List<NewDiscardProductDto> newDiscardProductDto;


}
