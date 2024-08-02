public class Main {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        boolean executar = true;
        while (executar) {
            cadastro.imprimirMenu();
            String opcao = cadastro.scanner.nextLine();
            switch (opcao) {
                case "1":
                    cadastro.adicionarProduto();
                    break;

                case "2":
                    cadastro.deletarProduto();
                    break;

                case "3":
                    cadastro.lerProduto();
                    break;

                case "4":
                    cadastro.adicionarFuncionario();
                    break;
                case "5":
                    cadastro.lerFuncionario();
                    break;
                case "6":
                    cadastro.deletarFuncionario();
                    break;
                case "7":
                    cadastro.scanner.close();
                    executar = false;
                    break;

                default:
                    System.out.println("Opcao invalida, escolha outra opcao.");
                    break;
            }
        }
    }
}

