package org.example.personalLibrary;

import java.util.Scanner;

public class Menu {

   public void menuApp () {

       Scanner sc = new Scanner(System.in);
       int opcion;
       do {
           System.out.println("Bienvenido al sistema personal de biblioteca");
           System.out.println("<<<<<<<<<<<<<Menú>>>>>>>>>>>>>>");
           System.out.println("1. Ingresar un nuevo libro \n" +
                   "2. Actualizar libro \n" +
                   "3. Listar libros \n" +
                   "4. Eliminar libro \n" +
                   "5. Salir de la aplicación");
           System.out.println("-------------------------------------------");
           System.out.println("Seleccione una opción");

           opcion = sc.nextInt();

           switch (opcion) {
               case 1:
                   System.out.println("Ingresar un nuevo libro");
                   LibreriaService.createBook();
                   break;
                case 2:
                    System.out.println("Actualizar libro");
                    LibreriaService.updateBook();
                    break;

               case 3:
                   System.out.println("Listar libros");
                   LibreriaService.listBook();
                   break;
               case 4:
                   System.out.println("Eliminar libro");
                   LibreriaService.deleteBook();
                   break;

               case 5:
                   System.out.println("Salir de la aplicación");
                   break;
               default:
                     System.out.println("Opción no válida");
                     break;
           }

       } while (opcion != 5);
   }

}
