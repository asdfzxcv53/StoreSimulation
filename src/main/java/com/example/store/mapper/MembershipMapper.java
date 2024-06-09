package com.example.store.mapper;

import com.example.store.dto.MembershipDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MembershipMapper {
    public List<MembershipDto> SelectAllMembership();
    public void InsertMembership(MembershipDto membershipDto);
    public void UpdateMembership(MembershipDto membershipDto);
}
