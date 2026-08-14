package main.Controller;

import lombok.RequiredArgsConstructor;
import main.DTO.BookRequestDto;
import main.DTO.BookResponseDto;
import main.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private  final BookService service;

    //create

    @PostMapping("/create")
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto dto){
        BookResponseDto response=service.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    //getbyid
    @GetMapping("/getById/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id){

        BookResponseDto response=service.getbyid(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    //getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<BookResponseDto>> getAllBooks(){

        List<BookResponseDto>response=service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){

          service.delete(id);


       return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Book deleted successfully") ;
    }


    //update

    @PutMapping("/update/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable Long id, @RequestBody BookRequestDto dto){

        BookResponseDto response=service.update(id,dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }


}
