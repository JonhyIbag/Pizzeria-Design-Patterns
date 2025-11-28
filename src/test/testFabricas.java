package test;

import java.util.Scanner;

import model.abst.Ingrediente;
import model.abst.IngredienteFabrica;
import model.pizza.fabricas.*;

public class testFabricas {
    public static void main(String[] args) {
        System.out.println("Pruebas de Fabricas de Ingredientes");
        int eleccionMenu=0;
        int eleccionIngrediente=0;
        IngredienteFabrica fabrica;
        Ingrediente ingrediente;

        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("\n\n\n------------------- Menu de Pruebas de Fabricas ------------------");
            System.out.println("\n\t 1. Probar Fabrica de Masas");
            System.out.println("\t 2. Probar Fabrica de Salsas");
            System.out.println("\t 3. Probar Fabrica de Quesos");
            System.out.println("\t 4. Probar Fabrica de Condimentos");
            System.out.println("\t 5. Probar Fabrica de Orillas");
            System.out.println("\t 6. Probar Fabrica de Otros Ingredientes");
            System.out.println("\t 7. Salir");
            eleccionMenu = scanner.nextInt();
            switch (eleccionMenu) {
                case 1:
                    System.out.println("\n\t 1. Crear Masa Americana");
                    System.out.println("\t 2. Crear Masa Napolitana");
                    System.out.println("\t 3. Crear Masa Romana");
                    System.out.println("\t 4. Regresar");
                    eleccionIngrediente = scanner.nextInt();
                    if (eleccionIngrediente==4) break;
                    else if (eleccionIngrediente<1 || eleccionIngrediente>3){
                        System.out.println("Opcion no valida");
                        break;
                    }
                    
                    fabrica = new MasaFabrica();
                    
                    ingrediente = fabrica.crearMasa(CrearMasa(eleccionIngrediente));
                    System.out.println(ingrediente.toString());
                    break;
                case 2:
                    System.out.println("\n\t 1. Crear Salsa de Tomate");
                    System.out.println("\t 2. Crear Salsa Blanca");
                    System.out.println("\t 3. Crear Salsa Barbacoa");
                    System.out.println("\t 4. Regresar");
                    eleccionIngrediente = scanner.nextInt();
                    if (eleccionIngrediente==4) break;
                    else if (eleccionIngrediente<1 || eleccionIngrediente>3){
                        System.out.println("Opcion no valida");
                        break;
                    }
                    
                    fabrica = new SalsaFabrica();
                    
                    ingrediente = fabrica.crearSalsa(CrearSalsa(eleccionIngrediente));
                    System.out.println(ingrediente.toString());
                    break;
                case 3:
                    System.out.println("\n\t 1. Crear Queso Mozzarella");
                    System.out.println("\t 2. Crear Queso Parmesano");
                    System.out.println("\t 3. Crear Queso Cheddar");
                    System.out.println("\t 4. Regresar");
                    eleccionIngrediente = scanner.nextInt();
                    if (eleccionIngrediente==4) break;
                    else if (eleccionIngrediente<1 || eleccionIngrediente>3){
                        System.out.println("Opcion no valida");
                        break;
                    }
                    
                    fabrica = new QuesoFabrica();
                    
                    ingrediente = fabrica.crearQueso(CrearQueso(eleccionIngrediente));
                    System.out.println(ingrediente.toString());
                    break;
                case 4:
                    System.out.println("\n\t 1. Crear Oregano");
                    System.out.println("\t 2. Crear Albahaca");
                    System.out.println("\t 3. Crear Romero");
                    System.out.println("\t 4. Regresar");
                    eleccionIngrediente = scanner.nextInt();
                    if (eleccionIngrediente==4) break;
                    else if (eleccionIngrediente<1 || eleccionIngrediente>3){
                        System.out.println("Opcion no valida");
                        break;
                    }
                    
                    fabrica = new CondimentoFabrica();
                    
                    ingrediente = fabrica.crearCondimento(CrearCondimento(eleccionIngrediente));
                    System.out.println(ingrediente.toString());
                    break;
                case 5:
                    System.out.println("\n\t 1. Crear Orilla Rellana de Queso");
                    System.out.println("\t 2. Crear Orilla Tradicional");
                    System.out.println("\t 3. Crear Orilla Crujiente");
                    System.out.println("\t 4. Regresar");
                    eleccionIngrediente = scanner.nextInt();
                    if (eleccionIngrediente==4) break;
                    else if (eleccionIngrediente<1 || eleccionIngrediente>3){
                        System.out.println("Opcion no valida");
                        break;
                    }
                    
                    fabrica = new OrillaFabrica();
                    
                    ingrediente = fabrica.crearOrilla(CrearOrilla(eleccionIngrediente));
                    System.out.println(ingrediente.toString());
                    break;
                case 6:
                    System.out.println("\n\t 1. Crear Champinones");
                    System.out.println("\t 2. Crear Pepperoni");
                    System.out.println("\t 3. Crear Pimientos   ");
                    System.out.println("\t 4. Regresar");
                    eleccionIngrediente = scanner.nextInt();
                    if (eleccionIngrediente==4) break;
                    else if (eleccionIngrediente<1 || eleccionIngrediente>3){
                        System.out.println("Opcion no valida");
                        break;
                    }
                    
                    fabrica = new ExtrasFabrica();
                    
                    ingrediente = fabrica.crearOtro(CrearExtras(eleccionIngrediente));
                    System.out.println(ingrediente.toString());
                    break;
                default:
                    break;
            }
        } while(eleccionMenu!=7);
        scanner.close();
    }

    private static String CrearMasa(int eleccionIngrediente) {
        switch (eleccionIngrediente) {
            case 1:
                return "Americana";
            case 2:
                return "Napolitana";
            case 3:
                return "Romana";
        }
        return null;
    }

    private static String CrearSalsa(int eleccionIngrediente) {
        switch (eleccionIngrediente) {
            case 1:
                return "Tomate";
            case 2:
                return "Blanca";
            case 3:
                return "Barbacoa";
        }
        return null;
    }

    private static String CrearQueso(int eleccionIngrediente) {
        switch (eleccionIngrediente) {
            case 1:
                return "Mozzarella";
            case 2:
                return "Parmesano";
            case 3:
                return "Cheddar";
        }
        return null;
    }

    private static String CrearCondimento(int eleccionIngrediente) {
        switch (eleccionIngrediente) {
            case 1:
                return "Oregano";
            case 2:
                return "Albahaca";
            case 3:
                return "Romero";
        }
        return null;
    }

    private static String CrearOrilla(int eleccionIngrediente) {
        switch (eleccionIngrediente) {
            case 1:
                return "RellenaQueso";
            case 2:
                return "Tradicional";
            case 3:
                return "Crujiente";
        }
        return null;
    }

    private static String CrearExtras(int eleccionIngrediente) {
        switch (eleccionIngrediente) {
            case 1:
                return "Champinones";
            case 2:
                return "Pepperoni";
            case 3:
                return "Pimientos";
        }
        return null;
    }
}
