package mybatis.practice.repository.mapper;

import mybatis.practice.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    List<Member> getMember();

    void insertMember(Member member);

    void updateMember(Member member);

    void deleteMember(@Param("id") String accountId);
}
