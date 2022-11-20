package net.batch7.apiLibrary.service;

import net.batch7.apiLibrary.model.dto.BookDto;
import net.batch7.apiLibrary.model.dto.ResponseData;

public interface CategoryService {
  ResponseData<Object> addCategory(BookDto request);

  ResponseData<Object> getCategory(Boolean status);

  ResponseData<Object> getCategoryById(long id);

  ResponseData<Object> updateCategory(long id, BookDto request);

  ResponseData<Object> deleteCategory(long id);
}
