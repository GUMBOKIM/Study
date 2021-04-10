package mybatis.practice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Item {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private int price;

    

}
