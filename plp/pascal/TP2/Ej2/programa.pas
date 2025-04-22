{
    2) Escriba un programa en Pascal que lea dos números enteros por teclado y calcule
    e imprima la suma y la resta de ambos números utilizando dos funciones.Además
    que calcule e imprima el producto y la división utilizando dos procedimientos
}

program ejercicio2;

    VAR 
        a, b, suma, resta: integer;

    function Sumar(a, b: integer):integer;
    begin
        Sumar := a + b; 
    end;

    function Restar(a, b: integer):integer;
    begin
        Restar := a - b;
    end;

    procedure Producto(a, b: integer);
    begin
        writeln(a*b);
    end;

    procedure Division(a, b: integer);
    begin
        writeln(a/b);
    end;

    begin
    
        writeln('Ingrese el primer numero');
        readln(a);
        
        writeln('Ingrese el segundo numero');
        readln(b);

        suma := Sumar(a, b);
        writeln(suma);

        resta := Restar(a, b);
        writeln(resta);

        Producto(a, b);

        Division(a, b);


    end.