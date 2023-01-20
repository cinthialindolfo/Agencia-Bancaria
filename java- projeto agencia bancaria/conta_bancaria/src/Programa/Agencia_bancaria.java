package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class Agencia_bancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contas_bancarias;

    public static void main(String[] args) {
        contas_bancarias = new ArrayList<Conta>();
        operacoes();
    }
    public static void operacoes(){
        System.out.println("\n----------------------------------------------------"+
                        "\n-------------Bem Vindos a nossa Agencia-------------"+
                        "\n*****Selecione uma operacao que deseja realizar*****"+
                        "\n----------------------------------------------------"+
                        "\n|    Opcao 1 - Criar Conta   |"+
                        "\n|    Opcao 2 - Depositar     |"+
                        "\n|    Opcao 3 - Sacar         |"+
                        "\n|    Opcao 4 - Transferir    |"+
                        "\n|    Opcao 5 - Listar        |"+
                        "\n|    Opcao 6 - Sair          |");

        int operacao =  input.nextInt();
        switch(operacao){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar_contas();
                break;
            case 6:
                System.out.println("Vlw eh nois, obrigado por usar nossa agencia.");
                System.exit(0);
            default:
                System.out.println("Opcao Invalida!");
                operacoes();
                break;
        }
    }
    public static void criarConta(){
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contas_bancarias.add(conta);
        System.out.println("Sua conta foi criada com Sucesso!!!");

        operacoes();
    }
    private static Conta encontrar_conta(int numero_conta) {
        Conta conta = null;
        if (contas_bancarias.size() > 0) {
            for (Conta c : contas_bancarias){
                if (c.getNum_conta() == numero_conta) {
                    conta = c;
                }
            }
        }

        return conta;
    }
    public static void depositar(){
        System.out.println("Informe o numero da conta: ");
        int numero_conta = input.nextInt();

        Conta conta = encontrar_conta(numero_conta);

        if (conta!= null){
            System.out.println("Qual valor deseja depositar? ");
            Double valor_deposito = input.nextDouble();
            conta.depositar(valor_deposito);
            System.out.println("Valor depositado com Sucesso!!!");
        }else
            System.out.println("Conta nao encontrada!");

        operacoes();
    }
    public static void sacar(){
        System.out.println("Informe o numero da conta");
        int numero_conta = input.nextInt();

        Conta conta = encontrar_conta(numero_conta);

        if(conta != null){
            System.out.println("Qual valor deseja sacar?");
            Double valor_saque = input.nextDouble();
            conta.sacar(valor_saque);
            //System.out.println("Valor sacado com Sucesso!!!");
        }else
            System.out.println("Conta nao encontrada!");
        operacoes();
    }
    public static void transferir(){
        System.out.println("Informe numero da conta do remetente: ");
        int numero_conta_remetente = input.nextInt();

        Conta conta_rementente = encontrar_conta(numero_conta_remetente);

        if (conta_rementente != null){
            System.out.println("Numero da conta do destinatario: ");
            int numero_conta_destinatario = input.nextInt();

            Conta conta_destinatario = encontrar_conta(numero_conta_destinatario);

            if(conta_destinatario != null){
                System.out.println("Valor da transferencia: ");
                Double valor = input.nextDouble();

                conta_rementente .transferir(conta_destinatario, valor);
            }else
                System.out.println("A conta para deposito nao foi encontrada!");
        }else
            System.out.println("Conta para transferencia nao encontrada!");
        operacoes();
    }
    public static void listar_contas(){
        if(contas_bancarias.size() > 0){
            for (Conta conta: contas_bancarias){
                System.out.println(conta);
            }
        }else
            System.out.println("Nao ha contas cadastradas!");
        operacoes();
    }
}
