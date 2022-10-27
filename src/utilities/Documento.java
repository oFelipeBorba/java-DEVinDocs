package utilities;

import java.util.ArrayList;

public class Documento {
    private Integer idDoc;
    private static int contador = 0;
    private Integer idResponsavel;
    private Integer idCriador;
    private String url;
    private String estado = "Em aberto";
    private static ArrayList<Documento> listaDocumentos = new ArrayList<>();

    //construtor
    public Documento(){

    }
    public Documento(Integer idResponsavel, Integer idCriador, String url) {
        this.idResponsavel = idResponsavel;
        this.idCriador = idCriador;
        this.url = url;
        this.idDoc = contador++;
        listaDocumentos.add(this);
    }
    //getters
    public Integer getIdDoc() {
        return idDoc;
    }
    public Integer getIdResponsavel() {
        return idResponsavel;
    }
    public Integer getIdCriador() {
        return idCriador;
    }
    public String getUrl() {
        return url;
    }
    public String getEstado() {
        return estado;
    }
    public ArrayList<Documento> getListaDocumentos() {
        return listaDocumentos;
    }

    //setters
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setListaDocumentos(ArrayList<Documento> listaDocumentos) {
        Documento.listaDocumentos = listaDocumentos;
    }
    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    @Override
    public String toString() {
        return "\n----- Documento ID: " + idDoc +" -----"+
                "\nIdentificador do colaborador responsável = " + idResponsavel +
                "\nIdentificador do colaborador que criou = " + idCriador +
                "\nLink do documento = " + url  +
                "\nEstado atual = " + estado;
    }
}
