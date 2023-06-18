public class Usuario {

    private String nombreUsuario;
    private String emailUsuario;
    private String passUsuario;

    public Usuario(String nombreUsuario, String emailUsuario, String passUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.passUsuario = passUsuario;
    }


    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return this.emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPassUsuario() {
        return this.passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }
    


    @Override
    public String toString() {
        return "{" +
            " nombreUsuario='" + getNombreUsuario() + "'" +
            ", emailUsuario='" + getEmailUsuario() + "'" +
            ", passUsuario='" + getPassUsuario() + "'" +
            "}";
    }
    

}