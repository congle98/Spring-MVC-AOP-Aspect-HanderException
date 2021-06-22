package com.app.service;


import com.app.exception.HetSachException;
import com.app.model.Book;
import com.app.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public Iterable<Book> findAll(){
        return bookRepository.findAll();
    }

    public void borrow(Long id) throws HetSachException {
        Optional<Book> book = bookRepository.findById(id);
        book.get().setAmount(book.get().getAmount()-1);
        if(book.get().getAmount()==0){
            book.get().setBorrowStatus(true);
        }
        try {
            bookRepository.save(book.get());
        }
        catch (Exception e){
            throw new HetSachException("hết sách mà mượn rồi cu");
        }
    }
}
