package main.java.Model;

public class Link extends Frase{

    private Pagina PagineLinkata;

    public  Link(String testo, int posizione, Pagina pagina){
        super(testo,posizione);
        this.PagineLinkata = pagina;

    }

    public int getPaginaId(){
        return PagineLinkata.getID();
    }

}
