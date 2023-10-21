package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Account;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import application.ValidaSenha;

public class Program {

	public static void main(String[] args) {
		ValidaSenha validaSenha = new ValidaSenha();
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account account;
		
		System.out.println("Ol�, bem vindo ao banco Barbosa S.A!");
		System.out.printf("Iniciar sess�o ou criar conta (1 / 2) %n 1- Iniciar sess�o %n 2- Criar conta");
		char response1 = sc.next().charAt(0);
			if(response1 == '1') {
				System.out.print("Digite o n�mero da conta: ");
				int number = sc.nextInt();
				System.out.print("Digite seu nome: ");
				sc.nextLine();
				String user = sc.nextLine();
				System.out.print("Gostaria de entrar no menu de intera��es do banco? (s/n)");
				char response = sc.next().charAt(0);
				while(true) {
					if (response == 's') {
						System.out.println();
						System.out.printf("O que voc� deseja fazer agora? %n 1 - Dep�sito %n 2 - Saque %n 3 - Saldo %n 4 - Transfer�ncia%n 5 - Sair");
						char response2 = sc.next().charAt(0);
						if(response2 == '1') {
							account = new Account(number, user);
							System.out.println();
							System.out.print("Digite o valor do dep�sito: ");
							double depositValue = sc.nextDouble();
							account.deposit(depositValue);
							System.out.println("Dados da conta atualizados: ");
							System.out.println(account);
						}else if(response2 == '2') {
							account = new Account(number, user);
							System.out.println();
							System.out.println("Digite o valor que deseja sacar");
							double withdrawValue = sc.nextDouble();
							if(withdrawValue > account.getBalance()) {
								System.out.println("Voc� n�o tem saldo suficiente para completar essa a��o.");
							}else {
							account.withdraw(withdrawValue);
							System.out.println("Dados da conta atualizados: ");
							System.out.println(account);
							}

							
						}else if(response2 == '3') {
							account = new Account(number, user);
							System.out.printf("Ol� %s, o seu saldo atual � de R$%.2f", user, account.getBalance());
						}else if(response2 == '4') {
							account = new Account(number, user);
							System.out.println("Digite o nome da conta que voc� deseja transferir: ");
							sc.nextLine();
							String accountTransfer = sc.nextLine();
							System.out.println("Digite o valor que deseja transferir: ");
							double accountTransferValue = sc.nextDouble();
							if(accountTransferValue > account.getBalance()) {
								System.out.println("Voc� n�o tem saldo suficiente para completar essa transa��o!");
							}else {
								System.out.printf("Voc� confirma a transfer�ncia para a conta de %s no valor de R$%.2f? (S/N)", accountTransfer, accountTransferValue);
								char responseTransfer = sc.next().charAt(0);
								
								if(responseTransfer == 's') {
									account = new Account(number, user);
									System.out.println("Transfer�ncia completa, imprimindo o comprovante...");
									System.out.println();
									System.out.printf("Barbosa S.A          Comprovante de pagamento%nPagamento realizado%n%nR$%.2f%nDados da opera��o%n%nNome: %s%nValor: %.2f", accountTransferValue, accountTransfer,accountTransferValue);
									System.out.println();
									System.out.println("Dados da conta atualizados: ");
									account.transfer(accountTransferValue);
									System.out.println(account);
									
								}
							}

							
						}else if(response2 == '5') {
							System.out.println("Muito Obrigado por usar o banco Barbosa S.A.");
							break;
						}
					}
				}
					
			}else {
				System.out.println("Insira seus dados para iniciar a cria��o de conta!");
				System.out.println("Digite seu Email:");
				sc.nextLine();
				String userEmail = sc.nextLine();
				System.out.println("Digite seu cpf:");
				int cpf = sc.nextInt();
				System.out.println("Digite seu nome:");
				sc.nextLine();
				String userName = sc.nextLine();
				System.out.printf("Escolha uma senha: %nA senha deve conter no m�nimo uma letra mai�scula, uma min�scula, um caractere especial e um n�mero");
				String userPassword = sc.nextLine();
				System.out.println("Validando informa��es...");   
		        if (ValidaSenha.PASSWORD_PATTERN.matcher(userPassword).matches()) {
	                System.out.print("A senha � v�lida.");
	            } else {
	                System.out.print("A senha n�o � v�lida. Certifique-se de seguir as regras.");
	            }
		        
		        System.out.printf("%nOl� %s, voc� confirma os dados: %n Nome: %s, CPF: %s, Email: %s (S/N)", userName, userName, cpf, userEmail);
		        char response3 = sc.next().charAt(0);
		        if(response3 == 's') {
		        	System.out.print("Digite o n�mero da conta: ");
					int number = sc.nextInt();
					System.out.print("Digite seu nome: ");
					sc.nextLine();
					String user = sc.nextLine();
					System.out.print("Gostaria de fazer algum dep�sito inicial (s/n)?");
					char response = sc.next().charAt(0);

					if (response == 's') {
						System.out.print("Digite o valor de dep�sito inicial: ");
						double initialDeposit = sc.nextDouble();
						account = new Account(number, user, initialDeposit);
					} else {
						account = new Account(number, user);
					}

					System.out.println();
					System.out.println("Dados da conta: ");
					System.out.println(account);

					System.out.println();
					System.out.print("Digite o valor do dep�sito: ");
					double depositValue = sc.nextDouble();
					account.deposit(depositValue);
					System.out.println("Dados da conta atualizados: ");
					System.out.println(account);

					System.out.println();
					System.out.println("Digite o valor que deseja sacar");
					double withdrawValue = sc.nextDouble();
					account.withdraw(withdrawValue);
					System.out.println("Dados da conta atualizados: ");
					System.out.println(account);
		        }
			}
				
		sc.close();

	}

}