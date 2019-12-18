package edu.fiuba.algoChess.interfaz.vista;

import javafx.scene.media.AudioClip;

import java.io.File;
import java.util.Map;

public class ReproductorSonidos {
    static private Map<String,String> diccionarioSonidos = Map.of(
            "spell", "battle/spell.wav",
            "coin", "inventory/coin.wav",
            "walk", "misc/random3.wav",
            "agrupate", "misc/random6.wav",
            "die", "NPC/ogre/ogre3.wav",
            "sword", "battle/sword-unsheathe.wav"
    );

    public static void reproducir(String sonido) {
        AudioClip audio = new AudioClip(new File("src/main/resources/sonidos/RPGSoundPack/" + diccionarioSonidos.get(sonido)).toURI().toString());
        audio.play();
    }
}
