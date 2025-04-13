# 🐣 Tamagotchi Java

Trabalho final da disciplina de **Programação Orientada a Objetos**.

Um Tamagotchi virtual com diversas interações e fases da vida, desenvolvido com **Java** e interface gráfica em **Swing**.

## ✅ Funcionalidades

- ✅ Alimentar, brincar, dormir e curar
- ✅ Higiene e socialização
- ✅ Mini-jogo (ponto extra)
- ✅ Eventos aleatórios (como doenças e clima)
- ✅ Interface gráfica com botões e imagens
- ✅ Ciclo de vida com estados:
  - Bebê: até 9 anos
  - Adolescente: de 10 a 17 anos
  - Adulto: a partir de 18 anos
- ✅ Explosão por excesso de comida (fome > 150)
- ✅ Ações influenciam na fome, sono e tédio (ex: dormir reduz a fome)

---

## 📁 Estrutura de Pastas

```
📦Trabalho-final-POO
 ┣ 📂model        # Lógica principal do Tamagotchi (atributos, métodos, envelhecimento, mini-jogo, explosão)
 ┣ 📂ui           # Interface gráfica com Swing (botões, status, imagens, reinício)
 ┣ 📂main         # Ponto de entrada do projeto (App.java)
 ┗ 📂assets       # Imagens do Tamagotchi (bebe.png, adolescente.png, adulto.png, explosao.png)
```

---

## 🚀 Como rodar o projeto

### 1. Baixe ou clone o repositório

```bash
git clone https://github.com/seu-usuario/tamagotchi-java.git
```

Ou baixe o `.zip` e extraia em seu computador.

---

### 2. Abra o projeto em uma IDE Java

- Pode ser IntelliJ IDEA, Eclipse ou NetBeans  
- Verifique se o **JDK está instalado e configurado**

---

### 3. Execute o projeto

- Vá até a pasta `main`
- Abra e execute o arquivo `App.java` (ponto de entrada do programa)

---

## 💡 Dica

Ao rodar o programa, a interface gráfica será aberta.  
Você poderá:

- Clicar em **Alimentar**, **Brincar**, **Dormir**, etc.
- Ver o status do Tamagotchi atualizado em tempo real
- Jogar o mini-game para reduzir tédio e fome
- Ver o Tamagotchi crescer com o tempo e até explodir se comer demais 🍔💥
