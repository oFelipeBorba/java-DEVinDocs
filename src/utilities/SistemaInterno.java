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
    private static int estadoMenuInterno, nivelDeAcesso = 0, docTramitar,docAprovacao;
    private static Integer idResponsavel;
    private static String urlNovoDoc;
    private static ArrayList<Integer> listaIdsValidos;
    static Scanner teclado = new Scanner(System.in);

    public SistemaInterno() {
    }
    //Metodo que da acesso ao usuario as funcionalidades especificas do sistema.
    //Verifico qual login e senha foi usado para entrar e crio um objeto com as informacoes uteis do colaborador que esta acessando.
    public static void acessaSistemaInterno(String login, String senha) {
        //Passa pela lista de funcionarios,supervisores e gerentes verificando o login e senha, ao encontrar o perfil eu monto um obj instanciando com o mesmo tipo daquele usuario.
        for (int i = 0; i < GestaoEquipe.listaFuncionarios.size(); i++) {
            if (GestaoEquipe.listaFuncionarios.get(i).getDadosAcessoFuncionario().contains(login+senha)) {
                System.out.println("\nOlá " + GestaoEquipe.listaFuncionarios.get(i).getNome() + ", seja bem vindo ao DOCin.");
                funcionarioLogado = new Funcionario(GestaoEquipe.listaFuncionarios.get(i).getNome(), GestaoEquipe.listaFuncionarios.get(i).getSobrenome(),GestaoEquipe.listaFuncionarios.get(i).getId());
                nivelDeAcesso = 1;
            }
        }
        for (int i = 0; i < GestaoEquipe.listaSupervisores.size(); i++) {
            if (GestaoEquipe.listaSupervisores.get(i).getDadosAcessoSupervisor().contains(login+senha)) {
                System.out.println("\nOlá " + GestaoEquipe.listaSupervisores.get(i).getNome() + ", seja bem vindo ao DOCin.");
                supervisorLogado = new Supervisor(GestaoEquipe.listaSupervisores.get(i).getNome(), GestaoEquipe.listaSupervisores.get(i).getSobrenome(), GestaoEquipe.listaSupervisores.get(i).getId());
                nivelDeAcesso = 2;
            }
        }
        for (int i = 0; i < GestaoEquipe.listaGerentes.size(); i++) {
            if (GestaoEquipe.listaGerentes.get(i).getDadosAcessoGerente().contains(login+senha)) {
                System.out.println("\nOlá " + GestaoEquipe.listaGerentes.get(i).getNome() + ", seja bem vindo ao DOCin.");
                gerenteLogado = new Gerente(GestaoEquipe.listaGerentes.get(i).getNome(), GestaoEquipe.listaGerentes.get(i).getSobrenome(), GestaoEquipe.listaGerentes.get(i).getId());
                nivelDeAcesso = 3;
            }
        }
            if (nivelDeAcesso == 0){
                System.out.println("\nATENÇÃO: Login e/ou senha informados estao incorretos.");
            }

        //Ao criar o objeto eu defino o nivel de acesso dele por meio do cargo que ele tem.
        //De acordo com esse nivel o usuario ira visualizar um menu diferente, que chama metodos especificos para aquele objeto.
        switch (nivelDeAcesso){
            //Menu interno para funcionarios, lista apenas os documentos criados por ele e pode os tramitar apenas para supervisores.
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
                            //Coleta do usuario o url do novo documento e chamo um metodo que cria esse doc passando as informacoes do colaborados que esta criando e o url informado.
                            case 1:
                                System.out.println("\nUm novo documento está sendo criado.\nPor favor informe o url que o documento irá armazenar:");
                                urlNovoDoc = teclado.nextLine();
                                funcionarioLogado.cadastraDocumento(funcionarioLogado.getIdFuncionario(), funcionarioLogado.getIdFuncionario(), urlNovoDoc);
                                System.out.println("\nNovo documento criado com sucesso!");
                                break;
                            case 2:
                                //Listo os documentos criados pelo funcionario que esta logado no sistemaInterno
                                funcionarioLogado.listarDocumentos();
                                break;
                            case 3:
                                //Apresento a lista dos documentos criados pelo funcionario logado, que ainda podem ser tramitadas
                                if (funcionarioLogado.listarDocumentosTramitaveis(funcionarioLogado.getIdFuncionario())){
                                    do {
                                        System.out.println("\nSelecione o documento que gostaria de tramitar da lista acima informando o ID:");
                                        docTramitar = teclado.nextInt();
                                        if (!funcionarioLogado.getListaIdsDocsTramitaveis().contains(docTramitar)){
                                            System.out.println("\nPor favor, digite um ID de documento valido da lista acima para continuar com o tramite.");
                                        }
                                    }while (!funcionarioLogado.getListaIdsDocsTramitaveis().contains(docTramitar));
                                    //Quando o usuario informa o id do documento que ele quer tramitar, apresento uma lista de supervisores para quem
                                    // ele pode escolher enviar esse documento.
                                    System.out.println("\nPor favor, direcione o documento para ser revisado por um dos supervisores abaixo.\nInforme apenas os números do id do escolhido:");
                                    listaIdsValidos = new ArrayList<>();
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
                                            funcionarioLogado.tramitaDocumento(docTramitar,idResponsavel, funcionarioLogado.getIdFuncionario());
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
            //Menu interno de supervisores, pode listar os documentos criados por qualquer funcionario e tramitar o que ele criou ou que foi direcionado a ele.
            case 2:
                do {
                    System.out.println("\n------MENU INTERNO------");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Cadastrar novo documento");
                    System.out.println("2 - Listar documentos 'Em aberto' cadastrados por todos funcionarios e por você");
                    System.out.println("3 - Tramitar documentos criados ou com revisão pendênte");
                    System.out.println("0 - LogOut");
                    try {
                        estadoMenuInterno = teclado.nextInt();
                        teclado.nextLine();

                        switch (estadoMenuInterno) {
                            case 1:
                                System.out.println("\nUm novo documento está sendo criado.\nPor favor informe o url que o documento irá armazenar:");
                                urlNovoDoc = teclado.nextLine();
                                supervisorLogado.cadastraDocumento(supervisorLogado.getIdSupervisor(), supervisorLogado.getIdSupervisor(), urlNovoDoc);
                                System.out.println("\nNovo documento criado com sucesso!");
                                break;
                            case 2:
                                supervisorLogado.listarDocumentos();
                                break;
                            case 3:
                                //Apresento a lista dos documentos criados pelo funcionario logado, que ainda podem ser tramitadas
                                if (supervisorLogado.listarDocumentosTramitaveis(supervisorLogado.getIdSupervisor())){
                                    do {
                                        System.out.println("\nSelecione o documento que gostaria de tramitar da lista acima informando o ID:");
                                        docTramitar = teclado.nextInt();
                                        if (!supervisorLogado.getListaIdsDocsTramitaveis().contains(docTramitar)){
                                            System.out.println("\nPor favor, digite um ID de documento valido da lista acima para continuar com o tramite.");
                                        }
                                    }while (!supervisorLogado.getListaIdsDocsTramitaveis().contains(docTramitar));
                                    //Quando o usuario informa o id do documento que ele quer tramitar, ele deve informar se ele vai aprovar ou recusar o tramite.
                                    //Apenas se o documento foi criado por um funcionario, caso ele tenha sido criado por ele mesmo, ele direciona a um gerente.
                                    System.out.println("\nPor favor informe se gostaria de aprovar ou recusar o documento selecionado.");                    System.out.println("Selecione uma opção:");
                                    System.out.println("1 - Aprovar");
                                    System.out.println("2 - Recusar");
                                        do {
                                            docAprovacao = teclado.nextInt();
                                            if (docAprovacao!=1 && docAprovacao!=2){
                                                System.out.println("\nPor favor digite apenas uma das opções acima:");
                                            }
                                        }while (docAprovacao!=1 && docAprovacao!=2);
                                    if (docAprovacao == 1){
                                        listaIdsValidos = new ArrayList<>();
                                        System.out.println("\nPor favor, direcione o documento para ser revisado por um dos gerentes abaixo.\nInforme apenas os números do id do escolhido:");
                                        for (int i=0;i<GestaoEquipe.listaGerentes.size(); i++){
                                            System.out.println(GestaoEquipe.listaGerentes.get(i).getNome()+" - ID: "+GestaoEquipe.listaGerentes.get(i).getIdGerente());
                                            listaIdsValidos.add(GestaoEquipe.listaGerentes.get(i).getIdGerente());
                                        }
                                        if (listaIdsValidos.size() == 0){
                                            System.out.println("\nATENÇÃO: Nao existe nenhum gerente cadastrado no sistema\nRealize o cadastro de pelo menos um gerente para realizar a tramitacao do documento.");
                                            break;
                                        }
                                        do {
                                            idResponsavel = teclado.nextInt();
                                            if (!listaIdsValidos.contains(idResponsavel)){
                                                System.out.println("Por favor, digite um ID valido da lista acima para finalizar o novo documento.");
                                            }else {
                                                supervisorLogado.tramitaDocumento(docTramitar,idResponsavel, supervisorLogado.getIdSupervisor());
                                            }
                                        }while (!listaIdsValidos.contains(idResponsavel));
                                    } else {
                                        supervisorLogado.recusaDocumento(docTramitar, supervisorLogado.getIdSupervisor());
                                    }
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




            case 3:
                System.out.println("Chama funcao com Gerente");
                break;
            //Caso o login e senha informados nao sejam compativeis com nenhum dado ja armazenado, entra no case 0 e nao permite a entrada no sistemaInterno
            case 0:
                break;
            default:
                System.out.println("\nPor favor, selecione uma opção valida do menu abaixo:");
        }
    }
}
