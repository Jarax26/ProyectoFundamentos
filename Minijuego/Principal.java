import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static String[] nombres = new String[4];
    public static Bicho[][] bichos = new Bicho[2][2];
    public static String[] frasesAbuela = new String[6];

    public static void main(String[] args) {
        frasesAbuela[0] = "La venganza nunca es buena, mata el alma y el envenena.";
        frasesAbuela[1] = "Mala hierba nunca muere. ";
        frasesAbuela[2] = "El necio es atrevido, el sabio comedido.";
        frasesAbuela[3] = "Palo que nace torcido nunca su rama endereza";
        frasesAbuela[4] = "Pim pam pum bocadillo de atún";
        frasesAbuela[5] = "Perro que ladra no muerde ";

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese 1 para iniciar el juego");
        int num = sc.nextInt();
        if (num == 1) {
            Random ran = new Random();
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
                    } else {
                        bichos[1][cont - 2] = bicho;
                        cont++;
                    }
                } else {
                    Bicho bicho = new BichoAlien();
                    if (cont < 2) {
                        bichos[0][cont] = bicho;
                        cont++;
                    } else {
                        bichos[1][cont - 2] = bicho;
                        cont++;
                    }
                }
            }

            for (int i = 0; i < bichos.length; i++) {
                for (int j = 0; j < bichos[i].length; j++) {
                    if (bichos[i][j] != null) {
                        if (bichos[i][j].getSalud() <= 0) {
                            bichos[i][j] = null;
                        }
                    }
                }
            }

            nombres[0] = "       ";
            nombres[1] = "       ";
            nombres[2] = "       ";
            nombres[3] = "       ";

            while (true) {
                for (int i = 0; i < cantidad; i++) {
                    if (i < 2) {
                        if (bichos[0][i] == null) {
                            nombres[i] = "       ";
                        }else {
                            nombres[i] = bichos[0][i].getNombre();
                        }
                    } else {
                        if (bichos[1][i - 2] == null) {
                            nombres[i] = "       ";
                        } else {
                            nombres[i] = bichos[1][i - 2].getNombre();
                        }
                    }
                }

                menu();


                System.out.println("Ingrese 1 para disparar a un bicho.");
                System.out.println("Ingrese 2 para lanzar una bomba atómica.");
                System.out.println("Ingrese 3 para activar bicho mutante.");
                System.out.println("Ingrese 4 para mostrar la frase de la abuela.");

                int opcion = sc.nextInt();


                if (opcion == 1) {
                    System.out.println("Ingrese casilla a la que quiere disparar. ");
                    int cas = sc.nextInt();
                    System.out.println("Se ha disparado al bicho en la posición " + cas);
                    Bicho.dispararBala(cas);
                    Bicho.vivos(bichos);
                } else if (opcion == 2) {
                    int pos = ran.nextInt(4);
                    System.out.println("La bomba ha sido lanzada en la posicion " + (pos + 1));
                    Bicho.bombaAtomica(bichos, pos);
                    Bicho.vivos(bichos);
                }
                else if (opcion == 3) {
                    Bicho.mutante(bichos);
                    Bicho.vivos(bichos);
                    System.out.println(bichos[0][0].getSalud());
                }
                else if (opcion == 4) {
                    System.out.println("-Abuela: ");
                    int n = ran.nextInt(6);
                    fraseAbuela(n);
                }
            }

        }

    }

    public static void menu() {
        System.out.println("---------------------");
        System.out.println("| " + nombres[0] + " | " + nombres[1] + " | ");
        System.out.println("---------------------");
        System.out.println("| " + nombres[2] + " | " + nombres[3] + " | ");
        System.out.println("---------------------");
    }

    public static void fraseAbuela(int n ) {
        System.out.println(frasesAbuela[n]);
    }


}
