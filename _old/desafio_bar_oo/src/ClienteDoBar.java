public class ClienteDoBar {
    private char sexo;
    private int qtdCervejas;
    private int qtdRefrigerantes;
    private int qtdEspetinhos;

    public ClienteDoBar(char sexo, int qtdCervejas, int qtdRefrigerantes, int qtdEspetinhos) {
        this.sexo = Character.toUpperCase(sexo);
        this.qtdCervejas = qtdCervejas;
        this.qtdRefrigerantes = qtdRefrigerantes;
        this.qtdEspetinhos = qtdEspetinhos;
    }

    public double calcularConsumo() {
        return qtdCervejas * 5.0 + qtdRefrigerantes * 3.0 + qtdEspetinhos * 7.0;
    }

    public double calcularCouvert() {
        if (calcularConsumo() > 30.0) {
            return 0.0;
        } else {
            return 4.0;
        }
    }

    public double calcularIngresso() {
        if (sexo == 'M') {
            return 10.0;
        } else {
            return 8.0;
        }
    }

    public double calcularTotal() {
        return calcularConsumo() + calcularCouvert() + calcularIngresso();
    }

    public void gerarRelatorio() {
        System.out.printf("RELATÓRIO:%n");
        System.out.printf("Consumo = R$ %.2f%n", calcularConsumo());

        if (calcularCouvert() == 0.0) {
            System.out.println("Isento de Couvert");
        } else {
            System.out.printf("Couvert = R$ %.2f%n", calcularCouvert());
        }

        System.out.printf("Ingresso = R$ %.2f%n", calcularIngresso());
        System.out.printf("Valor a pagar = R$ %.2f%n", calcularTotal());
    }
}
