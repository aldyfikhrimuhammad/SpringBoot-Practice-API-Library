package net.batch7.apiLibrary.controller;

import net.batch7.apiLibrary.model.dto.ResponseData;
import net.batch7.apiLibrary.service.BookService;
import net.batch7.apiLibrary.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    private ResponseData<Object> responseData;

    @GetMapping
    public ResponseEntity<Object> getBorrowsData() {
        responseData = borrowService.getBorrowsData();
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

}
