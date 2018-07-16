package davidbarbaran.searchmusicrest.controller

import davidbarbaran.searchmusicrest.model.SongYoutube

interface ViewController {

    interface ViewSearch {
        fun listSong(list: MutableList<SongYoutube>)
    }
}