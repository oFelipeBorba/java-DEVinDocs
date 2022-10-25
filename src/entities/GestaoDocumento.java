package entities;

public class GestaoDocumento {
    private Double id = Math.random();
    private Double idResponsavel;
    private Double idCriador;
    private String url;
    private String estado;

    public GestaoDocumento(Double idResponsavel, Double idCriador, String url, String estado) {
        this.idResponsavel = idResponsavel;
        this.idCriador = idCriador;
        this.url = url;
        this.estado = estado;
    }
}
