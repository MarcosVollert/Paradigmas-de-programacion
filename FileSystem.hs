module FileSystem ( FileSystem, nuevoF, etiquetasF, temasF, agregarF,)
where
import Tipos
import Tema

data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

nuevoF :: FileSystem
nuevoF = FS [] []

etiquetasF :: FileSystem -> [Etiqueta]
etiquetasF (FS eti ) = eti

temasF :: FileSystem -> [Tema]
temasF (FS  temas) = temas

agregarF :: Tema -> FileSystem -> FileSystem
agregarF tema (FS eti temas)= FS(etiquetasT tema ++ eti)(tema : temas)

filtrarF :: Etiqueta -> FileSystem -> [Tema]
filtrarF eti (FS etis temas) = [tema | tema <- temas, elem eti (etiquetasT tema)]

test = [
    nuevoF == FS [][],
    etiquetasF (FS ["etiquera"] []) == ["etiquera"],
    temasF (FS [] [nuevoT "nombre" "datos"]) == [nuevoT "nombre" "datos"],
    agregarF (nuevoT "nombre" "datos") (FS ["etiquera"] [nuevoT "nombre3" "datos3"]) == FS ["etiquera"] [nuevoT "nombre" "datos",nuevoT "nombre3" "datos3"],
    filtrarF "etiquera" (FS ["etiquera"] [nuevoT "mogs" "datos5"]) == []
    ]
