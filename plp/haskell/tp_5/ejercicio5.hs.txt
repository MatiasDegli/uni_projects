{-
5. Definir las siguientes funciones:
 (a) Que devuelva el enesimo elemento de la serie de Fibonacci.
 (b) El factorial de un numero n
 (c) El valor de la siguiente sucesion:
-}

fibonacciNueve :: Int
fibonacciNueve = fib(9)

fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n-1) + fib (n-2)

factorial :: Int -> Int
factorial 0 = 1
factorial 1 = 1
factorial n | n > 1 = factorial (n-1)*n
            | otherwise = error "Numero negativo"

sucesion :: Int -> Int -> Double
sucesion x n = fromIntegral (sumatoriaElevada n 1) / fromIntegral (factorial x)

sumatoriaElevada :: Int -> Int -> Int
sumatoriaElevada n i | i > n = 0
                     | otherwise = i^n + sumatoriaElevada n (i+1)

main :: IO ()
main = do
    putStrLn "Ingrese un numero (x): "
    x <- readLn
    putStrLn "Ingrese otro numero (n): "
    n <- readLn
    putStrLn ("El resultado es: " ++ show (sucesion x n))