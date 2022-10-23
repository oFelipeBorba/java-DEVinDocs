package entities;

public class Documento {
    private Double id = Math.random();
    private Double idResponsavel;
    private Double idCriador;
    private String link;
    private String estado;

    public Documento(Double idResponsavel, Double idCriador, String link, String estado) {
        this.idResponsavel = idResponsavel;
        this.idCriador = idCriador;
        this.link = link;
        this.estado = estado;
    }
}
