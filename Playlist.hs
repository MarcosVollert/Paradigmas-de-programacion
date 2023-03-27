module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
where
import Tipos
import Tema
data Playlist = Play Int [ Tema ] deriving (Eq, Show)

nuevaP :: [Tema] -> Playlist
nuevaP tema = Play 0 tema

actualP :: Playlist -> Tema
actualP (Play pos tema) = tema !! pos

skipP :: Playlist -> Playlist
skipP (Play pos tema) = Play (pos + 1) tema

backP :: Playlist -> Playlist
backP (Play pos tema) = Play (pos - 1) tema

resetP :: Playlist -> Playlist
resetP (Play _ tema) = Play 0 tema 