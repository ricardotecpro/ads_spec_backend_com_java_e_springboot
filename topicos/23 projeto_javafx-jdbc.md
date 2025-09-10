### **Visão Arquitetural: Integrando JavaFX, Camada de Serviço e DAO**

Este projeto representa uma aplicação desktop completa, integrando uma interface gráfica moderna com um banco de dados relacional. A arquitetura é projetada em camadas para garantir baixo acoplamento e alta coesão, facilitando a manutenção e a escalabilidade.

1.  **Camada de Visão (GUI - JavaFX)**: Composta por arquivos FXML que definem a estrutura visual e Controllers Java que gerenciam a interação do usuário. Esta camada não conhece os detalhes do banco de dados.
2.  **Camada de Serviço (Service Layer)**: Atua como um intermediário crucial. Os Controllers da GUI dependem dos serviços para obter e manipular dados. Esta camada encapsula a lógica de negócio e orquestra as operações, decidindo quais DAOs chamar.
3.  **Camada de Acesso a Dados (DAO - JDBC)**: Implementa o padrão Data Access Object. É a única camada que interage diretamente com o banco de dados via JDBC. Ela é responsável por executar as queries SQL e mapear os resultados para os objetos de entidade.

Essa separação clara de responsabilidades é a chave para um software robusto e profissional.

### **Estrutura do Projeto: Organização para um CRUD Completo**

A organização dos pacotes reflete diretamente a arquitetura em camadas, tornando o projeto intuitivo.

```
src
└── com
    └── yourproject
        ├── application
        │   └── Main.java             // Classe de inicialização da aplicação
        │
        ├── db                        // Pacote de conexão com o banco (reutilizado)
        │   ├── DB.java
        │   └── DbException.java
        │
        ├── gui
        │   ├── MainView.fxml
        │   ├── MainViewController.java
        │   ├── DepartmentList.fxml
        │   ├── DepartmentListController.java
        │   ├── DepartmentForm.fxml
        │   ├── DepartmentFormController.java
        │   └── ... (outras views e controllers)
        │
        ├── gui
        │   ├── listeners
        │   │   └── DataChangeListener.java // Interface para o padrão Observer
        │   └── util                  // Classes utilitárias da GUI
        │       ├── Alerts.java
        │       ├── Constraints.java
        │       └── Utils.java
        │
        └── model
            ├── entities              // Classes de domínio (Department, Seller)
            ├── services              // Camada de serviço (DepartmentService, SellerService)
            ├── dao                   // Interfaces DAO (DepartmentDao, SellerDao)
            │   └── impl              // Implementações JDBC dos DAOs
            └── exceptions
                └── ValidationException.java // Exceção para erros de validação de formulário
```

-----

### **Fase 1: Configuração do Projeto e Janela Principal**

Esta fase estabelece a base da aplicação: a janela principal que hospedará as outras telas.

**1. Configuração do Projeto**

  * Crie um novo Projeto JavaFX no Eclipse.
  * Adicione as User Libraries `JavaFX` e `MySQLConnector` ao build path do projeto.
  * Configure os `VM arguments` na sua `Run Configuration`:
    ```
    --module-path "C:\caminho\para\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml
    ```
  * Copie a camada de acesso a dados (pacotes `db`, `model.dao`, `model.dao.impl`) e o arquivo `db.properties` do projeto JDBC anterior.

**2. Criando a Janela Principal (`MainView.fxml`)**
Use o Scene Builder para criar uma tela principal. O layout ideal é um `ScrollPane` contendo um `VBox`. Dentro do `VBox`, adicione um `MenuBar` para a navegação.

**3. Carregando a View e Implementando a Navegação**
O `MainViewController` terá um método dinâmico para carregar outras views dentro do `ScrollPane` da janela principal.

