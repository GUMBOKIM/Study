package mybatis.practice.repository.mapper;

import mybatis.practice.dto.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberMapperTest {

    @Autowired
    MemberMapper memberMapper;

    @Test
    @DisplayName("삽입 테스트")
    void InsertTest() {

        Member member = new Member();
        member.setAccountId("asdf");
        member.setAccountPw("1234");
        member.setPhoneNumber("1234");
        member.setEmail("asdf");
        member.setShopName("asdf");

        memberMapper.insertMember(member);
    }

    @Test
    @DisplayName("조회 테스트")
    void selectTest() {
        List<Member> members = memberMapper.getMember();

        for (Member member : members) {
            System.out.println("member = " + member);
        }
    }

//    @Test
//    @DisplayName("업데이트 테스트")
//    void updateTest() {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("shopName", "배고파");
//        map.put("accountId", "asdf");
//
//        memberMapper.updateMember(map);
//
//        List<Member> members = memberMapper.getMember();
//
//        for (Member member : members) {
//            System.out.println("member = " + member);
//        }
//    }

    @Test
    @DisplayName("업데이트 테스트")
    void deleteTest() {

        memberMapper.deleteMember("asdf");

        List<Member> members = memberMapper.getMember();

        for (Member member : members) {
            System.out.println("member = " + member);
        }
    }
}