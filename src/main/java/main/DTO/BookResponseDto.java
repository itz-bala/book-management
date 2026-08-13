package main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.Enum.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {
     private Long id;
    private String title;
    private String auther;
    private Double price;
    private Category category;
}
