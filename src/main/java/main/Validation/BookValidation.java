package main.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import main.DTO.BookRequestDto;

public class BookValidation implements ConstraintValidator<BookAnnotation, BookRequestDto> {
    @Override
    public boolean isValid(BookRequestDto dto, ConstraintValidatorContext context) {

        if(dto==null){

            return true;

        }

       if(dto.getTitle()==null||dto.getTitle().trim().isEmpty()){

           context.disableDefaultConstraintViolation();
           context.buildConstraintViolationWithTemplate("Title is empty")
                   .addPropertyNode("title").addConstraintViolation();

           return false;
       }

       if(dto.getAuther()==null||dto.getAuther().trim().isEmpty()){

           context.disableDefaultConstraintViolation();
           context.buildConstraintViolationWithTemplate("Auther is empty")
                   .addPropertyNode("auther").addConstraintViolation();
           return false;
       }

       if(dto.getCategory()==null){
           context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Category is empty")
                    .addPropertyNode("category").addConstraintViolation();
            return false;
       }

if(dto.getPrice()==null){

    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate("Price is empty")
            .addPropertyNode("price").addConstraintViolation();
    return false;




}


if(dto.getPrice()<=0){

    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate("Price less than 0")
            .addPropertyNode("price").addConstraintViolation();
    return false;


}


        return true;
    }
}
