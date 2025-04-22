{
    5. Escribir un programa que determine si un número N es divisible por otro número M.
}

program ejercicio5;

    VAR 
        n, m: integer;

    function EsDivisible(n,m:integer):boolean;
    begin
        if (n mod m) = 0 then
            EsDivisible:=true
        else
            EsDivisible:=false
    end;

    begin
        writeln('Ingrese el dividendo');
        readln(n);
        writeln('Ingrese el divisor');
        readln(m);
        
        if EsDivisible(n,m) then
            writeln('El numero ',n, ' es divisible por ',m)
        else
            writeln('El numero ',n, ' no es divisible por ',m)
    end.