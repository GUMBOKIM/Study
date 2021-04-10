package mybatis.practice.repository.memberRepository;

import mybatis.practice.dto.Item;
import mybatis.practice.dto.Member;

import java.util.List;

public interface ItemRepository {

    List<Item> findItems();

    void insertItem(Item item);

    void updateItem(Item item);

    void deleteItem(String title);

}
