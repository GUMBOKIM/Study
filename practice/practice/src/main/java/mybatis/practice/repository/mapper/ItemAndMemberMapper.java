package mybatis.practice.repository.mapper;

import mybatis.practice.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemAndMemberMapper {

    List<Member> getMember();

    void insertMember(Member member);

    void updateMember(Member member);

    void deleteMember(@Param("id") String accountId);
}
