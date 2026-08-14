package main.Mapping;

import lombok.RequiredArgsConstructor;
import main.DTO.BookRequestDto;
import main.DTO.BookResponseDto;
import main.Entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModelMappingUseCase {

    private final ModelMapper mapper;

        // dto to entity

       public Book toBook(BookRequestDto dto){
           return mapper.map(dto,Book.class);
       }



          //entity to dto

    public BookResponseDto toBookResponseDto(Book book){

           return  mapper.map(book,BookResponseDto.class);
    }


    //update entity and return dto

    public void updateEntity(BookRequestDto dto, Book book){

           mapper.map(dto,book);
    }

}
