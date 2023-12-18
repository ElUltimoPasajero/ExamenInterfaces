package com.example.nuevoparking;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {


    @FXML
    private TableView tablaEntradas;


    @FXML
    private ImageView imgLogo;


    @FXML
    private TextField txtMatricula;
    @FXML
    private ChoiceBox choizCliente;
    @FXML
    private RadioButton radioStandard;
    @FXML
    private RadioButton radioOferta;
    @FXML
    private RadioButton radioLargaDuracion;
    @FXML
    private DatePicker datepickEntrada;
    @FXML
    private DatePicker datePickSalida;
    @FXML
    private Label lblCoste;
    @FXML
    private Button btnAñadirALaTabla;
    @FXML
    private Button btnSalidAplicacion;
    @FXML
    private TableColumn <Entrada, String>columnMatricula;
    @FXML
    private TableColumn <Entrada, String> columnModelo;
    @FXML
    private TableColumn<Entrada, String> columnFechaEntrada;
    @FXML
    private TableColumn <Entrada, String>columnFechaSalida;
    @FXML
    private TableColumn<Entrada, String> columnCliente;
    @FXML
    private TableColumn <Entrada, String>columnTarifa;
    @FXML
    private TableColumn <Entrada, Double>columnCoste;
    @FXML
    private ComboBox comboModelo;
    @FXML
    private ToggleGroup togleGroupRadios;
    private ObservableList<Entrada> observableListEntradas = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Cliente cliente2=(new Cliente(2,"Manuel","Manuel@hotmail.com"));
            Cliente cliente3 =(new Cliente(3,"Pepe","migueñl2@hotmail.com"));


        if (Session.getEntradas().isEmpty()){

            ArrayList<Entrada> entradas = new ArrayList<>();
            entradas.add(new Entrada("reewrhg","Ford", LocalDate.now(),LocalDate.now(),cliente2,"Standard", 9.0));
            entradas.add(new Entrada("reewrhg","Peugeot", LocalDate.now(),LocalDate.now(),cliente3,"Oferta", 7.0));
            Session.setEntradas(entradas);


            ObservableList<String> nombresClientes = FXCollections.observableArrayList(
                    "Pepillo", "Juan", "Alberto"
            );
            choizCliente.setItems(nombresClientes);



            // Inicializar valores ficticios para el ComboBox de Modelo
            ObservableList<String> modelosFicticios = FXCollections.observableArrayList(
                    "Honda", "Mitshubishi", "Nissan", "Kia"
            );
            comboModelo.setItems(modelosFicticios);

            columnMatricula.setCellValueFactory( (fila) -> {
                String matricula = fila.getValue().getMatricula();
                return new SimpleStringProperty( matricula );
            });
            columnModelo.setCellValueFactory( (fila) -> {
                String modelo = fila.getValue().getModelo();
                return new SimpleStringProperty( modelo );
            });
            columnFechaEntrada.setCellValueFactory( (fila) -> {
                String fechaEntrada = fila.getValue().getFechaEntrada().toString();
                return new SimpleStringProperty( fechaEntrada );
            });
            columnFechaSalida.setCellValueFactory( (fila) -> {
                String fechaSalida = fila.getValue().getFechaSalida().toString();
                return new SimpleStringProperty( fechaSalida );
            });
            columnCliente.setCellValueFactory( (fila) -> {
                String cliente = fila.getValue().getCliente().getNombre();
                return new SimpleStringProperty( cliente );
            });
            columnFechaSalida.setCellValueFactory( (fila) -> {
                String fechaSalida = fila.getValue().getFechaSalida().toString();
                return new SimpleStringProperty( fechaSalida );
            });
            columnTarifa.setCellValueFactory( (fila) -> {
                String tarifa = fila.getValue().getTarifa();
                return new SimpleStringProperty( tarifa );
            });
            columnCoste.setCellValueFactory( (fila) -> {
                Double coste = fila.getValue().getCoste();
                return new SimpleObjectProperty<>( coste );
            });
    }

        observableListEntradas.addAll(Session.getEntradas());

        tablaEntradas.setItems(observableListEntradas);



    }

    @FXML
    public void añadirALaTabla(ActionEvent actionEvent) {
        // Obtener los valores de los campos
        String matricula = txtMatricula.getText();
        String modelo = (String) comboModelo.getValue();
        LocalDate fechaEntrada = datepickEntrada.getValue();
        LocalDate fechaSalida = datePickSalida.getValue();
        Cliente cliente = (Cliente) choizCliente.getValue();

        // Verificar si al menos un RadioButton está seleccionado
        boolean algunaTarifaSeleccionada = radioStandard.isSelected() || radioLargaDuracion.isSelected() || radioOferta.isSelected();

        if (matricula.isEmpty() || modelo == null || fechaEntrada == null || fechaSalida == null || cliente == null || !algunaTarifaSeleccionada) {
            mostrarAlerta("Error", "Todos los campos, incluyendo al menos una tarifa, deben estar llenos.");
        } else {

            limpiarCampos();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void limpiarCampos() {
        // Limpia los campos después de añadir a la tabla si es necesario
        txtMatricula.clear();
        comboModelo.getSelectionModel().clearSelection();
        datepickEntrada.setValue(null);
        datePickSalida.setValue(null);
        choizCliente.getSelectionModel().clearSelection();
        // Limpia otros campos según sea necesario
    }

    @FXML
    public void salirApp(ActionEvent actionEvent) {
        System.exit(0);
    }
}

