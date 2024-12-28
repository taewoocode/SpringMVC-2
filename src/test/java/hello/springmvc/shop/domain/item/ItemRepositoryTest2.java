package hello.springmvc.shop.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemRepositoryTest2 {

    @Autowired
    ItemRepository itemRepository;

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    @DisplayName("사용자 저장 테스트")
    public void save() throws Exception {
        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    @DisplayName("모든 아이템 저장 확인")
    public void findAll() throws Exception {
        //given
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);

        //when
        itemRepository.save(item1);
        itemRepository.save(item2);
        List<Item> result = itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1, item2);
    }

    @Test
    @DisplayName("업데이트 기능 확인")
    public void updateItem() throws Exception {
        //given
        Item item1 = new Item("item1", 10000, 10);
        Item savedItem = itemRepository.save(item1);
        Long itemId = savedItem.getId();

        //when
        Item updateParam = new Item("item2", 20000, 30);
        itemRepository.update(itemId, updateParam);

        //then
        Item findItem = itemRepository.findById(itemId);
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
    }
    
}