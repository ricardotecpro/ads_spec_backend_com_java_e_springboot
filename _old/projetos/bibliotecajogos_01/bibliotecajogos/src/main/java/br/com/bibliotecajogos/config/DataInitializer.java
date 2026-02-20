package br.com.bibliotecajogos.config;

import br.com.bibliotecajogos.entity.Categoria;
import br.com.bibliotecajogos.entity.Jogo;
import br.com.bibliotecajogos.repository.CategoriaRepository;
import br.com.bibliotecajogos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Profile("dev") // A anotação @Profile("dev") garante que este bean só será ativado quando o perfil 'dev' estiver ativo
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoriaRepository.count() == 0) {
            System.out.println(">>> Populando banco de dados de desenvolvimento...");

            // Criar Categorias
            Categoria rpg = new Categoria();
            rpg.setNome("RPG");

            Categoria acao = new Categoria();
            acao.setNome("Ação");

            Categoria estrategia = new Categoria();
            estrategia.setNome("Estratégia");

            Categoria aventura = new Categoria();
            aventura.setNome("Aventura");

            categoriaRepository.saveAll(Arrays.asList(rpg, acao, estrategia, aventura));

            // Criar Jogos
            Jogo jogo1 = new Jogo();
            jogo1.setTitulo("The Witcher 3: Wild Hunt");
            jogo1.setAutor("CD Projekt Red");
            jogo1.setAnoPublicacao(2015);
            jogo1.setGenero("RPG de Ação");
            jogo1.setCategoria(rpg);
            jogo1.setFinalizado(true);
            jogo1.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/thumb/0/06/TW3_Wild_Hunt.png/270px-TW3_Wild_Hunt.png");

            Jogo jogo2 = new Jogo();
            jogo2.setTitulo("Red Dead Redemption 2");
            jogo2.setAutor("Rockstar Games");
            jogo2.setAnoPublicacao(2018);
            jogo2.setGenero("Ação-Aventura");
            jogo2.setCategoria(acao);
            jogo2.setFinalizado(true);
            jogo2.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/e/e7/Red_Dead_Redemption_2.png");

            Jogo jogo3 = new Jogo();
            jogo3.setTitulo("Age of Empires IV");
            jogo3.setAutor("Relic Entertainment");
            jogo3.setAnoPublicacao(2021);
            jogo3.setGenero("Estratégia em Tempo Real");
            jogo3.setCategoria(estrategia);
            jogo3.setFinalizado(false);
            jogo3.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/4/43/Capa_do_jogo_Age_of_Empires_IV.jpg");

            Jogo jogo4 = new Jogo();
            jogo4.setTitulo("Baldur's Gate 3");
            jogo4.setAutor("Larian Studios");
            jogo4.setAnoPublicacao(2023);
            jogo4.setGenero("RPG");
            jogo4.setCategoria(rpg);
            jogo4.setFinalizado(false);
            jogo4.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/1/18/Baldur%27s_Gate_III_Larian_Studios_key_art.png");

            Jogo jogo5 = new Jogo();
            jogo5.setTitulo("God of War Ragnarök");
            jogo5.setAutor("Santa Monica Studio");
            jogo5.setAnoPublicacao(2022);
            jogo5.setGenero("Ação-Aventura");
            jogo5.setCategoria(aventura);
            jogo5.setFinalizado(true);
            jogo5.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/a/a5/God_of_War_Ragnar%C3%B6k_capa.jpg");

            Jogo jogo6 = new Jogo();
            jogo6.setTitulo("Elden Ring");
            jogo6.setAutor("FromSoftware");
            jogo6.setAnoPublicacao(2022);
            jogo6.setGenero("RPG de Ação");
            jogo6.setCategoria(rpg);
            jogo6.setFinalizado(true);
            jogo6.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/0/0d/Elden_Ring_capa.jpg");

            Jogo jogo7 = new Jogo();
            jogo7.setTitulo("Cyberpunk 2077");
            jogo7.setAutor("CD Projekt Red");
            jogo7.setAnoPublicacao(2020);
            jogo7.setGenero("RPG de Ação");
            jogo7.setCategoria(rpg);
            jogo7.setFinalizado(true);
            jogo7.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/thumb/f/f7/Cyberpunk_2077_capa.png/270px-Cyberpunk_2077_capa.png");

            Jogo jogo8 = new Jogo();
            jogo8.setTitulo("StarCraft II: Wings of Liberty");
            jogo8.setAutor("Blizzard Entertainment");
            jogo8.setAnoPublicacao(2010);
            jogo8.setGenero("Estratégia em Tempo Real");
            jogo8.setCategoria(estrategia);
            jogo8.setFinalizado(true);
            jogo8.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/4/40/StarCraft_II_capa.jpg");

            Jogo jogo9 = new Jogo();
            jogo9.setTitulo("The Legend of Zelda: Tears of the Kingdom");
            jogo9.setAutor("Nintendo");
            jogo9.setAnoPublicacao(2023);
            jogo9.setGenero("Ação-Aventura");
            jogo9.setCategoria(aventura);
            jogo9.setFinalizado(false);
            jogo9.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/2/25/Zelda_TotK_capa.jpg");

            Jogo jogo10 = new Jogo();
            jogo10.setTitulo("Grand Theft Auto V");
            jogo10.setAutor("Rockstar Games");
            jogo10.setAnoPublicacao(2013);
            jogo10.setGenero("Ação-Aventura");
            jogo10.setCategoria(acao);
            jogo10.setFinalizado(true);
            jogo10.setUrlCapa("https://upload.wikimedia.org/wikipedia/pt/8/80/Grand_Theft_Auto_V_capa.png");

            jogoRepository.saveAll(Arrays.asList(jogo1, jogo2, jogo3, jogo4, jogo5, jogo6, jogo7, jogo8, jogo9, jogo10));

            System.out.println(">>> Banco de dados populado com sucesso!");
        } else {
            System.out.println(">>> O banco de dados já está populado. Nenhuma ação foi tomada.");
        }
    }
}