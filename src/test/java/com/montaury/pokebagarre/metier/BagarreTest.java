package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.webapi.PokeBuildApi;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import static com.montaury.pokebagarre.metier.Bagarre.determinerVainqueur;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;



class BagarreTest {
    @Test
    void premier_pokemon_vide() {
        var fausseApi = Mockito.mock(PokeBuildApi.class);
        Bagarre bagarre = new Bagarre(fausseApi);

        var throwable= catchThrowable(() -> bagarre.demarrer(null, String.valueOf("Pikachu")));
        assertThat(throwable).hasMessage("Le premier pokemon n'est pas renseigne");
    }

    @Test
    void deuxieme_pokemon_vide() {
        var fausseApi = Mockito.mock(PokeBuildApi.class);
        Bagarre bagarre = new Bagarre(fausseApi);

        var throwable= catchThrowable(() -> bagarre.demarrer(String.valueOf("Pikachu"),null));
        assertThat(throwable).hasMessage("Le second pokemon n'est pas renseigne");
    }

    @Test
    void pokemon_meme_nom() {
        var fausseApi = Mockito.mock(PokeBuildApi.class);
        Bagarre bagarre = new Bagarre(fausseApi);

        var throwable= catchThrowable(() -> bagarre.demarrer(String.valueOf("Pikachu"),String.valueOf("Pikachu")));
        assertThat(throwable).hasMessage("Impossible de faire se bagarrer un pokemon avec lui-meme" );
    }
}