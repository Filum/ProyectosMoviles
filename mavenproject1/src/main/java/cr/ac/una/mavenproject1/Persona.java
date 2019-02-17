/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.mavenproject1;

/**
 *
 * @author Usuario
 */
public class Persona {
    
    
    //constantes 
    static final char HOMBRE = 'H';
    static final char MUJER = 'M';
    static final int BAJOPESO = -1;
    static final int PESOIDEAL = 0;
    static final int SOBREPESO = 1;
    
    
    //atributos de Persona
    private String nombre;
    private int edad;
    private int dni;
    private char sexo;
    private float peso;
    private float altura;
    
    
    
    //constructor sin parametros
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = 0;
        this.sexo = Persona.HOMBRE;
        this.peso = 0;
        this.altura = 0;
    }
    
    //constructor con parametros
    public Persona(String nombre, int edad, int dni, char sexo, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.dni = 0;
        this.peso = 0;
        this.altura = 0;
    }

    
    //Metodos propios 
    public int calcularIMC()
    {
        float imc;
        imc = peso/(altura * altura);
        
        if(imc>24.99)
        {
            return SOBREPESO;
        }else
            if(imc<18.50)
            {
            return BAJOPESO;
            }else
                return PESOIDEAL;
        
        
    }
    
    public boolean esMayorDeEdad()
    {
        if(edad >= 18)
        {
        return true;
        }else {
        return false;
        }
    }
    
    public void comprobarSexo(char sexo)
    {
        if(sexo != HOMBRE && sexo != MUJER && sexo != 'h' && sexo != 'm')
        {
         this.sexo=HOMBRE;
        }
    }
    
    public void generaDni()
    {
        dni=(int) (Math.random() * 999999999) + 1;
    }
    
    //Metodo ToString
    @Override
    public String toString() {
        return  "----------------------------------------------"
                + "\nDatos de " + nombre 
                + "\n----------------------------------------------"
                + "\n Edad:   " + edad 
                + "\n DNI:    " + dni 
                + "\n Sexo:   " + sexo 
                + "\n Peso:   " + peso 
                + "\n Altura: " + altura ;
    }
    
    //Metodos set

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    //Metodo get 
    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }
    
    
    
    
}
