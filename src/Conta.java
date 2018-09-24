
import java.util.Random;

public class Conta {
 
    private double saldo;
    private int numeroConta;
    private String extrato;
    public String nomeCliente;
    public String cidadeCliente;
    
    public Conta(double saldoInicial, String nome, String cidade) {
        this.saldo = saldoInicial;
        this.nomeCliente = nome;
        this.cidadeCliente = cidade;
        
        Random rand = new Random();
        this.numeroConta = rand.nextInt(10000);
        
        this.extrato = "Conta aberta\n";
    }
    
    public int getNumeroConta() {
        return this.numeroConta;
    }
    
    public boolean sacar(double vlrSaque) {
        if (this.saldo >= vlrSaque) {
            this.saldo -= vlrSaque;
            
            this.gerarExtrato("Saque realizado: "+vlrSaque);
            
            return true;
        } else {
            return false;
        }
    }
    
    public void depositar(double vlrDeposito) {
        this.saldo += vlrDeposito;
        this.gerarExtrato("Depósito realizado: "+vlrDeposito);
    }
    
    public boolean transferir(int numeroConta, double vlrTransferencia) {
        if (this.saldo >= vlrTransferencia) {
            this.saldo -= vlrTransferencia;
            this.gerarExtrato("Transferência realizada: "+vlrTransferencia);
            return true;
        } else {
            return false;
        }
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public String getExtrato() {
        return this.extrato;
    }
    
    private void gerarExtrato(String log) {
        this.extrato += log+"\n";
    }
    
}