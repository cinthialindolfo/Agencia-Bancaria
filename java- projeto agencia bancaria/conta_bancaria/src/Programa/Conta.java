package Programa;

import Utilitarios.Util;

public class Conta {

    private static int contador_contas = 1;

    private int num_conta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.num_conta = contador_contas;
        this.pessoa = pessoa;
        contador_contas += 1;
    }

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString(){
        return "\nNumero da Conta: " +this.getNum_conta()+
                "\nNome: " +this.pessoa.getNome()+
                "\nCPF: " +this.pessoa.getCpf()+
                "\nNEmail: " +this.pessoa.getEmail()+
                "\nSaldo: " + Util.doubleToString(this.getSaldo())+
                "\n";
    }

    public void depositar(Double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            //System.out.println("Seu saldo foi realizado com sucesso!");
        }else
            System.out.println("Nao foi possivel realizar o deposito.");
    }

    public void sacar(Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque foi realizado com sucesso!");
        }else
            System.out.println("Nao foi possivel realizar o saque.");
    }

    public void transferir(Conta conta_para_deposito, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);

            conta_para_deposito.saldo = conta_para_deposito.getSaldo() + valor;
            System.out.println("Transferencia realizada com sucesso!!!");
        }else
            System.out.println("Nao foi possivel realizar transferencia.");
    }
}
