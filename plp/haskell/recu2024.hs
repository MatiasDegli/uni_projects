piAproxNewton :: Int -> (Float, Float)
piAproxNewton n = (pi, pi -  (aproximacion n))

aproximacion :: Int -> Float
aproximacion n = parteUno - (3/4) * (sumatoria 0 n 0)

factorial :: Int -> Int
factorial x
    | x == 0 = 1
    | otherwise = x * factorial (x - 1)

combinacion :: Int -> Int -> Float
combinacion p j = fromIntegral (factorial p) / fromIntegral ((factorial j)*(factorial p-j))

parteUno :: Float
parteUno = (3 * (sqrt 3))/4 + 2

parteDos :: Int -> Float
parteDos j = (combinacion (2*j) j) / fromIntegral ((j+1)*(2*j+5)*(16^j))

sumatoria :: Int -> Int -> Float -> Float
sumatoria j n a
    | j > n = a
    | otherwise = sumatoria (j+1) n (a + parteDos j)

main :: IO ()
main = do
    putStrLn "Ingrese N"
    n <- readLn
    putStrLn ("piAproxNewton: " ++ show (piAproxNewton n))
