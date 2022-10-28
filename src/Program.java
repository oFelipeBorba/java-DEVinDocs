import entities.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import utilities.Documento;
import utilities.GestaoEquipe;
import utilities.ValidaCPF;
import utilities.SistemaInterno;

public class Program {
    public static void main(String[] args) {
        int selecaoMenu;
        boolean validadorCpf = false;
        String nome, sobrenome, cpf, enderecoCompleto,dataNascimento,login,senha;
        Pessoa novoColaborador;
        GestaoEquipe gerenciaEquipe = new GestaoEquipe();
        Scanner teclado = new Scanner(System.in);

        //Menu funciona em loop com do while, dependendo da selecao do usuario ele entra em um case diferente de um switch.
        do{
            System.out.println("\n------MENU------");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar novo colaborador");
            System.out.println("2 - Realizar login no sistema");
            System.out.println("3 - Gerar relatório da lista de colaboradores");
            System.out.println("4 - Gerar relatório do total de documentos arquivados");
            System.out.println("0 - Sair");

            //try catch para proteger do erro de digitiar caracteres em um campo de int.
            try{
                selecaoMenu = teclado.nextInt();
                teclado.nextLine();
                switch (selecaoMenu){
                    //Criando um novo usuario, busco valores para os atributos para criar uma nova pessoa, ao final eu instancio ela com o tipo
                    // de colaborador escolhido pelo usuario (funcionario, supervisor ou gerente)
                    case 1:
                        System.out.println("\nInforme seu nome: ");
                        nome = teclado.nextLine();

                        System.out.println("\nInforme seu sobrenome: ");
                        sobrenome = teclado.nextLine();
                        //Realizo um loop para validar o cpf, chamo um metodo verificaCPF
                        do {
                            System.out.println("\nInforme os 11 números do seu cpf: ");
                            cpf = teclado.nextLine();
                            validadorCpf = ValidaCPF.verificaCPF(cpf);
                            if (!validadorCpf){
                                System.out.println("ATENÇÃO: O cpf informado não é valido.\nPor favor tente novamente, informe apenas os números de um cpf real.");
                            }
                        }while (!validadorCpf);

                        System.out.println("\nInforme seu endereço completo: ");
                        enderecoCompleto = teclado.nextLine();

                        System.out.println("\nInforme sua data de nascimento: ");
                        dataNascimento = teclado.nextLine();

                        //Realizo um loop para que o login e senha sejam criados de acordo com a exigencia
                        do {
                            System.out.println("\nInforme o login do novo colaborador (Deve conter pelo menos 6 caracteres/números): ");
                            login = teclado.nextLine();
                            if (login.length()<6){
                                System.out.println("ATENÇÃO: O login informado é menor que 6 caracteres.");
                            }
                        }while (login.length()<6);
                        do {
                            System.out.println("\nInforme a senha do novo colaborador (Deve conter pelo menos 6 caracteres/números): ");
                            senha = teclado.nextLine();
                            if (senha.length()<6){
                                System.out.println("ATENÇÃO: O login informado é menor que 6 caracteres.");
                            }
                        }while (senha.length()<6);

                        System.out.println("\nSelecione o cargo do novo colaborador:");
                        System.out.println("1 - Funcionário");
                        System.out.println("2 - Supervisor");
                        System.out.println("3 - Gerente");
                        int tipoColaborador;
                        try{
                            tipoColaborador = teclado.nextInt();
                            //Apos montar o novo colaborador instanciando para o cargo que o usuario seleciona eu chamo um metodo adicionaColaborador
                            //da classe GestaoEquipe. Ele verifica qual foi a instancia e adiciona para uma arrayList especifica.
                            switch (tipoColaborador){
                                case 1:
                                    novoColaborador = new Funcionario(nome, sobrenome, dataNascimento, cpf, enderecoCompleto,login,senha);
                                    gerenciaEquipe.adicionaColaborador(novoColaborador);
                                    break;
                                case 2:
                                    novoColaborador = new Supervisor(nome, sobrenome, dataNascimento, cpf, enderecoCompleto,login,senha);
                                    gerenciaEquipe.adicionaColaborador(novoColaborador);
                                    break;
                                case 3:
                                    novoColaborador = new Gerente(nome, sobrenome, dataNascimento, cpf, enderecoCompleto,login,senha);
                                    gerenciaEquipe.adicionaColaborador(novoColaborador);
                                    break;
                                default:
                                    System.out.println("\nATENÇÃO: Você não selecionou uma opção valida para o cargo do colaborador, tente novamente.");
                            }
                            break;
                        }catch (InputMismatchException err){
                            System.out.println("\nATENÇÃO: Você digitou caracteres, por favor informe apenas o número da opção que deseja!");
                            teclado.next();
                            break;
                        }
                    //Coleto do usuario o login e senha que ele deseja usar para acessar o sistema e chamo o metodo acessaSistemaInterno da classe SistemaInterno.
                    case 2:
                        System.out.println("\nDigite seu login:");
                        login = teclado.nextLine();
                        System.out.println("\nDigite sua senha:");
                        senha = teclado.nextLine();
                        SistemaInterno.acessaSistemaInterno(login,senha);
                        break;
                    //Gero uma lista de colaboradores de acordo com a selecao do usuario. Chamo o metodo listarColaboradores.
                    case 3:
                        System.out.println("\nSelecione quais colaboradores irão compor o relatório:");
                        System.out.println("1 - Funcionários");
                        System.out.println("2 - Supervisores");
                        System.out.println("3 - Gerentes");
                        System.out.println("4 - Todos colaboradores");
                        int tipoLista;
                        try{
                            tipoLista = teclado.nextInt();
                            if(tipoLista != 1 && tipoLista != 2 && tipoLista != 3 && tipoLista != 4){
                                System.out.println("\nATENÇÃO: Você não selecionou uma opção valida, tente novamente.");
                            }else{
                                gerenciaEquipe.listarColaboradores(tipoLista);
                            }
                            break;
                        }catch (InputMismatchException err){
                            System.out.println("\nATENÇÃO: Você digitou caracteres, por favor informe apenas o número da opção que deseja!");
                            teclado.next();
                            break;
                        }
                    case 4:
                        System.out.println("\nO número total de documentos aquivados no sistema DOCin são: "+ Documento.getContadorArquivados());
                        break;
                    case 0:
                        System.out.println("\nSaindo do sistema...");
                        break;
                    default:
                        System.out.println("\nPor favor, selecione uma opção valida do menu abaixo:");
                }
            }catch (InputMismatchException err){
                System.out.println("\nATENÇÃO: Você digitou caracteres, por favor informe apenas o número da opção que deseja!");
                teclado.next();
                selecaoMenu = 99;
            }
        } while (selecaoMenu != 0);
    }
    }
