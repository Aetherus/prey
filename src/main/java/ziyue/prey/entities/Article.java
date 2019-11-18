package ziyue.prey.entities;

import lombok.Data;

@Data
public class Article {
    private Long id;
    private Long userId;
    private String title;
    private String content;
}
