package SpringMVCTest2.controllers;


import SpringMVCTest2.models.book;
import SpringMVCTest2.models.data.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HomeController {

    @Autowired
    bookRepository bookrepository;

    private static AtomicInteger count = new AtomicInteger();




    @GetMapping("/{id}")
    public book getBook(@PathVariable int id){
        Optional<book> bookFound = bookrepository.findById(id);

        if (bookFound.isEmpty()){
            return new book(999, "empty name", "empty author");
        }
        book bookGet = bookFound.get();
        return bookGet;
    }

    @GetMapping("/books")
    public List<book> allBooks(){
        List<book> foundBooks = (List<book>) bookrepository.findAll();
        return foundBooks;
    }

    @GetMapping("/addbook")
    public book addBook(@RequestParam(value = "name", defaultValue = "Default name") String name,@RequestParam(value = "author", defaultValue = "Default author") String author ){
        book paramBook = new book(count.incrementAndGet(), name, author);
        bookrepository.save(paramBook);
        return paramBook;
    }
}
