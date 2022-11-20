package net.batch7.apiLibrary.service;

import net.batch7.apiLibrary.model.dto.BookDto;
import net.batch7.apiLibrary.model.dto.ResponseData;

public interface BorrowService {

    ResponseData<Object> addBorrow(Long id, BookDto request);

    ResponseData<Object> getBorrowsData(Boolean status);

    ResponseData<Object> getBorrowDataById(long id);

//    ResponseData<Object> returnBook(long id, BorrowDto request);


    ResponseData<Object> getBorrower(Boolean status);

}