```java
// package com.yourproject.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.function.Consumer;

public class MainViewController {

    @FXML private MenuItem menuItemSeller;
    @FXML private MenuItem menuItemDepartment;
    @FXML private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        System.out.println("onMenuItemSellerAction");
    }

    @FXML
    public void onMenuItemDepartmentAction() {
        // O Consumer permite passar uma ação de inicialização para o controller da nova tela
        loadView("/com/yourproject/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        });
    }

    @FXML
    public void onMenuItemAboutAction() {
        loadView("/com/yourproject/gui/About.fxml", x -> {});
    }

    // Método sincronizado para evitar problemas de thread
    private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            // Pega a cena principal e seu conteúdo (o ScrollPane -> VBox)
            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            // Guarda o primeiro elemento (o MenuBar) e limpa o VBox principal
            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            
            // Adiciona o MenuBar e os filhos da nova VBox
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());
            
            // Executa a ação de inicialização passada como parâmetro
            T controller = loader.getController();
            initializingAction.accept(controller);

        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
        }
    }
}
```

### **Fase 2: CRUD de Departamentos - Listagem e Formulário**

Vamos implementar o ciclo completo de operações para a entidade `Department`.

**1. Controller da Lista (`DepartmentListController.java`)**
Este controller gerencia a tela que exibe todos os departamentos em uma `TableView`.

```java
// package com.yourproject.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DepartmentListController implements Initializable {

    private DepartmentService service;
    
    @FXML private TableView<Department> tableViewDepartment;
    @FXML private TableColumn<Department, Integer> tableColumnId;
    @FXML private TableColumn<Department, String> tableColumnName;
    @FXML private Button btNew;
    
    private ObservableList<Department> obsList;

    // Injeção de dependência do serviço
    public void setDepartmentService(DepartmentService service) {
        this.service = service;
    }

    public void updateTableView() {
        if (service == null) {
            throw new IllegalStateException("Service was null");
        }
        List<Department> list = service.findAll();
        obsList = FXCollections.observableArrayList(list);
        tableViewDepartment.setItems(obsList);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Padrão para iniciar o comportamento das colunas da tabela
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        // ...
    }
    
    @FXML
    public void onBtNewAction(ActionEvent event) {
        // Lógica para abrir o formulário de diálogo
    }
}
```

**2. Abrindo o Formulário de Diálogo (`createDialogForm`)**
Este método, dentro do `DepartmentListController`, é responsável por criar e exibir a janela de formulário (modal).

```java
// Dentro de DepartmentListController.java

private void createDialogForm(Department obj, String absoluteName, Stage parentStage) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
        AnchorPane pane = loader.load();

        DepartmentFormController controller = loader.getController();
        controller.setDepartment(obj);
        controller.setDepartmentService(new DepartmentService());
        
        // Inscreve o ListController para ouvir mudanças
        controller.subscribeDataChangeListener(this);
        
        controller.updateFormData();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Enter Department data");
        dialogStage.setScene(new Scene(pane));
        dialogStage.setResizable(false);
        dialogStage.initOwner(parentStage);
        dialogStage.initModality(Modality.WINDOW_MODAL); // Bloqueia a janela pai
        dialogStage.showAndWait();

    } catch (IOException e) {
        Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
    }
}
```

### **Fase 3: Comunicação entre Controllers com o Padrão Observer**

Quando um departamento é salvo no formulário, a lista na tela principal precisa ser atualizada. Usamos o padrão Observer para desacoplar os controllers.

**1. Interface `DataChangeListener.java`**
Define o contrato para qualquer classe que queira ser notificada sobre mudanças nos dados.

```java
// package com.yourproject.gui.listeners;

public interface DataChangeListener {
    void onDataChanged();
}
```

**2. `DepartmentFormController.java` (O Sujeito / Publicador)**
Este controller notifica os listeners (observadores) quando um dado é salvo.

