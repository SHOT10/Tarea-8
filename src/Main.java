import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operacion[] operaciones = new Operacion[10];
        int contador = 0;

        while (contador < 10) {
            System.out.println("\nCalculadora Geométrica");
            System.out.println("Elija una figura:");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("6. Potencia");
            System.out.println("0. Salir del programa");
            System.out.print("Ingrese el número de tu elección: ");

            int opcion = scanner.nextInt();
            if (opcion == 0) {
                break;
            }

            Operacion operacion = null;
            switch (opcion) {
                case 1:
                    operacion = new Circulo();
                    break;
                case 2:
                    operacion = new Cuadrado();
                    break;
                case 3:
                    operacion = new Triangulo();
                    break;
                case 4:
                    operacion = new Rectangulo();
                    break;
                case 5:
                    operacion = new Pentagono();
                    break;
                case 6:
                    operacion = new Potencia();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            if (operacion != null) {
                double resultado = operacion.calcular();
                operaciones[contador] = operacion;
                contador++;
                System.out.println("Resultado: " + resultado);
            }
        }

        System.out.println("Resultados almacenados:");
        for (int i = 0; i < contador; i++) {
            System.out.println("Operación " + (i + 1) + ": " + operaciones[i]);
        }
    }
}

interface Operacion {
    double calcular();
}

abstract class Figura implements Operacion {
    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class Circulo extends Figura {
    private double radio;
    private Scanner scanner = new Scanner(System.in);

    public Circulo() {
        super("Círculo");
    }

    @Override
    public double calcular() {
        System.out.print("Seleccione la operación (1. Área, 2. Perímetro): ");
        int operacion = scanner.nextInt();
        if (operacion == 1) {
            System.out.print("Ingresa el radio del círculo: ");
            radio = scanner.nextDouble();
            return Math.PI * Math.pow(radio, 2);
        } else if (operacion == 2) {
            System.out.print("Ingresa el diámetro del círculo: ");
            double diametro = scanner.nextDouble();
            return Math.PI * diametro;
        } else {
            System.out.println("Operación no válida.");
            return 0;
        }
    }
}

class Cuadrado extends Figura {
    private double lado;
    private Scanner scanner = new Scanner(System.in);

    public Cuadrado() {
        super("Cuadrado");
    }

    @Override
    public double calcular() {
        System.out.print("Seleccione la operación (1. Área, 2. Perímetro): ");
        int operacion = scanner.nextInt();
        if (operacion == 1) {
            System.out.print("Ingresa la longitud del lado del cuadrado: ");
            lado = scanner.nextDouble();
            return Math.pow(lado, 2);
        } else if (operacion == 2) {
            System.out.print("Ingresa la longitud de un lado del cuadrado: ");
            lado = scanner.nextDouble();
            return 4 * lado;
        } else {
            System.out.println("Operación no válida.");
            return 0;
        }
    }
}

class Triangulo extends Figura {
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private double lado3;
    private Scanner scanner = new Scanner(System.in);

    public Triangulo() {
        super("Triángulo");
    }

    @Override
    public double calcular() {
        System.out.print("Seleccione la operación (1. Área, 2. Perímetro): ");
        int operacion = scanner.nextInt();
        if (operacion == 1) {
            System.out.print("Ingresa la base del triángulo: ");
            base = scanner.nextDouble();
            System.out.print("Ingresa la altura del triángulo: ");
            altura = scanner.nextDouble();
            return 0.5 * base * altura;
        } else if (operacion == 2) {
            System.out.print("Ingresa la longitud de los tres lados del triángulo (separados por un espacio): ");
            lado1 = scanner.nextDouble();
            lado2 = scanner.nextDouble();
            lado3 = scanner.nextDouble();
            return lado1 + lado2 + lado3;
        } else {
            System.out.println("Operación no válida.");
            return 0;
        }
    }
}

class Rectangulo extends Figura {
    private double base;
    private double altura;
    private Scanner scanner = new Scanner(System.in);

    public Rectangulo() {
        super("Rectángulo");
    }

    @Override
    public double calcular() {
        System.out.print("Seleccione la operación (1. Área, 2. Perímetro): ");
        int operacion = scanner.nextInt();
        if (operacion == 1) {
            System.out.print("Ingresa la base del rectángulo: ");
            base = scanner.nextDouble();
            System.out.print("Ingresa la altura del rectángulo: ");
            altura = scanner.nextDouble();
            return base * altura;
        } else if (operacion == 2) {
            System.out.print("Ingresa la longitud y el ancho del rectángulo (separados por un espacio): ");
            double longitud = scanner.nextDouble();
            double ancho = scanner.nextDouble();
            return 2 * (longitud + ancho);
        } else {
            System.out.println("Operación no válida.");
            return 0;
        }
    }
}

class Pentagono extends Figura {
    private double lado;
    private Scanner scanner = new Scanner(System.in);

    public Pentagono() {
        super("Pentágono");
    }

    @Override
    public double calcular() {
        System.out.print("Seleccione la operación (1. Área, 2. Perímetro): ");
        int operacion = scanner.nextInt();
        if (operacion == 1) {
            System.out.print("Ingresa la longitud de un lado del pentágono: ");
            lado = scanner.nextDouble();
            return 0.5 * lado * lado * (2.2361 + 5) * 0.2;
        } else if (operacion == 2) {
            System.out.print("Ingresa la longitud de un lado del pentágono: ");
            lado = scanner.nextDouble();
            return 5 * lado;
        } else {
            System.out.println("Operación no válida.");
            return 0;
        }
    }
}

class Potencia implements Operacion {
    private double base;
    private int exponente;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public double calcular() {
        System.out.print("Seleccione la operación (6. Potencia): ");
        int operacion = scanner.nextInt();
        if (operacion == 6) {
            System.out.print("Ingresa la base: ");
            base = scanner.nextDouble();
            System.out.print("Ingresa el exponente: ");
            exponente = scanner.nextInt();
            return potencia(base, exponente);
        } else {
            System.out.println("Operación no válida.");
            return 0;
        }
    }

    private double potencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente > 0) {
            return base * potencia(base, exponente - 1);
        } else {
            return 1 / (base * potencia(base, -exponente - 1));
        }
    }
}

