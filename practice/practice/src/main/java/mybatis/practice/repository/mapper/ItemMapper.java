package mybatis.practice.repository.mapper;

import mybatis.practice.dto.Item;
import mybatis.practice.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {

    List<Item> getItem();

    void insertItem(Item item);

    void updateItem(Item item);

    void deleteMember(String title);
}
