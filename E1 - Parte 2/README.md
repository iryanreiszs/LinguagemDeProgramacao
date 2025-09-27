<img width="1473" height="522" alt="image" src="https://github.com/user-attachments/assets/4d9393ed-cd5c-4aa3-98dc-70a0a2bdca25" />


# E1 – Parte 2

Este diretório contém os exercícios referentes à **Parte 2** da unidade E1 da disciplina de Linguagem de Programação I.

## Estrutura

Cada exercício está organizado em pacotes e classes conforme o tema trabalhado. Em geral, há:

- **Classes modelo** com atributos e métodos (sem interface gráfica).
- **Frames/guias** (classes com `JFrame`) que permitem inserir valores via interface e exibir resultados ou salvar em CSV.
- Um `Main` ou classe executável para demonstrar o uso das classes.

Dentro da Parte 2 você deve encontrar algo como:

E1 – Parte 2/
├── ExercicioImagem/
│ └── Imagem2/
│ ├── Praia.java
│ ├── Astronauta.java
│ ├── Baleia.java
│ ├── PraiaFrame.java
│ ├── AstronautaFrame.java
│ ├── BaleiaFrame.java
│ └── Main.java
│
├── ExercicioVideo/
│ └── Main.java
│
└── ... outros pacotes/exercícios


> **Obs.**: Dependendo do seu código, os nomes de pacotes ou classes podem variar.

## Como executar

1. Importe o projeto no seu IDE (Eclipse, IntelliJ, NetBeans, etc.) como um projeto Java.
2. Configure o JDK correto (versão compatível com seu código, por exemplo Java 8, 11 ou superior).
3. No pacote que deseja testar (por exemplo `ExercicioImagem.Imagem2`), execute o `Main` ou a classe `Frame` desejada:
   - Para testar via interface gráfica, execute `PraiaFrame`, `AstronautaFrame` ou `BaleiaFrame`.
   - Para testar via console, execute a classe `Main` que instancia os objetos e chama os métodos.
4. Ao usar os Frames:
   - Preencha os campos textuais correspondentes aos atributos.
   - Clique em “Criar …”.
   - Uma janela `JOptionPane` mostrará os resultados.
   - Os dados inseridos serão salvos em arquivos CSV (como `praias.csv`, `astronautas.csv`, `baleias.csv`) na raiz de execução.

## Detalhes técnicos

- Cada classe segue o padrão de encapsulamento: atributos privados, getters e setters.
- Os métodos públicos (como `viajar()`, `relaxar()`, `nadar()`) imprimem no console ou via `JOptionPane`.
- Os *Frames* utilizam `GridBagLayout`, campos `JTextField`, `JButton` e tratamento de ação com `ActionListener`.
- A persistência simples é feita com `FileWriter` em modo append, com separador vírgula (CSV).

## Exemplos de uso

```java
// Exemplo no console
Praia p = new Praia("Azul", "Branca", "Ondas fortes");
p.relaxar();
// → imprime algo como “A praia tem areia Branca e ondas Ondas fortes!”

Astronauta a = new Astronauta("Ryan", "Branco", "Explorar Marte");
a.viajar();
// → imprime “Ryan está viajando para cumprir o objetivo: Explorar Marte”
```


ou via interface:

1. Executar PraiaFrame

2. Digitar no campo “Mar”, “Areia”, “Ondas”

3. Clicar “Criar Praia”

4. Ver mensagem correspondente e ver dados gravados em praias.csv

### Observações:

Certifique-se de que o diretório de saída (local de execução) permite gravação de arquivos para que os CSVs sejam gerados.

Validações (como número ou formato incorreto) não estão tratadas em profundidade — tome cuidado ao digitar valores inválidos.

Caso adicione novos exercícios ou classes, mantenha o padrão de estrutura para facilitar leitura e manutenção.
