package mybatis.practice.repository.memberRepository;

import lombok.RequiredArgsConstructor;
import mybatis.practice.dto.Item;
import mybatis.practice.dto.Member;
import mybatis.practice.repository.mapper.ItemMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository{

    private final ItemMapper itemMapper;

    @Override
    public List<Item> findItems() {
        return itemMapper.getItem();
    }

    @Override
    public void insertItem(Item item) {
        itemMapper.insertItem(item);
    }

    @Override
    public void updateItem(Item item) {
        itemMapper.updateItem(item);
    }

    @Override
    public void deleteItem(String title) {
        itemMapper.deleteMember(title);
    }
}