```java
public class DepartmentFormController {
    // ...
    private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

    public void subscribeDataChangeListener(DataChangeListener listener) {
        dataChangeListeners.add(listener);
    }

    private void notifyDataChangeListeners() {
        for (DataChangeListener listener : dataChangeListeners) {
            listener.onDataChanged();
        }
    }

    @FXML
    public void onBtSaveAction(ActionEvent event) {
        // ... lógica para salvar o departamento ...
        service.saveOrUpdate(entity);
        notifyDataChangeListeners(); // Notifica que os dados mudaram
        Utils.currentStage(event).close();
    }
}
```

**3. `DepartmentListController.java` (O Observador)**
Este controller implementa a interface e se inscreve para receber as notificações.

```java
public class DepartmentListController implements Initializable, DataChangeListener {
    // ...
    @Override
    public void onDataChanged() {
        updateTableView(); // Ação a ser executada quando notificado
    }
    // No método createDialogForm, ele se inscreve:
    // controller.subscribeDataChangeListener(this);
}
```

### **Fase 4: Adicionando Botões de Ação na `TableView`**

Para permitir a edição e exclusão diretamente na lista, adicionamos colunas com botões. Isso é feito programaticamente usando `CellFactory`.

```java
// Dentro de DepartmentListController.java
@FXML private TableColumn<Department, Department> tableColumnEDIT;

// Adicione este método e chame-o no initialize()
private void initEditButtons() {
    // Define a fábrica de células para a coluna de edição
    tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
    tableColumnEDIT.setCellFactory(param -> new TableCell<Department, Department>() {
        private final Button button = new Button("edit");

        @Override
        protected void updateItem(Department obj, boolean empty) {
            super.updateItem(obj, empty);
            if (obj == null) {
                setGraphic(null);
                return;
            }
            // Adiciona o botão à célula
            setGraphic(button);
            // Define a ação do botão
            button.setOnAction(
                event -> createDialogForm(obj, "/com/yourproject/gui/DepartmentForm.fxml", Utils.currentStage(event)));
        }
    });
}
```

A lógica para o botão de remoção é similar, mas sua ação chamaria um método `removeEntity(obj)` que, por sua vez, invoca `service.remove(obj)` e trata `DbIntegrityException`.

### **Fase 5: Implementando o CRUD de Vendedores e Componentes Avançados**

A implementação do CRUD de `Seller` segue o mesmo padrão do `Department`, mas introduz novos desafios:

  * **Formatação de Colunas**: Use métodos utilitários para formatar datas e valores `Double` na `TableView`.
  * **`DatePicker`**: No formulário do vendedor, utilize o componente `DatePicker` para o campo de data de nascimento.
  * **`ComboBox` para Associação**: Adicione um `ComboBox` no formulário do vendedor para selecionar o `Department`. Este ComboBox deve ser populado buscando todos os departamentos através do `DepartmentService`.

### **Fase 6: Empacotamento e Distribuição**

Após finalizar o desenvolvimento, o próximo passo é gerar um pacote executável.

1.  **Exportar JAR Executável**: No Eclipse, clique com o botão direito no projeto -\> `Export...` -\> `Java` -\> `Runnable JAR file`.

      * Selecione a classe `Main` da sua aplicação.
      * Escolha um diretório de destino.
      * Em `Library handling`, selecione a opção: **"Package required libraries into generated JAR"**.

2.  **Preparar a Pasta de Distribuição**: Crie uma pasta e coloque nela:

      * O arquivo `.jar` que você gerou.
      * O arquivo `db.properties`.
      * Uma pasta `lib` contendo o `mysql-connector.jar`.

3.  **Executar a Aplicação**:
    Para executar, o usuário final precisará do Java e do JavaFX SDK. O comando de execução via terminal, que pode ser colocado em um arquivo `.bat` (Windows) ou `.sh` (Linux/Mac) para facilitar, é:

    ```bash
    java --module-path /caminho/para/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -jar SeuAplicativo.jar
    ```

Este guia abrange o ciclo de vida completo do projeto, desde a arquitetura e configuração até a implementação de funcionalidades complexas e a distribuição final da aplicação.