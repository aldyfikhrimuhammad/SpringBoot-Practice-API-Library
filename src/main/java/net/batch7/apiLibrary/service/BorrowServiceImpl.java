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

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;
    private Borrow borrow;
    private ResponseData<Object> responseData;
    private List<Borrow> borrows;


    @Override
    public ResponseData<Object> addBorrow(BookDto request) {
        borrow = new Borrow();
//        if (UserRepository && BookRepository != null) {
//            borrowRepository.save(borrow);
//            responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "Borrow book success", borrow.getBook());
//        } else {
//            responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "Error to borrow", null);
//        }
//        borrow.setBook(request.getTitle());

        return responseData;
    }

    @Override
    public ResponseData<Object> getBorrowsData() {
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
    public ResponseData<Object> updateBorrowData(long id, BookDto request) {
//        Optional<Borrow> borrowOpt = borrowRepository.findById(id);
//
//        // cek user ada atau tidak
//        if (borrowOpt.isPresent()) {
//            borrow = borrowOpt.get();
//            // cari data detailnya
//            Optional<DetailUser> detailOpt = detailUserRepository.findByUser(user);
//            // cek ada atau tidak detailnya
//            if (detailOpt.isPresent()) {
//                detailUser = detailOpt.get();
//                // update
//                detailUser.setFirstName(request.getFirstName());
//                detailUser.setLastName(request.getLastName());
//                detailUser.setPhoneNumber(request.getPhoneNumber());
//                // save
//                detailUserRepository.save(detailUser);
//            } else {
//                detailUser = new DetailUser(request.getFirstName(), request.getLastName(), request.getPhoneNumber());
//                detailUser.setUser(user);
//                // save
//                detailUserRepository.save(detailUser);
//            }
//
//            // data
//            data = new HashMap<>();
//            data.put("firstName", detailUser.getFirstName());
//            data.put("lastName", detailUser.getLastName());
//            data.put("phoneNumber", detailUser.getPhoneNumber());
//
//            // response data
//            responseData = new ResponseData<Object>(HttpStatus.OK.value(), "Success updated", data);
//
//        } else {
//            responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "User is not found", null);
//        }
//        return responseData;
        return null;
    }
}
