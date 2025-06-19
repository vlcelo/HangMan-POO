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
- ├── Game.java # Classe abstrata base para jogos
- ├── GamePersistence.java # Interface para persistência de dados
- ├── HangmanGame.java # Implementação principal do jogo
- ├── Player.java # Classe que representa o jogador
- ├── ScoreManager.java # Classe que gerencia o ranking
- ├── WordManager.java # Gerencia a seleção e exibição das palavras
- ├── palavras.txt # Banco de palavras
- ├── ranking.txt # Arquivo de pontuação dos jogadores
- └── README.md # Descrição do projeto

---

## 📌 Requisitos Técnicos:
- Java 8 ou superior
- Terminal (Linha de Comando)
- Editor de texto (recomendado: VS Code, IntelliJ ou Eclipse)

---

## 👨‍🏫 Projeto Acadêmico
Este projeto foi desenvolvido como parte da disciplina de Programação Orientada a Objetos, do curso de Engenharia de Software. Todos os requisitos foram cumpridos conforme orientação docente.

---

# 🎮 Como jogar este jogo da forca em Java

Siga os passos abaixo para compilar e executar o jogo diretamente no seu computador.

---

## 📥 Passo 1 – Baixar o projeto
- Você pode clonar o repositório via Git ou baixar como .zip:
- git clone https://github.com/vlcelo/HangMan-POO.git
- Ou clique em Code > Download ZIP, depois extraia os arquivos.

## 📁 Passo 2 – Acesse a pasta do projeto
- Entre na pasta projeto, onde estão os arquivos .java:
- cd HangMan-POO/projeto
- No Windows (via Prompt de Comando):
- cd "C:\caminho\ate\HangMan-POO\projeto"

## 🛠️ Passo 3 – Compilar o código
- Compile todos os arquivos .java com o comando:
- javac *.java
- Isso vai gerar os arquivos .class necessários para executar o jogo.

## ▶️ Passo 4 – Rodar o jogo
- Agora execute o jogo com:
- java HangmanGame
- O jogo iniciará no terminal e pedirá o nome do jogador. A partir daí, é só seguir as instruções na tela!

## 💾 Arquivos necessários
- palavras.txt → contém o banco de palavras para o jogo (será criado automaticamente com palavras padrão se não existir)
- ranking.txt → salva a pontuação dos jogadores

## ✅ Exemplo de uso
- Digite seu nome: Ariovaldo
- ---INICIO DA NOVA RODADA---
- Palavra: _ _ _ _ _ _
- Tentativas restantes: 6
- Adivinhe uma letra ou a palavra completa: A

## 🙋‍♂️ Dúvidas?
- Se aparecer erro como:
"Erro: Não foi possível localizar nem carregar a classe principal HangmanGame"
Certifique-se de que:

- Você está na pasta correta
- Os arquivos .class foram gerados com javac
- O nome do arquivo é HangmanGame.java com a primeira letra maiúscula

---

## 🙌 Créditos
Desenvolvido por: Marcelo Vinicius Leicht, João Vitor Rosera, Gustavo do Rosário Nunes e Vinicius H. Werner Hardt
Curso: Engenharia de Software
Instituição: UNIVILLE - Joinville-SC
Professor: Leanderson André
