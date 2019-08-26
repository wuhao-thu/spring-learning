package my.test.spring.hibernate.dao;

import my.test.spring.hibernate.entities.Book;

public interface BookDao {

    void insertBook(Book book);

    void updateBook(Book book);

    void deleteBook(String isbn);

    Book getBookByISBN(String isbn);
}
