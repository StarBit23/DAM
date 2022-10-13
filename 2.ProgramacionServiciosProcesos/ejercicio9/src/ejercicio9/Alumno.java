package ejercicio9;
public class Alumno {
    private String nombre;
    private String apellidos;
    private int edad;
    private int curso;
    public Alumno() {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.curso = curso;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getCurso() {
        return curso;
    }
    public void setCurso(int curso) {
        this.curso = curso;
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%d,%d",
                nombre, apellidos, edad, curso);
    }
}
