package entities;

import utilities.Documento;
import utilities.ValidaCPF;

import java.util.ArrayList;

public class Funcionario extends Colaborador{
    private Integer idFuncionario;
    private String dadosAcessoFuncionario;
    private static ArrayList<Integer> listaIdsDocsTramitaveis;

    //construtores
    public Funcionario(String nome, String sobrenome,  String dataNascimento, String cpf, String enderecoCompleto, String login, String senha){
        super(nome, sobrenome, dataNascimento, cpf, enderecoCompleto,login,senha);
        this.idFuncionario = 15000+getId();
        this.dadosAcessoFuncionario = getLogin()+getSenha();
    }
    public Funcionario(String nome, String sobrenome,Integer id){
        super();
        this.idFuncionario = 15000+id;
    }

    //getter
    public Integer getIdFuncionario() {
        return idFuncionario;
    }
    public String getDadosAcessoFuncionario() {
        return dadosAcessoFuncionario;
    }
    public ArrayList<Integer> getListaIdsDocsTramitaveis() {
        return listaIdsDocsTramitaveis;
    }

    //metodo que monta a apresentação dos dados de cada colaborador
    public void listarDados(){
        System.out.println("\n----- Funcionário ID: "+getIdFuncionario()+" -----");
        System.out.println("Nome completo: "+getNome()+" "+getSobrenome());
        System.out.println("Data de nascimento: "+getDataNascimento());
        System.out.println("CPF: "+ ValidaCPF.montaCpfApresentacao(getCpf()));
        System.out.println("Endereço completo: "+getEnderecoCompleto());
        System.out.println("Login de acesso: "+getLogin());
    }
    @Override
    public void listarDocumentos(){
        novoDocumento = new Documento();
        try {
            if (novoDocumento.getListaDocumentos().toString().contains(getIdFuncionario().toString())){
                System.out.println("\nSegue abaixo a lista de todos os documentos criados por voce: ");
                for(Documento doc: novoDocumento.getListaDocumentos()){
                    System.out.println(doc.toString());
                }
            }else {
                System.out.println("Voce nao tem acesso a nenhum dos documentos cadastrados no sistema.");
            }
        }catch (NullPointerException err){
            System.out.println("\nATENÇÃO: Não existem documentos cadastrados. Realize o cadastro de novos documentos para visualizar o relatório.");
        }
    }
    @Override
    public boolean listarDocumentosTramitaveis(int idCriador){
        novoDocumento = new Documento();
            if (novoDocumento.getListaDocumentos().toString().contains(getIdFuncionario().toString())){
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
            }else {
                return false;
            }
    }
    @Override
    public void tramitaDocumento(int id, int idResponsavel){
        novoDocumento = new Documento();
        for (Documento doc: novoDocumento.getListaDocumentos()){
            if (id == doc.getIdDoc()){
                doc.setIdResponsavel(idResponsavel);
            }
        }
        System.out.println("\nSucesso,o documento foi tramitado para o supervisor selecionado.");
    }
}
