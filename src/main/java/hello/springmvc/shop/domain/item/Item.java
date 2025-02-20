package hello.springmvc.shop.domain.item;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // 가격이 안들어가 있을 수 있음
    private Integer quantity;


    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
