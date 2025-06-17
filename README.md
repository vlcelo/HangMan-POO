# HANGMAN
# 🎮 Jogo da Forca em Java — Programação Orientada a Objetos

Este projeto é uma implementação completa do **Jogo da Forca** em Java, desenvolvido como parte da disciplina de **Programação Orientada a Objetos (POO)**. O sistema é executado em terminal e demonstra o uso prático dos principais conceitos da orientação a objetos, além de manipulação de arquivos para persistência de dados.

---

## 🚀 Funcionalidades

- Adivinhação de letras ou palavras completas
- Tentativas limitadas (modo tradicional da Forca)
- Pontuação baseada em desempenho
- Ranking persistente dos jogadores
- Palavras carregadas de arquivo externo
- Interface de linha de comando

---

## 🛠️ Conceitos Aplicados

O projeto utiliza e demonstra os seguintes pilares da POO:

- ✅ **Interface** — `GamePersistence` para padronizar persistência de dados  
- ✅ **Classe Abstrata** — `Game` define a estrutura comum de jogos  
- ✅ **Herança** — `HangmanGame` herda de `Game`  
- ✅ **Polimorfismo** — comportamentos de pontuação e lógica de jogo adaptáveis  
- ✅ **Coleções** — `List`, `Set` e `Map` para palavras, letras tentadas e rankings  
- ✅ **Manipulação de Arquivos** — leitura e escrita de `.txt` para palavras e pontuações  

---

## 📁 Estrutura de Arquivos
├── Game.java # Classe abstrata base para jogos
├── GamePersistence.java # Interface para persistência de dados
├── HangmanGame.java # Implementação principal do jogo
├── Player.java # Classe que representa o jogador
├── ScoreManager.java # Classe que gerencia o ranking
├── WordManager.java # Gerencia a seleção e exibição das palavras
├── palavras.txt # Banco de palavras
├── ranking.txt # Arquivo de pontuação dos jogadores
└── README.md # Descrição do projeto

##📌 Requisitos Técnicos:
- Java 8 ou superior
- Terminal (Linha de Comando)
- Editor de texto (recomendado: VS Code, IntelliJ ou Eclipse)

##👨‍🏫 Projeto Acadêmico
Este projeto foi desenvolvido como parte da disciplina de Programação Orientada a Objetos, do curso de Engenharia de Software. Todos os requisitos foram cumpridos conforme orientação docente.

##🙌 Créditos
Desenvolvido por: Marcelo Vinicius Leicht, João Vitor Rosera, Gustavo Rosário e Vinicius H. Werner Hardt
Curso: Engenharia de Software
Instituição: UNIVILLE - Joinville-SC
Professor: Leanderson André
