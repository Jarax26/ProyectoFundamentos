public class Bicho {
    private int salud;
    private String nombre;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getNombre() {
        return nombre;
    }

    public void bala() {
        this.setSalud(this.getSalud() - 5);
        this.setNombre(this.getId() + this.getSalud());
    }

    public void nuevoNombre(){
        this.setNombre(this.getId() + this.getSalud());
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void dispararBala(int pos) {
        if (pos <= 2) {
            if (Principal.bichos[0][pos - 1] == null) {
                System.out.println("No hay ningún bicho al cual disparar.");
            } else {
                Principal.bichos[0][pos - 1].bala();
            }
        }
        else {
            if (Principal.bichos[1][pos - 3] == null) {
                System.out.println("No hay ningún bicho al cual disparar.");
            } else {
                Principal.bichos[1][pos - 3].bala();
            }
        }
    }

    public static void vivos(Bicho[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] != null ) {
                    if (b[i][j].getSalud() <= 0) {
                        b[i][j] = null;
                        Principal.cantidad--;
                    }
                }
            }
        }
    }

    public static void bombaAtomica(Bicho[][] b, int p) {
        if (p < 2) {
            if (b[0][p] != null) {
                b[0][p].setSalud(0);
            }
        }
        else {
            if (b[1][p - 2] != null) {
                b[1][p - 2].setSalud(0);
            }
        }
    }

    public static void mutante(Bicho[][] b) {
        int men = 0;
        Bicho posmen = null;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] != null) {
                    men = b[i][j].getSalud();
                    posmen = b[i][j];
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] == null) {
                    break;
                }
                else if (b[i][j].getSalud() < men) {
                    posmen = b[i][j];
                }
            }
        }
        posmen.setSalud(posmen.getSalud() * 2);
        posmen.nuevoNombre();
    }

}
