tParcial :: Int -> Int -> String
tParcial  n

ecuacion :: Int -> Int -> Double
ecuacion x c = (fromIntegral (x^3 + 5*c)) / fromIntegral (x*2 + c-1)

sumatoria :: Int -> Int -> Int -> Double -> Double
sumatoria i k c n
    | i > k = n
    | otherwise = sumatoria (i+1) k c (n + ecuacion i c)

main :: IO ()
main = do
    putStrLn "Ingrese K"
    k <- readLn
    putStrLn "Ingrese C"
    c <- readLn
    putStrLn ("La sumatoria da: " ++ show (sumatoria 1 k c 0))
