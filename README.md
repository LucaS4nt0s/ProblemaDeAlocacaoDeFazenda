# Trabalho Prático 3: Aquisição de Terras (Land Acquisition)

**Disciplina:** Projeto e Análise de Algoritmos  
**Aluno:** Luca Santos  
**Linguagem:** Java

---

## 📝 Descrição do Problema
O objetivo deste trabalho é minimizar o custo para comprar um conjunto de $N$ terrenos retangulares. O custo de um grupo de terrenos comprados juntos é dado por:
$$\text{max}(\text{largura}) \times \text{max}(\text{altura})$$

O problema exige uma solução eficiente para $N \le 50.000$, o que inviabiliza abordagens de força bruta ou programação dinâmica quadrática $O(N^2)$.

---

## 🚀 A Solução: Convex Hull Trick (CHT)

A solução implementada utiliza **Programação Dinâmica** otimizada com a técnica **Convex Hull Trick**, reduzindo a complexidade para **$O(N \log N)$**.

### 1. Pré-processamento (Poda e Ordenação)
Antes de aplicar a DP, realizamos uma limpeza nos dados:
1.  Ordenamos os terrenos por **Largura Crescente**.
2.  Removemos terrenos "dominados" (aqueles que possuem largura e altura menores ou iguais a outro terreno subsequente).
   
**Resultado:** Uma lista onde a Largura é estritamente crescente e a Altura (Comprimento) é estritamente decrescente.

### 2. A Recorrência
A equação da Programação Dinâmica é:
$$DP[i] = \min_{0 \le j < i} \{ DP[j] + \text{Largura}[i] \times \text{Altura}[j+1] \}$$

### 3. A Otimização Geométrica
Reescrevendo a fórmula como a equação de uma reta $y = mx + c$:
* **$y$**: Custo total ($DP[i]$)
* **$x$**: Largura atual ($\text{Largura}[i]$)
* **$m$**: Inclinação ($\text{Altura}[j+1]$ - decrescente)
* **$c$**: Intercepto ($DP[j]$)

Utilizamos uma estrutura de dados **Deque (Double Ended Queue)** para manter a *Envoltória Convexa Inferior* das retas, permitindo encontrar o custo mínimo em tempo amortizado constante.

---

## 📊 Análise de Complexidade

| Etapa | Complexidade | Justificativa |
| :--- | :--- | :--- |
| **Ordenação** | $O(N \log N)$ | Timsort (Java Arrays.sort) |
| **Poda** | $O(N)$ | Varredura linear única |
| **DP + CHT** | $O(N)$ | Cada reta é inserida e removida da Deque no máximo uma vez (custo amortizado) |
| **Total** | **$O(N \log N)$** | Dominado pela ordenação |

---

## 📈 Resultados Experimentais

Para validar a eficiência, comparou-se a solução otimizada (**CHT**) contra uma solução ingênua de Programação Dinâmica (**DP $O(N^2)$**) utilizando um caso de teste de "Pior Caso" (sem poda possível).

**Ambiente de Teste:**
* Entradas geradas aleatoriamente e ordenadas para evitar poda (Pior Caso).
* Tempos medidos em milissegundos (ms).

| Entrada ($N$) | DP $O(N^2)$ (ms) | CHT $O(N \log N)$ (ms) |
| :--- | :--- | :--- | 
| 5.000 | 62 | 52 |
| 10.000 | 141 | 81 |
| 25.000 | 393 | 119 |
| **50.000** | **1.338** | **129** |

### Conclusão dos Testes
Enquanto o tempo da solução $O(N^2)$ cresce quadraticamente (ao dobrar a entrada, o tempo quadruplica), a solução com **Convex Hull Trick** mantém um crescimento quase linear, provando ser escalável para grandes volumes de dados.
