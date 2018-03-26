/*package com.seracorp.demo.feign.t1;

import java.awt.print.Book;
import java.util.List;

import com.seracorp.demo.model.LoginJson;

import feign.Headers;
import feign.RequestLine;

@Headers("Accept: application/json")
public interface TVDBResourceFeign {

	@RequestLine("POST /login")
	@Headers("Content-Type: application/json")
	List<Book> login(LoginJson loginJson);

	@Headers("Content-Type: application/json")
	@RequestLine("POST /v1/books")
	Book createBook(Book book);

	@Headers("Content-Type: application/json")
	@RequestLine("PUT /v1/books/{id}")
	Book updateBook(@Param("id") Long id, Book book);

	@RequestLine("DELETE /v1/books/{id}")
	void deleteBook(@Param("id") Long id);

}*/