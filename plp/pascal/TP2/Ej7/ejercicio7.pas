{
    7. Cree un programa en Pascal que lea números enteros desde teclado hasta que se
    ingrese el valor 0. Por cada número ingresado, el programa deberá mostar el número
    y la suma acumulada de todos los números leídos hasta el momento.
}

program ejercicio7;

    var 
        suma:integer;

    function Sumatoria():integer;
        var
            n:integer;
    begin
        writeln('Ingrese el numero para sumar');
        readln(n);

        while n <> 0 do
        begin
            suma := suma + n;
            writeln('El ultimo numero sumado es ', n, ' y la sumatoria actual es ',suma);

            writeln('Ingrese el numero para sumar');
            readln(n);
        end;

        Sumatoria := suma;
    end;

    begin
        suma := 0;

        suma := Sumatoria();

        writeln('La sumatoria final da ', suma);
    end.