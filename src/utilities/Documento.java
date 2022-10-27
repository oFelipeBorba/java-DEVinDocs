package utilities;

import java.util.ArrayList;
import java.util.Date;

public class Documento {
    private Integer idDoc;
    private Date dataTramitacao;
    private static int contador = 0, contadorArquivados = 0;
    private Integer idResponsavel;
    private Integer idCriador;
    private String url;
    private String estado = "Em aberto";
    private String idUltimoTramitador = "Documento ainda nao foi tramitado";
    private static ArrayList<Documento> listaDocumentos = new ArrayList<>();

    //construtor
    public Documento(){

    }
    public Documento(Integer idResponsavel, Integer idCriador, String url) {
        this.idResponsavel = idResponsavel;
        this.idCriador = idCriador;
        this.url = url;
        this.idDoc = contador++;
        this.dataTramitacao = new Date();
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
    public static int getContadorArquivados() {
        return contadorArquivados;
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
    public void setDataTramitacao(Date dataTramitacao) {
        this.dataTramitacao = dataTramitacao;
    }
    public static void setContadorArquivados(int contadorArquivados) {
        Documento.contadorArquivados = contadorArquivados;
    }
    public void setIdUltimoTramitador(String idUltimoTramitador) {
        this.idUltimoTramitador = idUltimoTramitador;
    }

    @Override
    public String toString() {
        return "\n----- Documento ID: " + idDoc +" -----"+
                "\nIdentificador do colaborador responsável = " + idResponsavel +
                "\nIdentificador do colaborador que criou = " + idCriador +
                "\nIdentificador do ultimo colaborador que tramitou o documento = "+ idUltimoTramitador+
                "\nLink do documento = " + url  +
                "\nEstado atual = " + estado+
                "\nData da última movimentação = "+dataTramitacao;
    }
}
