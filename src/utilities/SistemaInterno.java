package utilities;

import entities.Funcionario;
import entities.Gerente;
import entities.Supervisor;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaInterno {
    private static Funcionario funcionarioLogado;
    private static Supervisor supervisorLogado;
    private static Gerente gerenteLogado;
    private static int estadoMenuInterno, nivelDeAcesso = 0, docTramitar;
    private static Integer idResponsavel;
    private static String urlNovoDoc;
    private static ArrayList<Integer> listaIdsValidos = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    public SistemaInterno() {
    }

    public static void acessaSistemaInterno(String login, String senha) {
        for (int i = 0; i < GestaoEquipe.listaFuncionarios.size(); i++) {
            if (GestaoEquipe.listaFuncionarios.get(i).getDadosAcessoFuncionario().contains(login) && GestaoEquipe.listaFuncionarios.get(i).getDadosAcessoFuncionario().contains(senha)) {
                System.out.println("\nOlá " + GestaoEquipe.listaFuncionarios.get(i).getNome() + ", seja bem vindo ao DOCin.");
                funcionarioLogado = new Funcionario(GestaoEquipe.listaFuncionarios.get(i).getNome(), GestaoEquipe.listaFuncionarios.get(i).getSobrenome(),GestaoEquipe.listaFuncionarios.get(i).getId());
                nivelDeAcesso = 1;
            }
        }
        for (int i = 0; i < GestaoEquipe.listaSupervisores.size(); i++) {
            if (GestaoEquipe.listaSupervisores.get(i).getDadosAcessoSupervisor().contains(login) && GestaoEquipe.listaSupervisores.get(i).getDadosAcessoSupervisor().contains(senha)) {
                System.out.println("\nOlá " + GestaoEquipe.listaSupervisores.get(i).getNome() + ", seja bem vindo ao DOCin.");
                supervisorLogado = new Supervisor(GestaoEquipe.listaSupervisores.get(i).getNome(), GestaoEquipe.listaSupervisores.get(i).getSobrenome(), GestaoEquipe.listaSupervisores.get(i).getId());
                nivelDeAcesso = 2;
            }
        }
        for (int i = 0; i < GestaoEquipe.listaGerentes.size(); i++) {
            if (GestaoEquipe.listaGerentes.get(i).getDadosAcessoGerente().contains(login) && GestaoEquipe.listaGerentes.get(i).getDadosAcessoGerente().contains(senha)) {
                System.out.println("\nOlá " + GestaoEquipe.listaGerentes.get(i).getNome() + ", seja bem vindo ao DOCin.");
                gerenteLogado = new Gerente(GestaoEquipe.listaGerentes.get(i).getNome(), GestaoEquipe.listaGerentes.get(i).getSobrenome(), GestaoEquipe.listaGerentes.get(i).getId());
                nivelDeAcesso = 3;
            }
        }
            if (nivelDeAcesso == 0){
                System.out.println("\nATENÇÃO: Login e/ou senha informados estao incorretos.");
            }


        switch (nivelDeAcesso){
            case 1:
                do {
                    System.out.println("\n------MENU INTERNO------");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Cadastrar novo documento");
                    System.out.println("2 - Listar documentos criados");
                    System.out.println("3 - Tramitar documentos criados");
                    System.out.println("0 - LogOut");
                    try {
                        estadoMenuInterno = teclado.nextInt();
                        teclado.nextLine();

                        switch (estadoMenuInterno) {
                            case 1:
                                System.out.println("\nUm novo documento está sendo criado.\nPor favor informe o url que o documento irá armazenar:");
                                urlNovoDoc = teclado.nextLine();
                                funcionarioLogado.cadastraDocumento(funcionarioLogado.getIdFuncionario(), funcionarioLogado.getIdFuncionario(), urlNovoDoc);
                                System.out.println("\nNovo documento criado com sucesso!");
                                break;
                            case 2:
                                funcionarioLogado.listarDocumentos();
                                break;
                            case 3:
                                if (funcionarioLogado.listarDocumentosTramitaveis(funcionarioLogado.getIdFuncionario())){
                                    do {
                                        docTramitar = teclado.nextInt();
                                        if (!funcionarioLogado.getListaIdsDocsTramitaveis().contains(docTramitar)){
                                            System.out.println("Por favor, digite um ID de documento valido da lista acima para continuar com o tramite.");
                                        }else{
                                            System.out.println("\nSelecione o documento que gostaria de tramitar da lista abaixo informando o ID:");
                                        }
                                    }while (!funcionarioLogado.getListaIdsDocsTramitaveis().contains(docTramitar));

                                    System.out.println("\nPor favor, direcione o documento para ser revisado por um dos supervisores abaixo.\nInforme apenas os números do id do escolhido:");
                                    for (int i=0;i<GestaoEquipe.listaSupervisores.size(); i++){
                                        System.out.println(GestaoEquipe.listaSupervisores.get(i).getNome()+" - ID: "+GestaoEquipe.listaSupervisores.get(i).getIdSupervisor());
                                        listaIdsValidos.add(GestaoEquipe.listaSupervisores.get(i).getIdSupervisor());
                                    }
                                    if (listaIdsValidos.size() == 0){
                                        System.out.println("\nATENÇÃO: Nao existe nenhum supervisor cadastrado no sistema\nRealize o cadastro de pelo menos um supervisor para realizar a tramitacao do documento.");
                                        break;
                                    }
                                    do {
                                        idResponsavel = teclado.nextInt();
                                        if (!listaIdsValidos.contains(idResponsavel)){
                                            System.out.println("Por favor, digite um ID valido da lista acima para finalizar o novo documento.");
                                        }else {
                                            funcionarioLogado.tramitaDocumento(docTramitar,idResponsavel);
                                        }
                                    }while (!listaIdsValidos.contains(idResponsavel));
                                } else {
                                    System.out.println("Nao existem documentos para serem tramitados por voce.");
                                }
                        break;
                        }
                    }catch (InputMismatchException err){
                        System.out.println("\nATENÇÃO: Você digitou caracteres, por favor informe apenas o número da opção que deseja!\nInfelizmente teremos que te desconectar do sistema, realize o login e tente novamente.");
                        teclado.next();
                        break;
                    }
                } while (estadoMenuInterno != 0);
                break;




            case 2:
                do {
                    System.out.println("\n------MENU INTERNO------");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Cadastrar novo documento");
                    System.out.println("2 - Listar documentos criados");
                    System.out.println("0 - LogOut");
                    try {
                        estadoMenuInterno = teclado.nextInt();
                        teclado.nextLine();

                        switch (estadoMenuInterno) {
                            case 1:
                                break;
                            case 2:
                                break;
                        }
                    }catch (InputMismatchException err){
                        System.out.println("\nATENÇÃO: Você digitou caracteres, por favor informe apenas o número da opção que deseja!\nInfelizmente teremos que te desconectar do sistema, realize o login e tente novamente.");
                        teclado.next();
                        break;
                    }
                } while (estadoMenuInterno != 0);
                break;




            case 3:
                System.out.println("Chama funcao com Gerente");
                break;
        }

    }
}
