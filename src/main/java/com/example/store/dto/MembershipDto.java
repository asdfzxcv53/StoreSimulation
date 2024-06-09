package com.example.store.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MembershipDto {
    private String membershipCode;
    private String membershipName;
    private String membershipAge;
    private String membershipGender;
    private String membershipMailNo;
    private String membershipPhoneNo;
    private String membershipMileage;
}
