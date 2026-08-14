package main.Service;

import main.DTO.BookRequestDto;
import main.DTO.BookResponseDto;

import java.util.List;

public interface BookService {
    BookResponseDto create(BookRequestDto dto);

    BookResponseDto getbyid(Long id);

    List<BookResponseDto> getAll();

    void delete(Long id);

    BookResponseDto update(Long id, BookRequestDto dto);
}
