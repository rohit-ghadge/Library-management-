package com.mnb.repository;

import com.mnb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
//    @Query("Select b from Book b where b.book_name LIKE %?1%"
//            + "OR b.isbn LIKE %?1%"
//            + "OR b.serial_name LIKE %?1%"
//            +"OR b.books_author LIKE %?1%")
//    List<Book> findByName(String keyword);
    
    @Query("from Book where book_name=:name "
    		+ "OR isbn=:name "
    		+ "OR book_serial_name=:name "
    		+ "OR books_author=:name ")    
    
    List<Book> findByName(@Param("name")String name);
}
