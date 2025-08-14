import java.util.Scanner;

// Classe ValorContainer com um atributo inteiro 'valor'
class ValorContainer {
    public int valor; // Deixado público para simplicidade do exercício, idealmente seria privado com getters/setters

    // Construtor
    public ValorContainer(int valorInicial) {
        this.valor = valorInicial;
    }

    // Método para exibir o valor (apenas para facilitar)
    public void exibirValor(String nomeObjeto) {
        System.out.println(nomeObjeto + ".valor = " + this.valor);
    }
}

// Classe principal para demonstrar a troca
class TrocaValoresObjetos {

    // Método estático para trocar os atributos 'valor' de dois objetos ValorContainer
    public static void trocarValores(ValorContainer refA, ValorContainer refB) {
        System.out.println("\nDentro do método trocarValores():");
        refA.exibirValor("refA (antes da troca interna)");
        refB.exibirValor("refB (antes da troca interna)");

        int temp = refA.valor; // Armazena o valor de refA.valor temporariamente
        refA.valor = refB.valor; // Atribui o valor de refB.valor para refA.valor
        refB.valor = temp;       // Atribui o valor original de refA (armazenado em temp) para refB.valor

        refA.exibirValor("refA (depois da troca interna)");
        refB.exibirValor("refB (depois da troca interna)");
        System.out.println("Saindo do método trocarValores()...");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Trocando Valores entre Objetos (Simulado) ---");

        // Cria duas instâncias de ValorContainer
        System.out.print("Digite o valor inicial para objA: ");
        int valA = scanner.nextInt();
        ValorContainer objA = new ValorContainer(valA);

        System.out.print("Digite o valor inicial para objB: ");
        int valB = scanner.nextInt();
        ValorContainer objB = new ValorContainer(valB);

        // Imprime os valores iniciais
        System.out.println("\nValores antes da troca:");
        objA.exibirValor("objA");
        objB.exibirValor("objB");

        // Chama o método para trocar os valores
        // Em Java, os objetos são passados por valor da referência.
        // Isso significa que o método recebe uma cópia da referência,
        // mas essa cópia aponta para o mesmo objeto na memória.
        // Portanto, modificações nos atributos do objeto dentro do método
        // serão refletidas fora do método.
        trocarValores(objA, objB);

        // Imprime os valores após a troca
        System.out.println("\nValores após a chamada de trocarValores():");
        objA.exibirValor("objA");
        objB.exibirValor("objB");

        scanner.close();
        System.out.println("--- Fim da Demonstração de Troca ---");
    }
}
