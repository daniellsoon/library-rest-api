package com.library.repository;

import com.library.domain.Book;
import com.library.domain.StatusAllowed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface BookDao extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();

    List<Book>findAllByTitleIdAndStatus(Long titleId, StatusAllowed statusAllowed);
}
