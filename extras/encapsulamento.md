
---

# 🧠 Encapsulamento em Java

## 📌 O que é Encapsulamento?

- Princípio da programação orientada a objetos.
    
- **Objetivo:** esconder detalhes internos de implementação de uma classe.
    
- Expor apenas **operações seguras**, garantindo que o objeto esteja sempre em um **estado consistente**.
    

---

## 🎛️ Analogia com Aparelho Eletrônico

- Um **aparelho de som** tem circuitos internos complexos.
    
- O usuário **não pode acessar** esses circuitos diretamente.
    
- Apenas operações seguras são expostas: `tocar`, `pausar`, `avançar`, `retroceder`.
    
- Evita que o aparelho entre em um estado inválido.
    

---

## 💡 Regra de Ouro

> O objeto deve estar sempre em um estado consistente.  
> A **própria classe deve garantir** isso.

---

## 🧱 Implementação em Java

### 1. Modificadores de Acesso

- Os **atributos** devem ser declarados como `private`.
    
- Exemplo:
    

```java
private String name;
private double price;
```

---

### 2. Acesso via Métodos Getters e Setters

#### Getter

- Permite **acessar** o valor de um atributo.
    

```java
public String getName() {
    return name;
}
```

#### Setter

- Permite **alterar** o valor de um atributo.
    

```java
public void setName(String name) {
    this.name = name;
}
```

> Esse padrão segue a convenção **JavaBeans**.

---

## 🧪 Exemplo Prático

Classe `Product` com atributos: `name`, `price`, `quantity`.

### Etapas:

1. Tornar todos os atributos `private`.
    
2. Criar métodos `get` e `set` para `name` e `price`.
    
3. Criar **apenas** o método `get` para `quantity`.
    

### Motivo:

- `quantity` só pode ser alterado por métodos específicos (`addProducts`, `removeProducts`).
    
- **Regra de negócio:** protege a integridade do objeto.
    

---

## 🔁 Testando no Programa Principal

### Exemplo de uso:

```java
product.setName("Computer");
System.out.println(product.getName());

product.setPrice(1200.00);
System.out.println(product.getPrice());
```

### Acesso Direto (Inválido):

```java
product.name = "TV"; // ❌ Erro: name is not accessible
```

---

## 🚫 Por que não criar `setQuantity`?

- **Evita inconsistências.**
    
- `quantity` só deve mudar por **entrada/saída de estoque**.
    
- Garante que a lógica de negócio seja sempre respeitada.
    

---

## 🛠️ Organização dos Métodos

- Colocar os métodos `get` e `set` **após os construtores**.
    
- Agrupar os métodos relacionados (ex: `getPrice` e `setPrice` juntos).
    

---

## 📚 Conclusão

- Encapsulamento melhora a segurança e integridade do sistema.
    
- Facilita a manutenção e evolução do código.
    
- Permite aplicar regras de negócio diretamente na classe.
    

---

