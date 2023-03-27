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
archivosR (RP file _) = file


listaParaR :: Etiqueta -> Reproductor -> [Tema]
listaParaR eti (RP file _) = [tema | tema <- temasF file, aplicaT eti tema]


temasR :: Reproductor ->[Tema]
temasR (RP fs _) = temasF fs


playR :: Reproductor -> Etiqueta -> Reproductor
playR (RP fs play) eti = RP fs (nuevaP temas)
  where temas = [tema | tema <- temasF fs, elem eti (etiquetasT tema)]



actualR :: Reproductor -> Tema
actualR (RP _ play) = actualP play


avanzarR :: Reproductor -> Reproductor
avanzarR (RP fs playlist) = RP fs (skipP playlist)


retrocederR :: Reproductor -> Reproductor
retrocederR (RP fs play) = RP fs (backP play)


reiniciarR :: Reproductor -> Reproductor
reiniciarR (RP fs play) = RP fs (resetP play)

