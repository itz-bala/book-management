package main.Service;

import main.DTO.BookRequestDto;
import main.DTO.BookResponseDto;

public interface BookService {
    BookResponseDto create(BookRequestDto dto);

    BookResponseDto getbyid(Long id);
}
