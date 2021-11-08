import java.util.Random;
public class Principal {
    public static void main(String[] args) {
        Random ran = new Random();
        Bicho[][] bichos = new Bicho[2][2];
        int cantidad = 1 + ran.nextInt(4);
        System.out.println("Cant " + cantidad);
        int cont = 0;
        for (int i = 0; i < cantidad; i++) {
            int tipoBicho;
            tipoBicho = 1 + ran.nextInt(2);
            System.out.println("tipo " + tipoBicho);
            if (tipoBicho == 1) {
                Bicho bicho = new BichoNormal();
                if (cont < 2) {
                    bichos[0][cont] = bicho;
                    cont++;
                }
                else {
                    bichos[1][cont - 2] = bicho;
                    cont++;
                }
            }
            else {
                Bicho bicho = new BichoAlien();
                if (cont < 2) {
                    bichos[0][cont] = bicho;
                    cont++;
                }
                else {
                    bichos[1][cont - 2] = bicho;
                    cont++;
                }
            }
        }

        String[] nombres = new String[4];
        nombres[0] = "       ";
        nombres[1] = "       ";
        nombres[2] = "       ";
        nombres[3] = "       ";

        for (int i = 0; i < cantidad; i++) {
            if (i < 2) {
                nombres[i] = bichos[0][i].getNombre();
            }
            else {
                nombres[i] = bichos[1][i - 2].getNombre();
            }
        }


        System.out.println("---------------------");
        System.out.println("| " + nombres[0] + " | " + nombres[1] + " | ");
        System.out.println("---------------------");
        System.out.println("| " + nombres[2] + " | " + nombres[3] + " | ");
        System.out.println("---------------------");


    }
}
