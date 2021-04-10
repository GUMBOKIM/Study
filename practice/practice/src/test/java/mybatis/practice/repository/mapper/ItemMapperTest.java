package mybatis.practice.repository.mapper;

import mybatis.practice.dto.Item;
import mybatis.practice.dto.Member;
import org.junit.jupiter.api.DisplayName;
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
class ItemMapperTest {

    @Autowired
    ItemMapper itemMapper;

    @Test
    @DisplayName("삽입 테스트")
    void InsertTest() {

        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setUserId((long)(4+i));
            item.setTitle("Title" + i);
            item.setContent("Content" + i);
            item.setPrice(i*1000);

            itemMapper.insertItem(item);
        }

    }

    @Test
    @DisplayName("삭제 테스트")
    void DeleteTest() {
        itemMapper.deleteMember("Title4");
    }

    @Test
    @DisplayName("업데이트 테스트")
    void UpdateTest() {
        Item item = new Item();
        item.setTitle("Title2");
        item.setPrice(200000);
        item.setContent("씨발놈");

        itemMapper.updateItem(item);
    }

    @Test
    @DisplayName("조회 테스트")
    void selectTest() {
        List<Item> items = itemMapper.getItem();

        for (Item item : items) {
            System.out.println("item = " + item);
        }
    }

}