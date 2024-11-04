import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("\n Olá, bem-vindo ao restaurante Tigrinho.");
        System.out.print("\n Digite seu nome: ");
        String nome = entrada.nextLine();

        String pedido = "";
        String bebida = "";
        int n;

        do {
            System.out.println("\n Selecione a opção que deseja:");
            System.out.println("1: Prato feito.");
            System.out.println("2: Marmita pequena.");
            System.out.println("3: Marmita média.");
            System.out.println("4: Marmita grande.");
            System.out.println("5: Bebida.");
            System.out.println("6: Pagamento.");
            System.out.println("0: Finalizar");
            n = entrada.nextInt();

            switch ( n ) {
                case 1:
                    pedido = Refeicao("Prato Feito", entrada);
                    break;
                case 2:
                    pedido = Refeicao("Marmita Pequena", entrada);
                    break;
                case 3:
                    pedido = Refeicao("Marmita Média", entrada);
                    break;
                case 4:
                    pedido = Refeicao("Marmita Grande", entrada);
                    break;
                case 5:
                    bebida = escolhaBebida(entrada);
                    break;
                case 6:
                    pagamento(entrada, pedido, bebida, nome);
                    break;
                case 0:
                    System.out.println("Obrigado por visitar o restaurante Trigrinho!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (n != 0);

        entrada.close();
    }

    private static String Refeicao(String tipoRefeicao, Scanner entrada) {
        System.out.println("\n-----------------" + tipoRefeicao + "-----------------\n");
        System.out.println("Escolha o cardápio:");
        System.out.println("1: Arroz, feijão, salada, bife grelhado.");
        System.out.println("2: Arroz, feijão, salada, frango assado.");
        System.out.println("3: Arroz, feijão, salada, carne cozida.");
        int rf = entrada.nextInt();

        switch (rf) {
            case 1:
                return "Arroz, feijão, salada, bife grelhado";
            case 2:
                return "Arroz, feijão, salada, frango assado";
            case 3:
                return "Arroz, feijão, salada, carne cozida";
            default:
                System.out.println("Opção inválida.");
                return "";
        }
    }

    private static String escolhaBebida(Scanner entrada) {
        System.out.println("\n-----------------BEBIDAS-----------------\n");
        System.out.println("1: Refrigerante.");
        System.out.println("2: Suco.");
        int bd = entrada.nextInt();
        String bebidaEscolhida = "";

        switch (bd) {
            case 1:
                System.out.println("Opção (1): Coca cola.");
                System.out.println("Opção (2): Fanta uva.");
                System.out.println("Opção (3): Fanta laranja.");
                System.out.println("Opção (4): Guaraná.");
                int rf = entrada.nextInt();

                switch (rf) {
                    case 1:
                        bebidaEscolhida = "coca cola";
                        break;
                    case 2:
                        bebidaEscolhida = "fanta uva";
                        break;
                    case 3:
                        bebidaEscolhida = "fanta laranja";
                        break;
                    case 4:
                        bebidaEscolhida = "guaraná";
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                break;

            case 2:
                System.out.println("Opção (1): Suco de laranja.");
                System.out.println("Opção (2): Suco de uva.");
                System.out.println("Opção (3): Suco de abacaxi.");
                int suc = entrada.nextInt();

                switch (suc) {
                    case 1:
                        bebidaEscolhida = "suco de laranja";
                        break;
                    case 2:
                        bebidaEscolhida = "suco de uva";
                        break;
                    case 3:
                        bebidaEscolhida = "suco de abacaxi";
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                break;

            default:
                System.out.println("Opção inválida.");
                return "";
        }

        return bebidaEscolhida;
    }

    private static void pagamento(Scanner entrada, String pedido, String bebida, String nome) {
        System.out.println("\n-----------------PAGAMENTO-----------------\n");

        System.out.println(nome + " seu pedido foi, " + pedido + " , " + bebida + " .");

        entrada.nextLine();
        String pag;

        do {
            System.out.println("\n Escolha a forma de pagamento: Cartão ou Pix.");
            pag = entrada.nextLine();

            if (!pag.equalsIgnoreCase("Cartao") && !pag.equalsIgnoreCase("Pix")) {
                System.out.println("Forma de pagamento inválida. Tente novamente.");
            }

        } while (!pag.equalsIgnoreCase("Cartao") && !pag.equalsIgnoreCase("Pix"));

        if (pag.equalsIgnoreCase("Cartao")) {
            System.out.println("Débito ou crédito?");
            String tipoCartao = entrada.nextLine();
            System.out.println("Compra com cartão " + tipoCartao + " bem-sucedida.");
            System.out.println("Obrigado por visitar o restaurante Trigrinho!");
        } else {
            System.out.println("Chave Pix é CNPJ: XX.XXX.XXX/0001-XX");
            System.out.println("Pagamento via Pix bem-sucedido.");
            System.out.println("Obrigado por visitar o restaurante Trigrinho!");
        }

        System.exit(0);
    }
}
