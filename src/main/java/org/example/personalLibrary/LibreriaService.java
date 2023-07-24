package org.example.personalLibrary;

import java.util.Scanner;

public class LibreriaService {

    static Scanner sc = new Scanner(System.in);

    public static void createBook () {
        System.out.println("Ingrese el nombre del libro");
        String bookName = sc.nextLine();

        System.out.println("Ingrese el nombre del autor");
        String author = sc.nextLine();

        System.out.println("Ingrese el ISBN del libro");
        String isbn = sc.nextLine();

        System.out.println("Ingrese el número de páginas del libro");
        int pages = sc.nextInt();

        System.out.println("Ingrese la categoría del libro");
        String category = sc.next();

        LibreariaModel registerBook = new LibreariaModel();

        registerBook.setBookName(bookName);
        registerBook.setAuthor(author);
        registerBook.setIsbn(isbn);
        registerBook.setPages(pages);
        registerBook.setCategory(category);

        LibreriaDAO.createBookDB(registerBook);


    }

    public static void listBook () {
        LibreriaDAO.readBookDB();
    }

    public static void deleteBook () {
        System.out.println("Ingrese el id del libro a eliminar");
        int id_book = sc.nextInt();
        LibreriaDAO.deleteBookDB(id_book);
    }

}
