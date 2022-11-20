package net.batch7.apiLibrary.service;

import net.batch7.apiLibrary.model.dto.BookDto;
import net.batch7.apiLibrary.model.dto.ResponseData;

public interface BookService {
  // Proses CRUD
  ResponseData<Object> createBook(BookDto requesDto);

  ResponseData<Object> getAll();

  ResponseData<Object> getById(long id);

  ResponseData<Object> updateBook(long id, BookDto request);

  ResponseData<Object> deleteBook(long id);
}
