package com.example.store.controller;

import com.example.store.dto.MembershipDto;
import com.example.store.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/membership")
public class MembershipController {
    private final MembershipService membershipService;

    @Autowired
    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping
    public List<MembershipDto> SelectAllMembership() {
        return membershipService.SelectAllMembership();
    }

    @PostMapping("/regist")
    public ResponseEntity<?> InsertMembership(@RequestBody MembershipDto membershipDto) {
        membershipService.InsertMembership(membershipDto);
        return ResponseEntity.ok().build();
    }
}
