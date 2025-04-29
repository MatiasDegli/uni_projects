{-
ejercicio 20
-}

maxOcurr :: Int -> Int -> (Int,Int)
maxOcurr a b
    | a > b = (a,1)
    | a == b = (a,2)
    | otherwise = (b,1)

maxOcurr3 :: Int -> Int -> Int -> (Int, Int)
maxOcurr3 a b c = (mayor, cantidad)
    where
        (mayorAB, _) = maxOcurr a b
        (mayor, _) = maxOcurr mayorAB c
        cantidad = length (filter (== mayor) [a, b, c])

{-
ejercicio 24
-}

potencia10 :: Int -> Int -> Int
potencia10 n i
    | 10^i <= n = potencia10 n (i+1)
    | otherwise = (i-1)

cadenaDigitos :: Int -> String -> String
cadenaDigitos n c
    | n > 0 = cadenaDigitos (n `mod` divisor) (c ++ show (sumatoria i i 0) ++ "\n")
    | otherwise = c
  where
    divisor = 10 ^ potencia10 n 0
    i = n `div` divisor

sumatoria :: Int -> Int -> Int -> Int
sumatoria i m n 
    | i >= 1 = sumatoria (i-1) (m*10) (n + m)
    | otherwise = n

main :: IO ()
main = do
    putStrLn "Ingrese el numero"
    n <- readLn
    putStrLn (cadenaDigitos n "")