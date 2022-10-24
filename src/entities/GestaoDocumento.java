package entities;

public class GestaoDocumento {
    private Double id = Math.random();
    private Double idResponsavel;
    private Double idCriador;
    private String link;
    private String estado;

    public GestaoDocumento(Double idResponsavel, Double idCriador, String link, String estado) {
        this.idResponsavel = idResponsavel;
        this.idCriador = idCriador;
        this.link = link;
        this.estado = estado;
    }
}
