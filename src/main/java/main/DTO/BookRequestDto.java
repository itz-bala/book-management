package main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.Enum.Category;
import main.Validation.BookAnnotation;

@Data
@NoArgsConstructor
@AllArgsConstructor
@BookAnnotation
public class BookRequestDto {

    private String title;
    private String auther;
    private Double price;
    private Category category;
}
