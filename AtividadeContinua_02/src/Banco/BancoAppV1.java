package Banco;

/**
 *
 * @author Thiago
 */
public class BancoAppV1 {
    
    public static void main(String[] args) {
        
        BankAccount contas[] = new BankAccount[5];
        
        contas[0] = new BankAccount("Marcos", 1000.00);
        
        contas[1] = new BankAccount("Júlia", 250.00);
        
        contas[2] = new BankAccount("Jõao", 2500.00);
        
        contas[3] = new BankAccount("Roberto", 3000.00);
        
        contas[4] = new BankAccount("Janaína", 4500.00);
    }   
}
