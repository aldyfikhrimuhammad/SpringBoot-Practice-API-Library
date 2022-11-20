package net.batch7.apiLibrary.controller;

import net.batch7.apiLibrary.model.dto.BookDto;
import net.batch7.apiLibrary.model.dto.ResponseData;
import net.batch7.apiLibrary.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    private ResponseData<Object> responseData;

    @GetMapping
    public ResponseEntity<Object> getBorrowsData(@RequestParam(value = "status", defaultValue = "") Boolean status) {
        responseData = borrowService.getBorrowsData(status);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> returnBook(@PathVariable Long id, @RequestBody BookDto request) {
        responseData = borrowService.addBorrow(id , request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

}
