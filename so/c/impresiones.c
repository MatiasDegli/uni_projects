/*10.c ¿Cuál es el resultado del siguiente fragmento de código? Anticipe su 
    respuesta en base a lo dicho en esta unidad y luego confírmela mediante 
    un programa.

    printf("%d\n", 20/3);
    printf("%f\n", 20/3);
    printf("%f\n", 20/3.);
    printf("%d\n", 10%3);
    printf("%d\n", 3.1416);
    printf("%f\n", (double)20/3);
    printf("%f\n", (int)3.1416);
    printf("%d\n", (int)3.1416);
*/

#include <stdio.h> // Libreria para impresiones por pantalla

int main()
{
    printf("%d\n", 20/3); // 6 ya que trunca 6.33...
    printf("%f\n", 20/3); // 0.000000 falta castear a double
    printf("%f\n", 20/3.); // 6.666667 porque 3. es double
    printf("%d\n", 10%3); // 1 es el resto
    printf("%d\n", 3.1416); // 776530087 imprime basura ya que %d espera un int pero recibe un double
    printf("%f\n", (double)20/3); // 6.666667 
    printf("%f\n", (int)3.1416); // 0.000000 error de tipo
    printf("%d\n", (int)3.1416); // 3 ya que lo trunca
}