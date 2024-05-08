package firstmarket.koreashop.dto;

import lombok.Getter;

@Getter
public class ChangePasswordRequest {
    private String phoneNumber;
    private String newPw;

    public ChangePasswordRequest(String phoneNumber, String newPw) {
        this.phoneNumber = phoneNumber;
        this.newPw = newPw;
    }
}

