module Tipos where
import Data.List ( sort )
type Datos = String
type Etiqueta = String
type Nombre = String

insertar :: Ord a => a -> [a] -> [a]
insertar a b = sort (b ++ [a])