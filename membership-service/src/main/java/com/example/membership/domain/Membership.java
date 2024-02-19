package com.example.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    private final String membershipId;
    private final String name;
    private final String email;
    private final String address;
    private final boolean isValid;
    private final boolean isCorp;

    public static Membership generateMember(
            MembershipId membershipId,
            MembershipName membershipName,
            MembershipEmail membershipEmail,
            MembershipAddress membershipAddress,
            MembershipIsValid membershipIsValid,
            MembershipIsCorp membershipIsCorp) {

        return new Membership(
                membershipId.membershipId,
                membershipName.nameValue,
                membershipEmail.emailValue,
                membershipAddress.addressValue,
                membershipIsValid.isValidValue,
                membershipIsCorp.isCorpValue
        );
    }

    @Value
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MembershipId {
        String membershipId;

        public static MembershipId from(String value) {
            return new MembershipId(value);
        }
    }

    @Value
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MembershipName {
        String nameValue;

        public static MembershipName from(String value) {
            return new MembershipName(value);
        }
    }

    @Value
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MembershipEmail {
        String emailValue;

        public static MembershipEmail from(String emailValue) {
            return new MembershipEmail(emailValue);
        }
    }

    @Value
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MembershipAddress {
        String addressValue;

        public static MembershipAddress from(String value) {
            return new MembershipAddress(value);
        }
    }

    @Value
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MembershipIsValid {
        boolean isValidValue;

        public static MembershipIsValid from(boolean value) {
            return new MembershipIsValid(value);
        }
    }

    @Value
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MembershipIsCorp {
        boolean isCorpValue;

        public static MembershipIsCorp from(boolean value) {
            return new MembershipIsCorp(value);
        }
    }
}
