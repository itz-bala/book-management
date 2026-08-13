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

       public Book toBook(BookRequestDto dto){
           return mapper.map(dto,Book.class);
       }

    public BookResponseDto toBookResponseDto(Book book){

           return  mapper.map(book,BookResponseDto.class);
    }


}
