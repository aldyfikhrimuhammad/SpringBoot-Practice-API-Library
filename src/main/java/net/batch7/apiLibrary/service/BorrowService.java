package net.batch7.apiLibrary.service;

import net.batch7.apiLibrary.model.dto.BookDto;
import net.batch7.apiLibrary.model.dto.ResponseData;

public interface BorrowService {

    ResponseData<Object> addBorrow(BookDto request);

    ResponseData<Object> getBorrowsData();

    ResponseData<Object> getBorrowDataById(long id);

    ResponseData<Object> updateBorrowData(long id, BookDto request);

}
