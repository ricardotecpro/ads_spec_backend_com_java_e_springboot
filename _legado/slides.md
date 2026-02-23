---
marp: true
theme: gaia
size: 16:9
paginate: true
footer: 'ricardotecpro.github.io'
---

# ☕ Java
### A Linguagem da Robustez e Portabilidade

![bg blur:2px](https://images.unsplash.com/photo-1511518323289-53c539958998?q=80&w=2070&auto=format&fit=crop)

---

![bg left:40% fit](https://images.unsplash.com/photo-1593443834124-213c4a28c8a1?q=80&w=1932&auto=format&fit=crop)

## O Princípio "WORA"
### Write Once, Run Anywhere

A promessa central do Java: **escreva seu código uma única vez** e ele poderá ser executado em qualquer dispositivo que possua uma Java Virtual Machine (JVM).

- Windows
- macOS
- Linux
- Servidores
- E muito mais!

---

## Como a Mágica Acontece?
### Compilação → Bytecode → Execução

O código Java não é compilado para a máquina, mas para um formato universal: o **bytecode**. A **JVM** (Java Virtual Machine) traduz esse bytecode para cada sistema operacional.

```mermaid
graph TD;
    A[Código .java] -->|`javac`| B(Bytecode .class);
    B --> C{JVM};
    C --> D[Windows];
    C --> E[macOS];
    C --> F[Linux];
style B fill:#FFCA28,stroke:#333
````

-----

## ✨ Características Principais

\<div class="columns"\>
\<div\>

### 📦 Orientado a Objetos

Estrutura o código de forma modular e reutilizável.

### 🔒 Fortemente Tipado

Detecta erros na compilação, garantindo mais segurança.

\</div\>
\<div\>

### 🧹 Gerenciador de Memória

O *Garbage Collector* (GC) automatiza a limpeza de memória.

### 📖 Explícito e Legível

A sintaxe favorece a clareza em grandes projetos.

\</div\>
\</div\>

\<style scoped\>
.columns {
display: flex;
gap: 40px;
margin-top: 40px;
}
.columns \> div {
flex: 1;
}
.columns h3 {
margin-bottom: 10px;
border-bottom: 2px solid \#007396;
padding-bottom: 5px;
}
\</style\>

-----

## 📦 Um Ecossistema Gigante

O poder do Java vai além da linguagem.

  - **Spring Framework**

      - O padrão para criar APIs e microserviços robustos.

  - **Maven & Gradle**

      - Ferramentas essenciais para gerenciar projetos e dependências.

  - **Comunidade Ativa**

      - Milhões de desenvolvedores e bibliotecas para tudo que você precisar.

-----

## 🎯 Onde o Java é Rei?

  - **Aplicações Corporativas (Enterprise)**
      - *Sistemas bancários, e-commerce, ERPs.*
  - **APIs e Microsserviços**
      - *A espinha dorsal da web moderna com Spring Boot.*
  - **Big Data**
      - *Ferramentas como Hadoop e Kafka rodam na JVM.*
  - **Desenvolvimento Android**
      - *A linguagem original para apps nativos.*

-----

## 🚀 Hello, World\! - O Código

O ponto de partida de toda aplicação Java. O nome do arquivo deve ser `HelloWorld.java`.

```java
public class HelloWorld {
    
    public static void main(String[] args) {
        System.out.println("Olá, Mundo Robusto com Java!");
    }

}
```

-----

## 🚀 Hello, World\! - A Execução

No terminal, o processo é simples:

**1. Compilar para bytecode**

```sh
# Cria o arquivo HelloWorld.class
javac HelloWorld.java
```

**2. Executar na JVM**

```sh
# Lê e executa o bytecode
java HelloWorld
```

-----

## Perguntas?

**Obrigado\!**

[ricardotecpro.github.io](https://ricardotecpro.github.io/)
