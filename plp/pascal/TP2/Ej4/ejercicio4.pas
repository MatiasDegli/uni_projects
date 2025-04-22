{
    4. Escriba un programa en Pascal que lea un número real y determine si es positivo,
    negativo o igual a cero. Debe usar una función ’mayor’ implementada por usted. El
    programa debe mostrar el resultado en pantalla.
}

program signo;

    VAR 
        n: real;

    function Mayor(a, b: real):boolean;
    begin
        
        if a > b then 
            Mayor:=true
        else
            Mayor:=false
    end;

    begin
    
        writeln('Ingrese el numero real');
        readln(n);
        
        if n = 0 then
            writeln('El numero es igual a 0')
        else
            begin
                if Mayor(n, 0) then
                    writeln('El numero es positivo')
                else
                    writeln('El numero es negativo')
            end;            
        
    end.