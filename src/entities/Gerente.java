package entities;

import utilities.Documento;
import utilities.ValidaCPF;

import java.util.ArrayList;
import java.util.Date;

public class Gerente extends Colaborador{
    private Integer idGerente;
    private String dadosAcessoGerente;

    //construtores
    public Gerente(String nome, String sobrenome,  String dataNascimento, String cpf, String enderecoCompleto, String login, String senha){
        super(nome, sobrenome, dataNascimento, cpf, enderecoCompleto,login,senha);
        this.idGerente = 21000+getId();
        this.dadosAcessoGerente = getLogin()+getSenha();
    }
    public Gerente(String nome, String sobrenome, Integer id) {
        super();
        this.idGerente=21000+id;
    }

    public Gerente() {

    }

    //getter
    public Integer getIdGerente() {
        return idGerente;
    }

    public String getDadosAcessoGerente() {
        return dadosAcessoGerente;
    }

    public ArrayList<Integer> getListaIdsDocsTramitaveis() {
        return listaIdsDocsTramitaveis;
    }

    //metodo que monta a apresentação dos dados de cada colaborador
    public void listarDados(){
        System.out.println("\n----- Gerente ID: "+getIdGerente()+" -----");
        System.out.println("Nome completo: "+getNome()+" "+getSobrenome());
        System.out.println("Data de nascimento: "+getDataNascimento());
        System.out.println("CPF: "+ ValidaCPF.montaCpfApresentacao(getCpf()));
        System.out.println("Endereço completo: "+getEnderecoCompleto());
        System.out.println("Login de acesso: "+getLogin());
    }
    @Override
    public void listarDocumentos(){
        novoDocumento = new Documento();
        if (novoDocumento.getListaDocumentos().size() > 0){
            System.out.println("\nSegue abaixo a lista de todos os documentos cadastrados no sistema: ");
            for(Documento doc: novoDocumento.getListaDocumentos()){
                   System.out.println(doc);
            }
        }else {
            System.out.println("Não existem documentos cadastrados no sistema.");
        }
    }
    public void listaDocArquivaveis(int idGerenteMov){
        listaIdsDocsTramitaveis = new ArrayList<>();
        novoDocumento = new Documento();
        if (novoDocumento.getListaDocumentos().toString().contains("Em aberto") && novoDocumento.getListaDocumentos().toString().contains(String.valueOf(idGerenteMov))){
            System.out.println("\nSegue abaixo a lista de todos os documentos que podem ser arquivados: ");
            for (Documento doc: novoDocumento.getListaDocumentos()){
                if (doc.getIdResponsavel().equals(idGerenteMov)&&doc.getEstado().equals("Em aberto")){
                    System.out.println(doc);
                    listaIdsDocsTramitaveis.add(doc.getIdDoc());
                }
            }
        }
    }
    public void listaDocDesarquivaveis(int idGerenteMov){
        listaIdsDocsTramitaveis = new ArrayList<>();
        novoDocumento = new Documento();
        if (novoDocumento.getListaDocumentos().toString().contains("Arquivado") && novoDocumento.getListaDocumentos().toString().contains(String.valueOf(idGerenteMov))){
            System.out.println("\nSegue abaixo a lista de todos os documentos que podem ser desarquivados: ");
            for (Documento doc: novoDocumento.getListaDocumentos()){
                if (doc.getIdResponsavel().equals(idGerenteMov)&&doc.getEstado().equals("Arquivado")){
                    System.out.println(doc);
                    listaIdsDocsTramitaveis.add(doc.getIdDoc());
                }
            }
        }
    }
    public void arquivarDocumento(int docArquivar, int idArquivado){
        for (Documento doc: novoDocumento.getListaDocumentos()){
            if (doc.getIdDoc().equals(docArquivar)){
                doc.setEstado("Arquivado");
                doc.setDataTramitacao(novaData = new Date());
                doc.setIdUltimoTramitador(String.valueOf(idArquivado));
                Documento.setContadorArquivados(Documento.getContadorArquivados() + 1);
                System.out.println("O documento foi arquivado com sucesso!");
            }
        }
    }
    public void desarquivarDocumento(int docDesarquivar, int idArquivado){
        for (Documento doc: novoDocumento.getListaDocumentos()){
            if (doc.getIdDoc().equals(docDesarquivar)){
                doc.setEstado("Em aberto");
                doc.setDataTramitacao(novaData = new Date());
                doc.setIdUltimoTramitador(String.valueOf(idArquivado));
                Documento.setContadorArquivados(Documento.getContadorArquivados() - 1);
                System.out.println("O documento foi desarquivado com sucesso!");
            }
        }
    }
}
