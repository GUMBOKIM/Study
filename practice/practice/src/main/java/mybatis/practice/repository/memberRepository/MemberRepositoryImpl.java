package mybatis.practice.repository.memberRepository;

import lombok.RequiredArgsConstructor;
import mybatis.practice.dto.Member;
import mybatis.practice.repository.mapper.MemberMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{

    private final MemberMapper memberMapper;

    @Override
    public List<Member> findMembers() {
        return memberMapper.getMember();
    }

    @Override
    public void insertMember(Member member) {
        memberMapper.insertMember(member);
    }

    @Override
    public void updateMember(Member member) {
        memberMapper.updateMember(member);
    }

    @Override
    public void deleteMember(String accountId) {
        memberMapper.deleteMember(accountId);
    }
}
