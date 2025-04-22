{
    8. Realice un programa que imprima en pantalla los primeros 15 números pares, ini
    ciando desde un número ingresado por el usuario.
}

program ejercicio8;

    var
        par:integer;

    function EsPar(par:integer):boolean;
    begin
        EsPar := (par mod 2) = 0;
    end;

    procedure PrimerosPares(par:integer);
        var
            i:integer;

        begin
            writeln('El primer par es ', par);
            for i := 1 to 14 do
            begin
                par := par+2;
                writeln('El siguiente par es ', par);             
            end;
    end;

    begin
        repeat
            writeln('Ingrese un numero par');
            readln(par);
        until (EsPar(par));
        
        PrimerosPares(par);

    end.