imc :: Double -> Double -> Double
imc p h = p / (h^2)

categoria :: Double -> String
categoria n
    | n < 18.5 = "Muy Bajo"
    | n >= 18.5 && n < 25 = "Normal"
    | n >= 25 && n < 30 = "Alta"
    | otherwise = "Muy Alto"

main :: IO ()
main = do
    putStrLn "Ingrese peso"
    p <- readLn
    putStrLn "Ingrese altura"
    h <- readLn
    print(categoria (imc p h))