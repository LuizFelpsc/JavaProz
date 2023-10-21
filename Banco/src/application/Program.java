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
		
		System.out.println("Olá, bem vindo ao banco Barbosa S.A!");
		System.out.printf("Iniciar sessão ou criar conta (1 / 2) %n 1- Iniciar sessão %n 2- Criar conta");
		char response1 = sc.next().charAt(0);
			if(response1 == '1') {
				System.out.print("Digite o número da conta: ");
				int number = sc.nextInt();
				System.out.print("Digite seu nome: ");
				sc.nextLine();
				String user = sc.nextLine();
				System.out.print("Gostaria de entrar no menu de interações do banco? (s/n)");
				char response = sc.next().charAt(0);
				while(true) {
					if (response == 's') {
						System.out.println();
						System.out.printf("O que você deseja fazer agora? %n 1 - Depósito %n 2 - Saque %n 3 - Saldo %n 4 - Transferência%n 5 - Sair");
						char response2 = sc.next().charAt(0);
						if(response2 == '1') {
							account = new Account(number, user);
							System.out.println();
							System.out.print("Digite o valor do depósito: ");
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
								System.out.println("Você não tem saldo suficiente para completar essa ação.");
							}else {
							account.withdraw(withdrawValue);
							System.out.println("Dados da conta atualizados: ");
							System.out.println(account);
							}

							
						}else if(response2 == '3') {
							account = new Account(number, user);
							System.out.printf("Olá %s, o seu saldo atual é de R$%.2f", user, account.getBalance());
						}else if(response2 == '4') {
							account = new Account(number, user);
							System.out.println("Digite o nome da conta que você deseja transferir: ");
							sc.nextLine();
							String accountTransfer = sc.nextLine();
							System.out.println("Digite o valor que deseja transferir: ");
							double accountTransferValue = sc.nextDouble();
							if(accountTransferValue > account.getBalance()) {
								System.out.println("Você não tem saldo suficiente para completar essa transação!");
							}else {
								System.out.printf("Você confirma a transferência para a conta de %s no valor de R$%.2f? (S/N)", accountTransfer, accountTransferValue);
								char responseTransfer = sc.next().charAt(0);
								
								if(responseTransfer == 's') {
									account = new Account(number, user);
									System.out.println("Transferência completa, imprimindo o comprovante...");
									System.out.println();
									System.out.printf("Barbosa S.A          Comprovante de pagamento%nPagamento realizado%n%nR$%.2f%nDados da operação%n%nNome: %s%nValor: %.2f", accountTransferValue, accountTransfer,accountTransferValue);
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
				System.out.println("Insira seus dados para iniciar a criação de conta!");
				System.out.println("Digite seu Email:");
				sc.nextLine();
				String userEmail = sc.nextLine();
				System.out.println("Digite seu cpf:");
				int cpf = sc.nextInt();
				System.out.println("Digite seu nome:");
				sc.nextLine();
				String userName = sc.nextLine();
				System.out.printf("Escolha uma senha: %nA senha deve conter no mínimo uma letra maiúscula, uma minúscula, um caractere especial e um número");
				String userPassword = sc.nextLine();
				System.out.println("Validando informações...");   
		        if (ValidaSenha.PASSWORD_PATTERN.matcher(userPassword).matches()) {
	                System.out.print("A senha é válida.");
	            } else {
	                System.out.print("A senha não é válida. Certifique-se de seguir as regras.");
	            }
		        
		        System.out.printf("%nOlá %s, você confirma os dados: %n Nome: %s, CPF: %s, Email: %s (S/N)", userName, userName, cpf, userEmail);
		        char response3 = sc.next().charAt(0);
		        if(response3 == 's') {
		        	System.out.print("Digite o número da conta: ");
					int number = sc.nextInt();
					System.out.print("Digite seu nome: ");
					sc.nextLine();
					String user = sc.nextLine();
					System.out.print("Gostaria de fazer algum depósito inicial (s/n)?");
					char response = sc.next().charAt(0);

					if (response == 's') {
						System.out.print("Digite o valor de depósito inicial: ");
						double initialDeposit = sc.nextDouble();
						account = new Account(number, user, initialDeposit);
					} else {
						account = new Account(number, user);
					}

					System.out.println();
					System.out.println("Dados da conta: ");
					System.out.println(account);

					System.out.println();
					System.out.print("Digite o valor do depósito: ");
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