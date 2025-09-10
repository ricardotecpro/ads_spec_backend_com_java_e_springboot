### **Visão Arquitetural: JavaFX e o Padrão MVC**

O **JavaFX** é o framework moderno para a criação de interfaces gráficas em Java, sendo o sucessor do Swing e AWT. Sua arquitetura é projetada em torno do padrão **Model-View-Controller (MVC)**, uma abordagem que promove a separação de responsabilidades e resulta em um código mais organizado e fácil de manter.

  * **Model**: Representa os dados da aplicação e a lógica de negócio (ex: classes de entidade como `Produto`, `Cliente` e serviços que operam sobre eles).
  * **View**: É a camada de apresentação visual, com a qual o usuário interage. No JavaFX, as Views são comumente definidas em arquivos **FXML**, um formato XML que descreve a hierarquia dos componentes visuais.
  * **Controller**: Atua como o intermediário entre o Model e a View. Ele trata os eventos gerados pelo usuário na View (como cliques de botão) e atualiza o Model ou a View conforme necessário.

A estrutura básica de uma tela JavaFX é o **Stage** (a janela principal), que contém uma **Scene** (a cena, ou o conteúdo da janela). A Scene, por sua vez, é composta por um grafo de **Nodes** (os componentes visuais como botões, caixas de texto, etc.).

### **Estrutura do Projeto: Organização Profissional**

Para uma aplicação JavaFX robusta, a organização dos pacotes é fundamental. Uma estrutura recomendada que reflete o padrão MVC seria:

```
src
└── com
    └── yourproject
        ├── application
        │   └── Main.java             // Classe de inicialização da aplicação
        │
        ├── gui
        │   ├── MainViewController.java // Controller da tela principal
        │   └── MainView.fxml         // Arquivo FXML da tela principal
        │
        ├── gui
        │   └── util                  // Pacote para classes utilitárias da GUI
        │       ├── Alerts.java
        │       └── Constraints.java
        │
        └── model
            ├── entities              // Classes de domínio (ex: Person.java)
            │
            └── services              // Classes de serviço (lógica de negócio)
```

-----

### **Fase 1: Configuração do Ambiente (Eclipse)**

Desde o Java 11, o JavaFX não faz mais parte do JDK padrão. A configuração inicial é um passo crucial.

**Checklist Detalhado:**

