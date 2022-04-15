package Programmeren2.Gui.ContentItem;

import java.util.ArrayList;
import java.util.List;

import Programmeren2.Database.DBContentItem;
import Programmeren2.Database.DBCourse;
import Programmeren2.Domain.ContentItem;
import Programmeren2.Domain.Course;
import Programmeren2.Domain.Module;
import Programmeren2.Domain.Webcast;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GContentItem {
    public static void showWindow(Stage window) {
        window.setTitle("CodeCademy | Modules and Webcasts");

        DBContentItem dbContentItem = new DBContentItem();

        List<Module> modules = new ArrayList<>();
        modules = dbContentItem.getModules();

        TableView<Module> mTableView = new TableView<>();

        TableColumn<Module, String> mColumn1 = new TableColumn<>("Title");
        mColumn1.setCellValueFactory(new PropertyValueFactory<>("Title"));
        mColumn1.prefWidthProperty().bind(mTableView.widthProperty().divide(8));

        TableColumn<Module, String> mColumn2 = new TableColumn<>("Description");
        mColumn2.setCellValueFactory(new PropertyValueFactory<>("Description"));
        mColumn2.prefWidthProperty().bind(mTableView.widthProperty().divide(3.7));

        TableColumn<Module, String> mColumn3 = new TableColumn<>("Publication Date");
        mColumn3.setCellValueFactory(new PropertyValueFactory<>("PublicationDate"));
        mColumn3.prefWidthProperty().bind(mTableView.widthProperty().divide(10));

        TableColumn<Module, String> mColumn4 = new TableColumn<>("Status");
        mColumn4.setCellValueFactory(new PropertyValueFactory<>("Status"));
        mColumn4.prefWidthProperty().bind(mTableView.widthProperty().divide(10));

        TableColumn<Module, String> mColumn5 = new TableColumn<>("Serialnumber");
        mColumn5.setCellValueFactory(new PropertyValueFactory<>("ContentItemId"));
        mColumn5.prefWidthProperty().bind(mTableView.widthProperty().divide(10));

        TableColumn<Module, String> mColumn6 = new TableColumn<>("Version");
        mColumn6.setCellValueFactory(new PropertyValueFactory<>("Version"));
        mColumn6.prefWidthProperty().bind(mTableView.widthProperty().divide(10));

        TableColumn<Module, String> mColumn7 = new TableColumn<>("Contact name");
        mColumn7.setCellValueFactory(new PropertyValueFactory<>("Status"));
        mColumn7.prefWidthProperty().bind(mTableView.widthProperty().divide(10));

        TableColumn<Module, String> mColumn8 = new TableColumn<>("Contact email");
        mColumn8.setCellValueFactory(new PropertyValueFactory<>("Status"));
        mColumn8.prefWidthProperty().bind(mTableView.widthProperty().divide(10));

        mTableView.getColumns().add(mColumn1);
        mTableView.getColumns().add(mColumn2);
        mTableView.getColumns().add(mColumn3);
        mTableView.getColumns().add(mColumn4);
        mTableView.getColumns().add(mColumn5);
        mTableView.getColumns().add(mColumn6);
        mTableView.getColumns().add(mColumn7);
        mTableView.getColumns().add(mColumn8);

        for (Module Module : modules) {
            mTableView.getItems().add(Module);
        }
        
        //------------------------------------------------------------------------
        
        List<Webcast> webcasts = new ArrayList<>();
        webcasts = dbContentItem.getWebcasts();

        TableView<Webcast> wTableView = new TableView<>();

        TableColumn<Webcast, String> wColumn1 = new TableColumn<>("Title");
        wColumn1.setCellValueFactory(new PropertyValueFactory<>("Title"));
        wColumn1.prefWidthProperty().bind(wTableView.widthProperty().divide(8));

        TableColumn<Webcast, String> wColumn2 = new TableColumn<>("Description");
        wColumn2.setCellValueFactory(new PropertyValueFactory<>("Description"));
        wColumn2.prefWidthProperty().bind(wTableView.widthProperty().divide(3.7));

        TableColumn<Webcast, String> wColumn3 = new TableColumn<>("Publication Date");
        wColumn3.setCellValueFactory(new PropertyValueFactory<>("PublicationDate"));
        wColumn3.prefWidthProperty().bind(wTableView.widthProperty().divide(8));

        TableColumn<Webcast, String> wColumn4 = new TableColumn<>("Status");
        wColumn4.setCellValueFactory(new PropertyValueFactory<>("Status"));
        wColumn4.prefWidthProperty().bind(wTableView.widthProperty().divide(9));

        TableColumn<Webcast, String> wColumn5 = new TableColumn<>("Serialnumber");
        wColumn5.setCellValueFactory(new PropertyValueFactory<>("ContentItemId"));
        wColumn5.prefWidthProperty().bind(wTableView.widthProperty().divide(9));

        TableColumn<Webcast, String> wColumn6 = new TableColumn<>("Speaker name");
        wColumn6.setCellValueFactory(new PropertyValueFactory<>("Speaker"));
        wColumn6.prefWidthProperty().bind(wTableView.widthProperty().divide(8));

        TableColumn<Webcast, String> wColumn7 = new TableColumn<>("Organisation");
        wColumn7.setCellValueFactory(new PropertyValueFactory<>("Organisation"));
        wColumn7.prefWidthProperty().bind(wTableView.widthProperty().divide(7.5));

        wTableView.getColumns().add(wColumn1);
        wTableView.getColumns().add(wColumn2);
        wTableView.getColumns().add(wColumn3);
        wTableView.getColumns().add(wColumn4);
        wTableView.getColumns().add(wColumn5);
        wTableView.getColumns().add(wColumn6);
        wTableView.getColumns().add(wColumn7);

        for (Webcast webcast : webcasts) {
            wTableView.getItems().add(webcast);
        }

        TabPane tabPane = new TabPane();

        Tab modulesTab = new Tab("Modules");
        modulesTab.setContent(mTableView);

        Tab webcastsTab = new Tab("Webcasts");
        webcastsTab.setContent(wTableView);

        tabPane.getTabs().addAll(modulesTab, webcastsTab);

        Scene scene = new Scene(tabPane);
        window.setScene(scene);
    }
}