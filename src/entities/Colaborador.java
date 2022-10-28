package entities;


import utilities.Documento;

import java.util.ArrayList;
import java.util.Date;

public abstract class Colaborador extends Pessoa{
    private String login;
    private String senha;
    protected Documento novoDocumento;
    protected Date novaData;
    protected static ArrayList<Integer> listaIdsDocsTramitaveis;

    //construtor
    public Colaborador() {

    }
    public Colaborador(String nome, String sobrenome, String dataNascimento, String cpf, String enderecoCompleto, String login, String senha) {
        super(nome, sobrenome, dataNascimento, cpf, enderecoCompleto);
        this.login = login;
        this.senha = senha;
    }
    //getters
    public String getLogin() {
        return login;
    }
    public String getSenha() {
        return senha;
    }

    //setters
    public void setLogin(String login) {
        this.login = login;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    //metodo que cria um novo documento no sistema
    public void cadastraDocumento(Integer idResponsavel, Integer idCriador, String url){
        novoDocumento = new Documento(idResponsavel,idCriador,url);
    }
    public void listarDocumentos(){
        novoDocumento = new Documento();
        if(novoDocumento.getListaDocumentos().size() == 0){
            System.out.println("\nATENÇÃO: Não existem documentos cadastrados. Realize o cadastro de novos documentos para visualizar o relatório.");
        }else{
            System.out.println("\nSegue abaixo a lista de todos os documentos: ");
            for(Documento doc: novoDocumento.getListaDocumentos()){
                System.out.println(doc.toString());
            }
        }
    }
    public boolean listarDocumentosTramitaveis(int idCriador){
        novoDocumento = new Documento();
            if (novoDocumento.getListaDocumentos().toString().contains("Em aberto")){
                listaIdsDocsTramitaveis = new ArrayList<>();
                for(Documento doc: novoDocumento.getListaDocumentos()){
                    if (doc.toString().contains("Em aberto") && doc.getIdResponsavel().equals(idCriador)){
                        System.out.println(doc.toString());
                        listaIdsDocsTramitaveis.add(doc.getIdDoc());
                    }
                }
                if (listaIdsDocsTramitaveis.size() == 0){
                    return false;
                }
            }else {
                return false;
            }
            return true;
        }

    public void tramitaDocumento(int id, int idResponsavel, int idTramite){
        novoDocumento = new Documento();
        for (Documento doc: novoDocumento.getListaDocumentos()){
            if (id == doc.getIdDoc()){
                doc.setIdResponsavel(idResponsavel);
                doc.setDataTramitacao(novaData = new Date());
                doc.setIdUltimoTramitador(String.valueOf(idTramite));
            }
        }
        System.out.println("\nSucesso,o documento foi tramitado para o colaborador selecionado.");
    }

}
