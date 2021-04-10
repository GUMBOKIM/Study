package mybatis.practice.repository.memberRepository;

import mybatis.practice.dto.Member;

import java.util.List;

public interface MemberRepository {

    List<Member> findMembers();

    void insertMember(Member member);

    void updateMember(Member member);

    void deleteMember(String accountId);

}
