public class Paralelepipedo {
    public float altura;
    public float largura;
    public float comprimento;

    // Método para calcular o volume
    public float calcularVolume() {
        return altura * largura * comprimento;
    }

    // Método para comparar volumes entre dois paralelepípedos
    public static void compararVolumes(Paralelepipedo p1, Paralelepipedo p2, Paralelepipedo p3) {
        float volumeP1 = p1.calcularVolume();
        float volumeP2 = p2.calcularVolume();
        float volumeP3 = p3.calcularVolume();
        
        // montar logica para tres objetos

        if (volumeP1 > volumeP2) {
            System.out.println("O volume do primeiro paralelepípedo é maior.");
        } else if (volumeP1 < volumeP2) {
            System.out.println("O volume do segundo paralelepípedo é maior.");
        } else {
            System.out.println("Os volumes dos dois paralelepípedos são iguais.");
        }
    }
}
