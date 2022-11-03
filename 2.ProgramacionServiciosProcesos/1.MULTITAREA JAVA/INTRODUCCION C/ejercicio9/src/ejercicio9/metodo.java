package ejercicio9;
import java.util.ArrayList;
import java.util.Scanner;
public class metodo {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Alumno> arrayAlumno = new ArrayList();
    public static void main(String[] args) {
        leerAlumnos();
        mostrarAlumnos();
    }
    public static void mostrarAlumnos() {
        System.out.println("Estos son los alumnos creados");
        for (int i = 0; i< arrayAlumno.size(); i++){
            System.out.println(arrayAlumno.get(i));
        }
    }
    public static void leerAlumnos() {
        String nombre;
        String apellidos;
        int edad;
        int curso;
        int i, N;
        do {
            System.out.println("Cuantos alumnos?");
            N = sc.nextInt();
        } while (N < 0);
        for (i = 1; i <= N; i++){
            sc.nextLine();
            System.out.println("Alumno " + i);
            System.out.println("Nombre: ");
            nombre = sc.nextLine();
            System.out.println("Apellidos: ");
            apellidos = sc.nextLine();
            System.out.println("Edad: ");
            edad = sc.nextInt();
            System.out.println("Curso: ");
            curso = sc.nextInt();
            Alumno alumno = new Alumno();
            alumno.setNombre(nombre);
            alumno.setApellidos(apellidos);
            alumno.setEdad(edad);
            alumno.setCurso(curso);
            arrayAlumno.add(alumno);
        }
    }
}
