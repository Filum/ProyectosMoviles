/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.mavenproject1;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class Main {
    
    
    
    public static void main(String[] args) {
        
        //variables temporales para guardar los datos por teclado
        String nom;
        int ed;
        char sex;
        float pes;
        float alt;
        
        //scaner para obtener datos del teclado
        Scanner entradaEscaner = new Scanner (System.in);
        
        //Solicitud de datos al usuario
        System.out.println("Ingrese un nombre");
        nom = entradaEscaner.nextLine ();
        System.out.println("Ingrese la edad en años");
        ed = entradaEscaner.nextInt();
        System.out.println("Ingrese un sexo: (H) para Hombre y (M) para Mujer");
        sex = entradaEscaner.next().charAt(0);
        System.out.println("Ingrese un peso");
        pes = entradaEscaner.nextFloat();
        System.out.println("Ingrese un altura");
        alt = entradaEscaner.nextFloat();
        
        //Construccion de las personas con los diferentes constructores
        Persona p1=new Persona(nom, ed, 0, sex, pes, alt);
        Persona p2=new Persona("Daniela Cubero Mora", 15, 'M');
        Persona p3=new Persona();
        
        //seteo de valores para la segunda persona (datos quemados)
        p2.setAltura(1.65f);
        p2.setPeso(85.3f);
        
        //seteo de valores para la tercera persona (datos quemaados)
        p3.setNombre("Edgardo Acuña Molina");
        p3.setEdad(23);
        p3.setSexo('H');
        p3.setPeso(73.5f);
        p3.setAltura(1.78f);
        
        
        //Mostrar resultados del calculo del IMC para cada persona
        System.out.println("\n \n Resultados de calculo de los IMC");
        System.out.println("Resultados de IMC de "+p1.getNombre()+":");
        System.out.println(p1.calcularIMC());
        System.out.println("Resultados de IMC de "+p2.getNombre()+":");
        System.out.println(p2.calcularIMC());
        System.out.println("Resultados de IMC de "+p3.getNombre()+":");
        System.out.println(p3.calcularIMC());
        System.out.println("Nota: Si el usiario obtiene \n (-1) está bajo su peso ideal \n (0) está en su peso ideal \n (1) está sobre su peso ideal");
        
        //generar dnis de usuarios
        p1.generaDni();
        p2.generaDni();
        p3.generaDni();
        
        //comprobar que los datos del sexo sean correctos
        p1.comprobarSexo(p1.getSexo());
        p2.comprobarSexo(p2.getSexo());
        p3.comprobarSexo(p3.getSexo());
        
        
        //comprobar si son mayores de edad
        System.out.println("\n \n ¿" + p1.getNombre()+" es mayor de edad?");
        System.out.println(p1.esMayorDeEdad());
        System.out.println("¿" + p2.getNombre()+" es mayor de edad?");
        System.out.println(p2.esMayorDeEdad());
        System.out.println("¿" + p3.getNombre()+" es mayor de edad?");
        System.out.println(p3.esMayorDeEdad());
        
        //muestra de los datos ingresados
        System.out.println("\n \n Datos de los usuarios ingresados:");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}
