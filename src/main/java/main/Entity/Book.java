package main.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.Enum.Category;

@Data
@Entity
@Table(name="book_table")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String auther;



    @Column(nullable=false)
    private Double price;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Category category;




}
