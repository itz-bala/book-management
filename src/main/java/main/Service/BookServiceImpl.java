package main.Service;

import lombok.RequiredArgsConstructor;
import main.DTO.BookRequestDto;
import main.DTO.BookResponseDto;
import main.Entity.Book;
import main.Exception.ResourceNotFoundException;
import main.Mapping.ModelMappingUseCase;
import main.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository repo;
    private final ModelMappingUseCase mapper;

   //create
    @Override
    public BookResponseDto create(BookRequestDto dto) {

        Book book=mapper.toBook(dto);

        Book saved=repo.save(book);
        return mapper.toBookResponseDto(saved);
    }


      //getbyid

    @Override
    public BookResponseDto getbyid(Long id) {

        Book book=repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Book not found"));


        return mapper.toBookResponseDto(book);
    }


    //getAll
    @Override
    public List<BookResponseDto> getAll() {

       List<Book>list=repo.findAll();

        return list.stream().map(mapper::toBookResponseDto).toList();
    }



     //delete
    @Override
    public void delete(Long id) {

        Book book=repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Book not found"));

        repo.delete(book);
    }

    @Override
    public BookResponseDto update(Long id, BookRequestDto dto) {


        Book book=repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Book not found"));



             mapper.updateEntity(dto,book);


             Book updated=repo.save(book);

             return  mapper.toBookResponseDto(updated);
    }


}
