package com.example.store.service;

import com.example.store.dto.MembershipDto;
import com.example.store.mapper.MembershipMapper;
import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MembershipService {
    private final MembershipMapper membershipMapper;
    private final CodeSequence codeSequence;

    @Autowired
    public MembershipService(MembershipMapper membershipMapper, CodeSequence codeSequence) {
        this.membershipMapper = membershipMapper;
        this.codeSequence = codeSequence;
    }

    public List<MembershipDto> SelectAllMembership() {
        return membershipMapper.SelectAllMembership();
    }

    public void InsertMembership(MembershipDto membershipDto) {
        membershipDto.setMembershipCode(codeSequence.generateMembershipCode());
        membershipMapper.InsertMembership(membershipDto);
    }

    public void UpdateMembership(MembershipDto membershipDto) {
        membershipMapper.UpdateMembership(membershipDto);
    }
}
