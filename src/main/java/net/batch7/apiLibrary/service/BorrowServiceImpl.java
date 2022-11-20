package net.batch7.apiLibrary.service;

import net.batch7.apiLibrary.model.dto.BookDto;
import net.batch7.apiLibrary.model.dto.ResponseData;
import net.batch7.apiLibrary.model.entity.*;
import net.batch7.apiLibrary.repository.BookRepository;
import net.batch7.apiLibrary.repository.BorrowRepository;
import net.batch7.apiLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    private User user;
    private Optional<Book> book;
    private Borrow borrow;
    private ResponseData<Object> responseData;
    private List<Borrow> borrows;


//    @Override
//    public ResponseData<Object> addBorrow(BookDto request) {
//        borrow = new Borrow();
//        Optional<Borrow> borrowOpt = borrowRepository.findById(borrow.getId());
//        if (borrowOpt.isPresent()) {
//            borrow.getBook();
//            borrowRepository.save(borrow);
//            responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "Borrow book success", borrow.getBook());
//        } else {
//            responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "Data borrow not found", null);
//        }
//        return responseData;
//
////        if (book.isPresent()) {
////            return responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "Data borrow not found", null);
////        } else {
////            borrowRepository.save(borrow);
////            return responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "Borrow book success", borrow.getBook());
////        }
//    }

    @Override
    public ResponseData<Object> addBorrow(Long id, BookDto request) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            user = userOpt.get();
            borrow = new Borrow();
            book = Optional.ofNullable(bookRepository.findByTitle(request.getTitle()));
            borrow.setBook(book.get());
            borrow.setUser(user);
            borrowRepository.save(borrow);
            responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "add successfully", borrow);
            return responseData;

        } else {
            responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "Data Not Found", null);
        }
        return responseData;
    }

    @Override
    public ResponseData<Object> getBorrowsData(Boolean status) {
            borrow = (Borrow) borrowRepository.findAll();
        responseData = new ResponseData<Object>(HttpStatus.OK.value(), "Success", borrows);
        return responseData;
    }

    @Override
    public ResponseData<Object> getBorrowDataById(long id) {
        Optional<Borrow> borrowOpt = borrowRepository.findById(id);
        if (borrowOpt.isPresent()) {
            borrow = borrowOpt.get();
            responseData = new ResponseData<Object>(HttpStatus.OK.value(), "success", borrow);
        } else {
            responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "empty data", null);
        }
        return responseData;
    }

    @Override
    public ResponseData<Object> getBorrower(Boolean status) {
        return null;
    }

}
