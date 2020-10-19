package freezone.ec.petagram;

public class Mascota {
    private String nombre;
    // int porque se encuentra en drw
    private int foto;
    //Base de datos
    private int numero;
    private int id;


    //definimos el constructor para el RV1
    public Mascota(String nombre, int foto, int numero){
        this.nombre = nombre;
        this.foto = foto;
        this.numero = numero;
    }

    //definimos el constructor para el RV2
    public Mascota(int foto){
        this.foto = foto;

    }

    public Mascota() {

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

