
import java.text.ChoiceFormat;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        String nomeCliente, cidade;
        double saldo, vlr;
        boolean ativo = true;
        int opcao, numeroConta;
        Scanner ent = new Scanner(System.in);

        //Boas vindas
        System.out.println("Seja Bem Vindo ao seu banco !");

        //Solicita os dados de abertura
        System.out.println("Infome seu nome:");
        nomeCliente = ent.next();
        System.out.println("Informe sua cidade:");
        cidade = ent.next();
        System.out.println("Informe o saldo inicial:");
        saldo = ent.nextDouble();

        //Abre a conta
        Conta c = new Conta(saldo, nomeCliente, cidade);
        System.out.println("Parabéns sua conta foi aberta !");

        System.out.println("Número da conta: " + c.getNumeroConta());
        
        //Interação com a conta
        while (ativo) {

            System.out.println("Escolha uma opção:");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Ver Saldo");
            System.out.println("4 - Transferência");
            System.out.println("5 - Dados da conta");
            System.out.println("10 - Sair");

            opcao = ent.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Informe o valor do saque:");
                    vlr = ent.nextDouble();
                    if (c.sacar(vlr)) {
                        System.out.println("Saque Realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;
                case 2:
                    System.out.println("Informe o valor do depósito:");
                    vlr  = ent.nextDouble();
                    c.depositar(vlr);
                    System.out.println("Depósito realizado com sucesso !");
                    break;
                case 3:
                    System.out.println("Saldo: "+c.getSaldo());
                    break;
                case 4:
                    System.out.println("Informe o valor da transferência:");
                    vlr = ent.nextDouble();
                    
                    System.out.println("Informe o número da conta de destino:");
                    numeroConta = ent.nextInt();
                    
                    if (c.transferir(numeroConta, vlr)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;
                case 5:
                    System.out.println("Dados da conta:");
                    System.out.println
                    ("Número: "+c.getNumeroConta()+" | Cliente: "+c.nomeCliente+" | Cidade: "+c.cidadeCliente);
                    
                    break;
                default:
                    ativo = false;
                    break;
            }

        }
    }

}