1.  **Baixar o JavaFX SDK**: Faça o download do SDK no site da [Gluon](https://gluonhq.com/products/javafx/). Descompacte-o em um local de fácil acesso (ex: `C:\java-libs\javafx-sdk`).
2.  **Baixar o Scene Builder**: Obtenha o instalador do Scene Builder também no site da [Gluon](https://gluonhq.com/products/scene-builder/) e instale-o. Ele é a ferramenta visual para editar os arquivos FXML.
3.  **Instalar o Plugin e(fx)clipse**:
      * No Eclipse, vá em `Help` -\> `Install New Software...`.
      * Adicione o repositório de release do e(fx)clipse (ex: `http://download.eclipse.org/efxclipse/updates-released/3.4.1/site/`).
      * Selecione o plugin `e(fx)clipse` e complete a instalação. Reinicie o Eclipse.
4.  **Configurar o Scene Builder no Eclipse**:
      * Vá em `Window` -\> `Preferences` -\> `JavaFX`.
      * Aponte para o arquivo executável do Scene Builder que você instalou (ex: `C:\Users\SeuUsuario\AppData\Local\SceneBuilder\SceneBuilder.exe`).
5.  **Criar uma User Library para o JavaFX**:
      * Vá em `Window` -\> `Preferences` -\> `Java` -\> `Build Path` -\> `User Libraries`.
      * Clique em `New...`, dê o nome de `JavaFX`.
      * Selecione sua nova biblioteca e clique em `Add External JARs...`.
      * Navegue até a pasta `lib` do seu SDK do JavaFX e adicione todos os arquivos `.jar`.
6.  **Criar e Configurar o Projeto JavaFX**:
      * Crie um novo `JavaFX Project` (`File` -\> `New` -\> `Other...`).
      * Durante a criação, na aba `Libraries`, adicione a User Library `JavaFX` que você criou. **Não crie** o arquivo `module-info.java`.
      * **Passo mais importante:** Crie uma `Run Configuration` (`Run` -\> `Run Configurations...`). Na aba `Arguments`, no campo `VM arguments`, adicione a seguinte linha (ajuste o caminho para o seu SDK):
        ```
        --module-path "C:\java-libs\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml
        ```

### **Fase 2: Criando a Primeira Aplicação com FXML**

Vamos carregar nossa primeira tela, definida em um arquivo FXML.

**1. Arquivo `MainView.fxml`**
Crie este arquivo no pacote `gui`. Você pode abri-lo com o Scene Builder para arrastar e soltar componentes, como um `VBox` e um `Button`.

**2. Classe `Main.java`**
Esta classe inicia a aplicação e carrega o FXML como a cena principal.

```java
// package com.yourproject.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Carrega o arquivo FXML da view principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/yourproject/gui/MainView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setTitle("JavaFX Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

### **Fase 3: Implementando o Controller e Tratando Eventos**

Agora, vamos adicionar interatividade à nossa tela. Usaremos um exemplo simples de uma calculadora de soma.

**1. `MainView.fxml` (editado no Scene Builder)**

  * Adicione dois `TextField` (para os números), um `Button` (para somar) e um `Label` (para o resultado).
  * **Vínculo com o Controller**: Na aba "Controller" do Scene Builder (canto inferior esquerdo), defina a classe do controller: `com.yourproject.gui.MainViewController`.
  * **Vínculo dos Componentes**:
      * Selecione o primeiro `TextField` e, na aba "Code" (canto superior direito), defina seu `fx:id` como `txtNumber1`.
      * Faça o mesmo para o segundo `TextField` (`txtNumber2`), para o `Button` (`btSum`) e para o `Label` (`labelResult`).
      * Selecione o `Button` e, na propriedade `On Action`, digite `#onBtSumAction`. Isso vincula o clique do botão ao método de mesmo nome no controller.

**2. Classe `MainViewController.java`**

```java
// package com.yourproject.gui;

import com.yourproject.gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MainViewController {

    // A anotação @FXML injeta as instâncias dos componentes do FXML
    @FXML
    private TextField txtNumber1;

    @FXML
    private TextField txtNumber2;
    
    @FXML
    private Label labelResult;

    @FXML
    private Button btSum;

    // Este método será chamado quando o botão for clicado
    @FXML
    public void onBtSumAction() {
        try {
            double number1 = Double.parseDouble(txtNumber1.getText());
            double number2 = Double.parseDouble(txtNumber2.getText());
            double sum = number1 + number2;
            labelResult.setText(String.format("%.2f", sum));
        }
        catch (NumberFormatException e) {
            // Usa uma classe utilitária para mostrar um alerta de erro
            Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
        }
    }
}
```

### **Fase 4: Criando Classes Utilitárias Essenciais**

Classes de utilidade ajudam a reutilizar código e a manter os controllers mais limpos.

**1. Classe `Alerts.java`**
Para padronizar a exibição de caixas de diálogo.

```java
// package com.yourproject.gui.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
    public static void showAlert(String title, String header, String content, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait(); // Use showAndWait() para bloquear a execução até o alerta ser fechado
    }
}
```

**2. Classe `Constraints.java`**
Para adicionar restrições a campos de texto, como permitir apenas números.

```java
// package com.yourproject.gui.util;

import javafx.scene.control.TextField;

public class Constraints {
    
    // Restringe o TextField para aceitar apenas dígitos inteiros
    public static void setTextFieldInteger(TextField txt) {
        // Adiciona um listener que observa mudanças na propriedade de texto
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            // Se o novo valor não for nulo e não corresponder à expressão regular para dígitos
            if (newValue != null && !newValue.matches("\\d*")) {
                // Reverte para o valor antigo
                txt.setText(oldValue);
            }
        });
    }

    // Restringe o TextField para aceitar apenas números de ponto flutuante
    public static void setTextFieldDouble(TextField txt) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
                txt.setText(oldValue);
            }
        });
    }
}
```

**Como usar**: No seu `ViewController`, você pode implementar a interface `Initializable` e usar o método `initialize` para aplicar as restrições:

```java
public class MainViewController implements Initializable {
    // ... @FXML dos componentes

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);
    }
    // ... resto do código
}
```

### **Fase 5: Trabalhando com ComboBox**

O `ComboBox` é usado para apresentar uma lista de opções.

```java
// No seu ViewController

@FXML
private ComboBox<Person> comboBoxPerson;

private ObservableList<Person> obsList;

// No método initialize
public void initialize(URL url, ResourceBundle rb) {
    List<Person> list = new ArrayList<>();
    list.add(new Person(1, "Maria"));
    list.add(new Person(2, "Alex"));

    // Converte a lista para uma ObservableList, necessária para o ComboBox
    obsList = FXCollections.observableArrayList(list);
    comboBoxPerson.setItems(obsList);

    // Para obter o item selecionado
    // Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
}
```

**Personalizando a exibição**: Por padrão, o ComboBox exibe o resultado do método `toString()` do objeto. Para mostrar um atributo específico (como `person.getName()`), customize as células:

```java
// Dentro do método initialize
Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
    @Override
    protected void updateItem(Person item, boolean empty) {
        super.updateItem(item, empty);
        setText(empty ? "" : item.getName());
    }
};
comboBoxPerson.setCellFactory(factory);
comboBoxPerson.setButtonCell(factory.call(null));
```
