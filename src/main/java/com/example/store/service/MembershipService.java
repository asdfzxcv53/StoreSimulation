package com.example.store.service;

import com.example.store.dto.MembershipDto;
import com.example.store.mapper.MembershipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MembershipService {
    private final MembershipMapper membershipMapper;

    @Autowired
    public MembershipService(MembershipMapper membershipMapper) {
        this.membershipMapper = membershipMapper;
    }

    public List<MembershipDto> SelectAllMembership() {
        return membershipMapper.SelectAllMembership();
    }

    public void InsertMembership(MembershipDto membershipDto) {
        membershipMapper.InsertMembership(membershipDto);
    }

    public void UpdateMembership(MembershipDto membershipDto) {
        membershipMapper.UpdateMembership(membershipDto);
    }
}
