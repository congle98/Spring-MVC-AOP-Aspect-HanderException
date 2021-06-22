package com.app.controller;


import com.app.exception.HetSachException;
import com.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bookstore")
public class BookStore {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("books",bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/borrow/{id}")
    public ModelAndView borrow(@PathVariable Long id) throws HetSachException {
        bookService.borrow(id);
        return new ModelAndView("borrowsc");
    }

    @ExceptionHandler(HetSachException.class)
    public ModelAndView borrowError(){
        return new ModelAndView("borrowerror");
    }
}
