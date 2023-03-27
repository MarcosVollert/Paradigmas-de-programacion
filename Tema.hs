module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT ) where
import Tipos

data Tema = Tem Nombre [ Etiqueta ] Datos deriving (Eq, Show, Ord)

nuevoT :: Nombre -> Datos -> Tema
nuevoT nom dat = Tem nom [] dat

nombreT :: Tema -> Nombre
nombreT (Tem nom _ _) = nom

datosT :: Tema -> Datos
datosT (Tem _ _ dat) = dat

etiquetasT :: Tema -> [Etiqueta]
etiquetasT (Tem _ eti _ ) = eti

agregarT :: Etiqueta -> Tema -> Tema
agregarT eti (Tem nom et dat) = Tem nom (et ++ [eti]) dat

aplicaT :: Etiqueta -> Tema -> Bool
aplicaT eti (Tem _ et _) = elem eti et


t1 = Tem "nombre" ["etiquera1", "etiqueta2"] "datos"

test = [
    nuevoT "nombre" "datos" == Tem "nombre" [] "datos",
    nombreT t1 == "nombre",
    datosT t1 == "datos",
    etiquetasT t1 == ["etiquera1", "etiqueta2"],
    agregarT "etiqueta3" t1 == Tem "nombre" ["etiquera1", "etiqueta2", "etiqueta3"] "datos",
    aplicaT "etiqueta2" t1 == True
       ]
