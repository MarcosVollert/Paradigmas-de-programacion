module Reproductor ( Reproductor, nuevoR, archivosR, temasR, playR, actualR, avanzarR, retrocederR, reiniciarR )
where
import Tipos
import Tema
import Playlist
import FileSystem

data Reproductor = RP FileSystem Playlist deriving (Eq, Show)

nuevoR :: FileSystem -> Reproductor
nuevoR file = RP file (nuevaP [])


archivosR :: Reproductor ->FileSystem
archivosR (RP file ) = file


listaParaR :: Etiqueta -> Reproductor -> [Tema]
listaParaR eti (RP file ) = [tema | tema <- temasF file, aplicaT eti tema]


temasR :: Reproductor ->[Tema]
temasR (RP file ) = temasF file


playR :: Reproductor -> Etiqueta -> Reproductor
playR (RP file play) eti = RP file (nuevaP temas)
  where temas = [tema | tema <- temasF file, elem eti (etiquetasT tema)]



actualR :: Reproductor -> Tema
actualR (RP  play) = actualP play


avanzarR :: Reproductor -> Reproductor
avanzarR (RP file playlist) = RP file (skipP playlist)


retrocederR :: Reproductor -> Reproductor
retrocederR (RP file play) = RP file (backP play)


reiniciarR :: Reproductor -> Reproductor
reiniciarR (RP file play) = RP file (resetP play)

test = [
  nuevoR (nuevoF) == (RP (nuevoF) (nuevaP [])),
  archivosR (RP (nuevoF) (nuevaP [])) == nuevoF,
  listaParaR "etiquera" (RP (nuevoF) (nuevaP [])) == [],
  temasR (RP (nuevoF) (nuevaP [])) == [],
  playR  (RP (nuevoF) (nuevaP [])) "etiquera" == RP nuevoF (nuevaP []),
  actualR (RP (nuevoF) (nuevaP [nuevoT "tema1" "a"])) == (nuevoT "tema1" "a"),
  avanzarR (RP (nuevoF) (nuevaP [nuevoT "tema1" "a"])) == RP (nuevoF) (skipP((nuevaP [nuevoT "tema1" "a"]))),
  retrocederR (RP (nuevoF) (nuevaP [nuevoT "tema1" "a"])) == RP (nuevoF) (backP((nuevaP [nuevoT "tema1" "a"]))),
  reiniciarR (RP (nuevoF) (nuevaP [nuevoT "tema1" "a"])) == RP (nuevoF) (resetP((nuevaP [nuevoT "tema1" "a"])))
  ]
