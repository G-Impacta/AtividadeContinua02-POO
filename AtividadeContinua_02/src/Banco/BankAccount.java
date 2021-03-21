package Banco;

import java.util.Random;

/*
 * Nome dos Integrantes:
 * Caio Victor dos Santos - 1904013
 * Cristhian Ocampo Quinteiro – 1902919
 * Thiago Souza do Amparo – 1904089
 */

public class BankAccount {
    
    private String owner; //Nome do correntista.
    private String senha; //Senha co correntista.
    private int accountNumber; //Número da conta.
    private double balance; //Saldo da conta.
    private double CPMF = 0;
    
    private static int lastAccountNumber = 1000; //Ultimo número da conta criada.
    
    //Construtor padrão.
    public BankAccount(String owner){
        this(owner, 0); //Chama o construtor principal com parametros padrão.
    }
    
    //Construtor principal.
    public BankAccount(String owner, double balance){
        accountNumber = lastAccountNumber++; //Adiciona o numero de identificação.
        this.balance = balance; //Inicia o saldo da conta.
        this.owner = checkName(owner); //Inicia o nome do correntista.
        this.senha = makePassword();
    }
    
    //Método de deposito.
    public void deposit(double amount){
        double newBalance = balance + amount; //Calcula o novo saldo da conta.
        balance = newBalance; //Adiciona o novo saldo a conta.
    }
    
    //Método saque.
    public void withDraw(double amount){
        double calculoCPMF = (amount * 0.25) / 100; //Calcula o CPMF.        
        double newBalance = balance - (amount + calculoCPMF); //Calcula o novo saldo da conta mais o CPMF.
        CPMF += calculoCPMF; //Adiciona e soma o valor do CPMF de todos os saques.
        balance = newBalance; //Adiciona o novo saldo a conta.
    }
    
    //Método transferência.
    public void transfer(double valor, BankAccount target){        
        this.balance -= valor; //Retira o valor da conta origem.
        target.balance += valor; //Insere o valor na conta destino.
    }
    
    //Método para verificar se o nome do correntista é valido.
    private static String checkName(String owner){
        
        //Transforma a primeira letra do nome do correntista em maiuscula.
        owner = owner.substring(0,1).toUpperCase() + owner.substring(1);
        
        //Utilizando Regex, verifica se o nome do correntista tem apenas letras.
        if(!owner.matches("[A-Z\u00C0-\u00FF]{1}[a-z\u00C0-\u00FF]+")){
            System.exit(0); //Caso não tenha encerra o programa.
        }
        
        return owner; //Caso seja valido, retorna o nome do correntista.
    }
    
    //Método gerador de senhas.
    private static String makePassword(){
        
        Random random = new Random(); //Instancia a classe Random.        
        String caracteres = ""; //Variavel que armazenará a senha gerada.
        
        for(int i = 0; i < 3; i++){ //Laço para gerar três caracteres.
            
            //Gera um número aleatorio entre 97 a 122 e converte para um caracterer da tabela ASCII.
            caracteres += String.valueOf((char)(random.nextInt(122- (97 - 1)) + 97));
        }
        
        for(int i = 0; i < 4; i++){ //Laço para gerar quatro caracteres númericos.
            
            //Gera um número aleatorio entre 0 a 9.
            caracteres += String.valueOf((random.nextInt(10)));
        }        
        
        //Retorna a senha criada aleatoriamente.
        return caracteres;
    }
    
    //Método getter.
    public double getBalance() {
        return balance;
    }
    
    //Método getter.
    public int getAccountNumber() {
        return accountNumber;
    }
    
    //Método getter.
    public String getSenha() {
        return senha;
    }
    
    @Override
    public String toString(){ //Método toString.
        return "Conta de " + owner + " - Saldo de R$ " + balance + " - Senha:  " + senha + " - Valor do CPMF: " + CPMF;
    }
}
