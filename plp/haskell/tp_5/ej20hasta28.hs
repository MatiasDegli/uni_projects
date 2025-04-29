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

cadenaDigitos :: Int -> String
cadenaDigitos n


repeticion :: Int -> Int
repeticion n = n*10

sumatoria :: Int -> Int -> Int -> Int
sumatoria i n m 
    | i > 1 = sumatoria i-1 (n + repeticion m) (repeticion m)
    | otherwise = n
