<h1 align="center">🧮 Calculadora Java com Interface Gráfica</h1>

<p align="center">
  <img src="./133476d3-5153-426b-83e5-0af3d739c96e.png" alt="Calculadora Java" width="500"/>
</p>

<p align="center">
  Uma calculadora feita em Java usando <b>Swing</b>, com modos padrão e científico.<br>
  Interface moderna, botões organizados, e estrutura pronta para lógica de cálculos!
</p>

---

## ✨ Funcionalidades

✔️ Interface gráfica com layout organizado  
✔️ Modo **Padrão** com operações básicas  
✔️ Modo **Científico** com botões prontos para funções avançadas  
✔️ Botões "C" (limpar tudo) e "CE" (apagar último caractere)  
✔️ Campo de entrada centralizado e bloqueado para edição manual  
✔️ Estrutura MVC para separar lógica da interface

---

## 📁 Estrutura do Projeto

📦 src/ ├── model/ │ └── Calculo.java # Classe de lógica dos cálculos├── view/ │ └── FrmCalculadora.java # Interface gráfica └── Main.java # Ponto de entrada do programa

---

## 🚀 Como Rodar

1. Clone o repositório:
   ```bash
   git clone https://github.com/ProjetosUNISC/Ex6Calculadora
Abra o projeto em uma IDE como IntelliJ IDEA ou Eclipse.

Crie o arquivo Main.java no diretório src/ com o seguinte conteúdo:

java
Copiar
Editar
import view.FrmCalculadora;

public class Main {
    public static void main(String[] args) {
        new FrmCalculadora();
    }
}
Execute a classe Main.java.

🛠️ Tecnologias Utilizadas
💻 Java SE 8 ou superior

🧰 Swing (javax.swing) para construção da interface

🛠️ IDE recomendada: IntelliJ IDEA