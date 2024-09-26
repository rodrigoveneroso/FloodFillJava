# Flood Fill em Java

Este projeto implementa o algoritmo **Flood Fill** em Java, sem o uso de bibliotecas externas. O algoritmo é implementado em duas versões:
1. **Versão com Fila (Queue)**
2. **Versão com Pilha (Stack)**

## Descrição

O **Flood Fill** é um algoritmo utilizado para preencher áreas conectadas em uma matriz, a partir de um ponto inicial. Ele é amplamente utilizado em editores de imagens para ferramentas de preenchimento e também em algoritmos de busca em grafos.

Ambos os algoritmos percorrem uma matriz predefinida de valores (0s e 1s) e substituem uma cor específica por uma nova cor, a partir de um ponto inicial dado pelo usuário.

## Exemplo de Uso

### Como Usar

1. **Baixe ou clone este repositório**.
2. Compile e execute o arquivo desejado:
   - Para a versão com **Fila (Queue)**:
     ```bash
     javac FloodFillQueue.java
     java FloodFillQueue
     ```
   - Para a versão com **Pilha (Stack)**:
     ```bash
     javac FloodFillStack.java
     java FloodFillStack
     ```

3. **Escolha as coordenadas iniciais**:
   - Após a execução do programa, o sistema solicitará as coordenadas iniciais (x, y) do ponto a partir do qual o preenchimento deve começar. Insira os valores separados por espaço. Por exemplo:
     ```
     Digite as coordenadas x e y (separadas por espaço):
     0 0
     ```

### Exemplo de Execução

Quando o programa inicia, ele imprime a matriz original e pede ao usuário as coordenadas do ponto inicial para começar o preenchimento.

#### Matriz inicial:

```plaintext
0 0 0 0 0 1 1 1 1 1 
0 1 1 1 0 1 1 1 1 1 
0 1 1 1 0 1 0 1 1 1 
0 1 1 1 0 1 0 1 1 1 
0 1 1 1 0 1 0 1 1 1 
0 1 1 1 0 1 0 1 1 1 
0 0 1 1 0 0 0 1 1 1 
0 0 1 1 1 1 1 1 1 1 
0 0 1 1 1 1 1 1 1 1 
1 1 1 1 1 1 1 1 1 1 
```

Após informar as coordenadas, o algoritmo Flood Fill preencherá a matriz, alterando a cor de todos os pontos conectados à coordenada inicial que possuam a cor-alvo.
Exemplo de entrada:

     ```
     Digite as coordenadas x e y (separadas por espaço):
     0 0
     ```

Matriz após o preenchimento:

#### Matriz inicial:

```plaintext
2 2 2 2 2 1 1 1 1 1 
2 1 1 1 2 1 1 1 1 1 
2 1 1 1 2 1 2 1 1 1 
2 1 1 1 2 1 2 1 1 1 
2 1 1 1 2 1 2 1 1 1 
2 1 1 1 2 1 2 1 1 1 
2 2 1 1 2 2 2 1 1 1 
2 2 1 1 1 1 1 1 1 1 
2 2 1 1 1 1 1 1 1 1 
1 1 1 1 1 1 1 1 1 1 
```

### Observações:
- A cor que será alterada é a cor **0** e a cor de preenchimento é **2**.
- A matriz utilizada é uma matriz fixa dentro do código. Você pode modificar o conteúdo da matriz diretamente nos arquivos `.java` se desejar testar com diferentes padrões.

## Requisitos

- **Java JDK**: O código foi escrito em Java e requer o JDK instalado para compilação e execução.
