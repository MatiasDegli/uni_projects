{
    3. Desarrolle un programa que calcule el área y el perímetro de un rectángulo. Para
    ello los valores de base y altura deben ser ingresados por teclado. Debe contar con
    una función que reciba la base y la altura para calcular el área y un procedimiento
    para calcular el perímetro
}

program ejercicio3; 

    VAR
        b, h, area: integer;
    
    function AreaRectangulo(b, h: integer):integer;
    begin
        AreaRectangulo := b*h;
    end;

    procedure Perimetro(b, h: integer);
    begin
        writeln('El perimetro del rectangulo es ', b*2 + h*2);
    end;

    begin
        writeln('Ingrese la base del rectangulo');
        readln(b);
        
        writeln('Ingrese la altura del rectangulo');
        readln(h);
        
        area := AreaRectangulo(b, h);
        writeln('El area del rectangulo es ', area);
        
        Perimetro(b, h);
    end.

