import java.util.Scanner;
public class Principal
{
    public static void main(String[]args)
    {
        Principal.mostrarMenu();
    }
    
    public static void mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("- Ingrese 0 si desea finalizar la ejecución del programa." + "\n"
            + "- Ingrese 1 para crear un nuevo vehiculo con su modelo, marca, valor comercial y color." + "\n" 
            + "- Ingrese 2 para mostrar los vehiculos almacenados." + "\n"
            + "- Ingrese 3 para mostrar la cantidad de vehiculos creados." + "\n"
            + "- Ingrese 4 para mostrar la informacion de vehiculos verdes." + "\n"
            + "- Ingrese 5 para mostrar los modelos vehiculos entre 2000 y 2021." + "\n"
            + "- Ingrese 6 para crear un nuevo sensor con su tipo y su valor." + "\n"
            + "- Ingrese 7 para mostrar los sensores almacenados." + "\n" 
            + "- Ingrese 8 para mostrar la cantidad de sensores creados." + "\n"
            + "- Ingrese 9 para mostrar los sensores de tipo 'temperatura'." + "\n"
            + "- Ingrese 666 para mostrar los sensores tipo 'temperatura' ordenados por valor.");
            int num = sc.nextInt();
            if(num == 0)
            {
                break;
            }
            switch(num){
                
                case 1:
            
                    while(true)
                    {
                        if(Vehiculo.posAnadir == 10)
                        {
                            System.out.println("Error, base de datos llena");
                            break;
                        }
                        System.out.println("Ingrese el modelo del vehiculo: ");
                        int modelo = sc.nextInt();
                        System.out.println("Ingrese la marca del vehiculo: ");
                        String marca = sc.next();
                        System.out.println("Ingrese el valor comercial del vehiculo: ");
                        double valorComercial = sc.nextDouble();
                        System.out.println("¿Desea ingresar el color del vehiculo?"+ "\n"
                        + "- Ingrese 'Si' para ingresar un color."+"\n"
                        + "- Ingrese 'No' y el color por defecto será verde.");
                        String siNo = sc.next();
                        if(siNo.equals("Si"))
                        {
                            System.out.println("Ingrese el color del vehiculo: ");
                            String color = sc.next();
                            Vehiculo.vehiculos[Vehiculo.posAnadir] = new Vehiculo(modelo, marca, valorComercial, color);
                        }else if(siNo.equals("No"))
                        {
                            Vehiculo.vehiculos[Vehiculo.posAnadir] = new Vehiculo(modelo, marca, valorComercial);
                        }
                        Vehiculo.posAnadir++;
                        System.out.println("¿Desea ingresar otro vehiculo?"+ "\n"
                        + "- Ingrese 'Si' para crear un nuevo vehiculo."+"\n"
                        + "- Ingrese 'No' para volver al menú.");
                        String siNo2 = sc.next();
                        if(siNo2.equals("Si"))
                        {
                            continue;
                        }else if(siNo2.equals("No"))
                        {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 3:
                    System.out.println(Vehiculo.cantidadVehiculos());
                    break;
                case 4:
                    for(int i = 0; i<Vehiculo.posAnadir; i++)
                    {
                        if(Vehiculo.vehiculos[i].getColor().equals("verde"))
                        {
                            System.out.println(Vehiculo.vehiculos[i].toString());
                        }
                    }
                    break;
                case 5:
                    for(int i = 0; i<Vehiculo.posAnadir; i++)
                    {
                        if((Vehiculo.vehiculos[i].getModelo()>=2000)&&(Vehiculo.vehiculos[i].getModelo()<=2021))
                        {
                            System.out.println(Vehiculo.vehiculos[i].toString());
                        }
                    }
                    break;
                case 6:
                    while(true){
                        if(Sensor.posAnadir == 8)
                        {
                            System.out.println("Error, base de datos llena");
                            break;
                        }
                        System.out.println("Ingrese el tipo de sensor: ");
                        String tipo = sc.next();
                        System.out.println("Ingrese el valor del sensor: ");
                        double valor = sc.nextDouble();
                        Sensor.sensores[Sensor.posAnadir] = new Sensor(tipo, valor);
                        Sensor.posAnadir++;
                        System.out.println("¿Desea ingresar otro sensor?"+ "\n"
                        + "- Ingrese 'Si' para crear un nuevo sensor."+"\n"
                        + "- Ingrese 'No' para volver al menú.");
                        String siNo = sc.next();
                        if(siNo.equals("Si"))
                        {
                            continue;
                        }else if(siNo.equals("No"))
                        {
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println(Sensor.toStringSensores());
                    break;
                case 8:
                    System.out.println(Sensor.cantidadSensores());
                    break;
                case 9:
                    for(int i = 0; i<Sensor.posAnadir; i++)
                    {
                        if(Sensor.sensores[i].getTipo().equals("temperatura"))
                        {
                            System.out.println(Sensor.sensores[i].toString());
                        }
                    }
                    break;
                case 666:
                    System.out.println(Sensor.ordenarValores(Sensor.sensores).toString());
                    break;
            }
        }
        sc.close();
    }
}
