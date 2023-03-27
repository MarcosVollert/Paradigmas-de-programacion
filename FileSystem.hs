module FileSystem ( FileSystem, nuevoF, etiquetasF, temasF, agregarF,)
where
import Tipos
import Tema

data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

nuevoF :: FileSystem
nuevoF = FS [] []

etiquetasF :: FileSystem -> [Etiqueta]
etiquetasF (FS eti _) = eti

temasF :: FileSystem -> [Tema]
temasF (FS _ temas) = temas

agregarF :: Tema -> FileSystem -> FileSystem
agregarF tema (FS eti temas)= FS(etiquetasT tema ++ eti)(tema : temas)

filtrarF :: Etiqueta -> FileSystem -> [Tema]
filtrarF eti (FS etis temas) = [tema | tema <- temas, elem eti (etiquetasT tema)]

