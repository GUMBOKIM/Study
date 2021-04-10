package mybatis.practice.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@ToString(of = {"user_Id",
        "accountId",
        "accountPw",
        "email",
        "phoneNumber",
        "shopName" })
public class Member {

    private Long user_Id;
    private String accountId;
    private String accountPw;
    private String email;
    private String phoneNumber;
    private String shopName;
}
