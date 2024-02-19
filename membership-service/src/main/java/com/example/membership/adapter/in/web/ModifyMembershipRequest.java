package com.example.membership.adapter.in.web;

import lombok.Data;

@Data
public class ModifyMembershipRequest {
    private Long membershipId;
    private String name;
    private String address;
    private String email;
    private boolean isValid;
    private boolean isCorp;
}
