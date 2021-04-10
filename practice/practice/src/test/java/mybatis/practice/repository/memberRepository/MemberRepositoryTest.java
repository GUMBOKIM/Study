package mybatis.practice.repository.memberRepository;

import mybatis.practice.dto.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void insertTest() {

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Member member = new Member();
            member.setAccountId("aaaa"+i);
            member.setAccountPw("aaaa"+i);
            member.setPhoneNumber("123"+i);
            member.setEmail("aaaa"+i);
            member.setShopName("aaaa"+i);

            members.add(member);
        }

        for (Member member : members) {
            memberRepository.insertMember(member);
        }
    }

}