package com.test.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.exception.EntityNotFound;
import com.test.spring.model.Book;
import com.test.spring.service.BookService;

@CrossOrigin(origins = "*")
@RestController

public class BookController {

   @Autowired
   private BookService bookService;

   /*---Add new book---*/
   @PostMapping("/api/book")
   public ResponseEntity<?> save(@RequestBody Book book) {
      long id = bookService.save(book);
      return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
   }

   /*---Get a book by id---*/
   @GetMapping("/api/book/{id}")
     public ResponseEntity<Book> get(@PathVariable("id") long id) {
      Book book = bookService.get(id);
      return ResponseEntity.ok().body(book);
   }

   /*---get all books---*/
   @GetMapping("/api/book")
   public ResponseEntity<List<Book>> list() {
	   System.out.println("in controller");
      List<Book> books = bookService.list();
      return ResponseEntity.ok().body(books);
   }

   /*---Update a book by id---*/
   @PutMapping("/api/book/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book) {
      bookService.update(id, book);
      return ResponseEntity.ok().body("Book has been updated successfully.");
   }
   
   @PutMapping("/api/book/updates")
   public ResponseEntity<?> update( @RequestBody List<Book> booklist) {
      System.out.println(booklist);
	   for(Book b:booklist)
      {
    	  
    	  bookService.update(b.getId(), b);
            
      }
	   
	   return ResponseEntity.ok().body("Book has been updated successfully.");
   }
   

   /*---Delete a book by id---*/
   @DeleteMapping("/api/book/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      bookService.delete(id);
      return ResponseEntity.ok().body("Book has been deleted successfully.");
   }
}