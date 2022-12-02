package SpringMVCTest2.controllers;

import SpringMVCTest2.models.book;
import SpringMVCTest2.models.data.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class addController {

    @Autowired
    bookRepository bookrepository;

    @GetMapping("/add")
    public String addPage(){
        return "add";
    }

    @PostMapping("/add")
    public String processAddBook(@ModelAttribute @Valid book newBook, Model model){
        List<book> foundBooks = (List<book>) bookrepository.findAll();
        model.addAttribute("books", foundBooks);
        bookrepository.save(newBook);
        return "home";
    }


}
