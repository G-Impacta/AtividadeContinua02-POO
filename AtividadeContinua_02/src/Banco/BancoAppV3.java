package Banco;

import java.util.Scanner;

/*
 * Nome dos Integrantes:
 * Caio Victor dos Santos - 1904013
 * Cristhian Ocampo Quinteiro – 1902919
 * Thiago Souza do Amparo – 1904089
 */

public class BancoAppV3 {
    
    public static Scanner entrada;    
        
    public static void mostrarInfo(BankAccount[] contas){
        
        System.out.println("\nContas de todos os clientes:");
        
        for(int i = 0; i < contas.length; i++){
            System.out.println("[" + i + "]" + contas[i].toString());
        }
        
        System.out.println("");        
    }
    
    public static void interacaoSacar(BankAccount[] contas){
        
        boolean clienteValido = false;
        int indiceConta = -1;
        
        while(!clienteValido){
            
            mostrarInfo(contas);
            
            System.out.print("O saque será efetuado na conta de qual cliente?"
                    + "(0 a " + (contas.length - 1) + "): ");
            
            indiceConta = entrada.nextInt();
            
            if(indiceConta >= 0 && indiceConta < contas.length){
                
                clienteValido = true;
                
            }else{
                
                System.out.println("Índice de cliente inválido!");
            }            
        }
        
        System.out.println("Qual o valor do saque? ");
        double saque = entrada.nextDouble();
        
        contas[indiceConta].withDraw(saque);
        System.out.println("Saque finalizado.\n");       
    }
    
    //Método de interação com o usuario para realizar deposito.
    public static void interacaoDepositar (BankAccount[] contas){
        
        boolean clienteValido = false; //Variavel Flag, para encerrar o loop.
        int indiceConta = -1; //Variavel para armazenar o indice da conta.
        
        while(!clienteValido){ //Loop de validação de indice.
            
            mostrarInfo(contas); //Exibe as contas existentes.            
            
            //Mensagem de interação.
            System.out.print("O saque será efetuado na conta de qual cliente?"
                    + "(0 a " + (contas.length - 1) + "): ");
            
            //Variavel recebe o indice informado pelo usuario.
            indiceConta = entrada.nextInt();            
            
            //Verifica se o indice é valido (se está dentro dos valores permitidos).
            if(indiceConta >= 0 && indiceConta < contas.length){
                
                //Caso esteja, modifica a variavel Flag para true.
                clienteValido = true;
                
            }else{
                
                //Caso não esteja, informa uma mensagem de erro.
                System.out.println("Índice do cliente inválido!");
                
                //Reinicia o loop.
            }          
        }        
        
        //Mensagem de interação.
        System.out.println("Qual o valor do deposito? ");
        //Variavel recebe o valor informado pelo usuario.
        double deposito = entrada.nextDouble(); 
        
        //Invoca o método de deposito da classe BankAccount.
        contas[indiceConta].deposit(deposito);
        System.out.println("Deposito finalizado.\n"); //Mensagem de encerramento.
    }
    
    //Método de interação com o usuario para realizar transferencia.
    public static void interacaoTransferir(BankAccount[] contas){
        
        int indiceContaOrigem = -1; //Variavel para armazenar o indice da conta origem.
        int indiceContaDestino = -1; //Variavel para armazenar o indice da conta destino.
        double valorTransferencia = 0; //Variavel para armazenar o valor.
        
        mostrarInfo(contas); //Exibe as contas existentes.
        
        do{ //Laço para validar o indice da conta origem.
            
            //Mensagem de interação.
            System.out.println("Informe a conta que realizará a transferência: ");
            
            //Variavel recebe o indice informado pelo usuario.
            indiceContaOrigem = entrada.nextInt();
            
            //Verifica se o indice é valido (se está dentro dos valores permitidos).
            if(indiceContaOrigem < 0 || indiceContaOrigem >= contas.length){
                //Caso não esteja, informa uma mensagem de erro.
                System.out.println("Índice do cliente inválido!");
            }
        
         //Condição do laço de repetição.
        }while(indiceContaOrigem < 0 || indiceContaOrigem >= contas.length);           
        
        do{ //Laço para validar o indice da conta destino.
            
            //Mensagem de interação.
            System.out.println("\nInforme a conta que receberá a transferência: ");
            
            //Variavel recebe o indice informado pelo usuario.
            indiceContaDestino = entrada.nextInt();            
            
            //Verifica se o indice é valido (se está dentro dos valores permitidos).
            if(indiceContaDestino < 0 || indiceContaDestino >= contas.length){
                
                //Caso não esteja, informa uma mensagem de erro.
                System.out.println("Índice do cliente inválido!");
                
                
             //Verifica se o indice não é igual ao de origem.   
            }else if(indiceContaDestino == indiceContaOrigem){
                
                //Caso seja, informa uma mensagem de erro.
                System.out.println("Você não pode selecionar a mesma conta"
                        + " que realizará a transferência!");
            }
        
         //Condição do laço de repetição.
        }while(indiceContaDestino < 0 || indiceContaDestino >= contas.length || 
                indiceContaDestino == indiceContaOrigem);
        
        do{ //Laço para validar o valor da transferência
            
            //Mensagem de interação.
            System.out.println("\nInforme o valor que será transfêrido: ");
            
            //Variavel recebe o valor informado pelo usuario.
            valorTransferencia = entrada.nextDouble();
            
            //Verifica se existe saldo na conta do correntista.
            if(valorTransferencia > contas[indiceContaOrigem].getBalance()){
                
                //Caso não exista, exibe uma mensagem de saldo insuficiente.
                System.out.println("Saldo insuficiênte para realizar a transferência!");
            }
         
         //Condição do laço de repetição.
        }while(valorTransferencia > contas[indiceContaOrigem].getBalance());
        
        //Invoca o método de transferencia da classe BankAccount.
        contas[indiceContaOrigem].transfer(valorTransferencia, contas[indiceContaDestino]);
        System.out.println("Transferência finalizada."); //Mensagem de encerramento.
    }
        
    public static void main(String[] args) {
        
        BankAccount contas[] = new BankAccount[5];
        
        contas[0] = new BankAccount("Marcos", 1000.00);
        
        contas[1] = new BankAccount("Júlia", 250.00);
        
        contas[2] = new BankAccount("Jõao", 2500.00);
        
        contas[3] = new BankAccount("Roberto", 3000.00);
        
        contas[4] = new BankAccount("Janaína", 4500.00);
        
        entrada = new Scanner(System.in);
        
        boolean sair = false;
        
        while(!sair){
            
            System.out.println("Escolha uma operação:");
            
            System.out.println("(1) Mostrar informações de todas as contas");
            
            System.out.println("(2) Sacar");
            
            System.out.println("(3) Depositar");
            
            System.out.println("(4) Transferir");
            
            System.out.println("(5) Sair");
            
            int escolha = entrada.nextInt();
            
            switch(escolha){
                
                case 1: mostrarInfo(contas); break;
                
                case 2: interacaoSacar(contas); break;
                
                case 3: interacaoDepositar(contas); break;
                
                case 4: interacaoTransferir(contas); break;
                
                case 5: sair = true; break;
                
                default: System.out.println("Opção inválida!");                
            }
            
            System.out.println("");
        }
        
        System.out.println("Fim do programa.");
    }    
}
