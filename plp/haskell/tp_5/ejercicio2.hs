{-|
     2. Dar una de nicion de la funcion losCuatrosIguales con el siguiente tipo:
     Int-> Int-> Int-> Int-> Bool
     la cual da como resultado True si sus cuatros argumentos son iguales.
-}

losCuatroIguales :: Int -> Int -> Int -> Int -> Bool
losCuatroIguales a b c d
    | a==b && a==c && a==d = True
    | otherwise = False

main :: IO ()
main = do
    putStrLn "Ingrese un número: "
    a <- getLine
    putStrLn "Ingrese otro número: "
    b <- getLine
    putStrLn "Ingrese otro número: "
    c <- getLine
    putStrLn "Ingrese otro número: "
    d <- getLine
    putStrLn ("El resultado de la comparacion es: " ++ show (losCuatroIguales (read a) (read b) (read c) (read d)))
    