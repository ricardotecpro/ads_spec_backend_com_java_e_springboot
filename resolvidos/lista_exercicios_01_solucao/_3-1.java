// Classe Numero com um atributo inteiro
class Numero {
    private int valor; // Atributo encapsulado

    // Construtor
    public Numero(int valorInicial) {
        this.valor = valorInicial;
    }

    // Método para obter o valor (getter)
    public int getValor() {
        return valor;
    }

    // Método para definir o valor (setter)
    public void setValor(int novoValor) {
        this.valor = novoValor;
    }

    // Método para imprimir o valor do atributo
    public void imprimirValor() {
        System.out.println("Valor do atributo no objeto: " + this.valor);
    }
}

// Classe principal para demonstrar a manipulação
class ManipulaNumero {
    public static void main(String[] args) {
        System.out.println("--- Manipulando Dados de um Objeto ---");

        // 1. Crie uma instância (objeto) da classe Numero.
        Numero meuNumero = new Numero(0); // Inicializa com 0

        // 2. Atribua um valor ao atributo do objeto.
        // Usando o método setter para manter o encapsulamento
        meuNumero.setValor(42);

        // 3. Crie um método na classe Numero que imprima o valor do atributo. Chame este método.
        meuNumero.imprimirValor(); // Chama o método da classe Numero

        // 4. Simular "endereço de memória"
        // hashCode() pode ser sobrescrito, então System.identityHashCode() é mais próximo
        // do conceito de um identificador único do objeto na memória (não o endereço real).
        System.out.println("hashCode() do objeto: " + meuNumero.hashCode());
        System.out.println("System.identityHashCode() do objeto: " + System.identityHashCode(meuNumero));
        // A representação String padrão também inclui o hashCode em hexadecimal:
        System.out.println("Representação String padrão do objeto: " + meuNumero.toString());


        // Demonstração adicional: Acessando o valor com o getter
        System.out.println("Valor acessado via getValor(): " + meuNumero.getValor());

        System.out.println("--- Fim da Manipulação ---");
    }
}
