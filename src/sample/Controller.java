package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.Date;

public class Controller {
    private static int countId = 0;
//    private ObservableList<Employee> arrayWorkers = FXCollections.observableArrayList(
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 70000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00"),
//       new Employee(countId++,"Иван","Иванов","Иванович","Инженер", 50000,"10.01.1975","mail@mail.ru","8-916-000-00-00")
//    );

    private ObservableList<Employee> arrayWorkers = FXCollections.observableArrayList();
    //Table
    @FXML private TableView<Employee> tableWorkers;
    @FXML private TableColumn<Employee,Integer> idColumnn;
    @FXML private TableColumn<Employee,String> nameColumn;
    @FXML private TableColumn<Employee,String> lastnameColumn;
    @FXML private TableColumn<Employee,String> patronymicColumn;
    @FXML private TableColumn<Employee,String> position;
    @FXML private TableColumn<Employee,Integer> salary;
    @FXML private TableColumn<Employee,String> happybirthdayColumn;
    @FXML private TableColumn<Employee,String> emailColumn;
    @FXML private TableColumn<Employee,String> phoneColumn;

    //TextFields
    @FXML private TextField nameTF;
    @FXML private TextField lastnameTF;
    @FXML private TextField patronymicTF;
    @FXML private TextField positionTF;
    @FXML private TextField salaryTF;
    @FXML private TextField happybirthdayTF;
    @FXML private TextField emailTF;
    @FXML private TextField phoneTF;

    @FXML private Label congrLabel;

    @FXML
    private void initialize() {

        try {
            String urlBD = "jdbc:mysql://MY_SQLDB?useSSL=false";
            Connection con = DriverManager.getConnection(urlBD,"MY_USER_BD","MY_PASSWORD_BD");
            Statement st = con.createStatement();
            String query = "SELECT * FROM Workers";
            ResultSet res = st.executeQuery(query);
            while(res.next()) {
                int id = res.getInt(1);
                String name = res.getString(2);
                String lastname = res.getString(3);
                String patronymic = res.getString(4);
                String position = res.getString(5);
                int salary = res.getInt(6);
                String hb = res.getString(7);
                String email = res.getString(8);
                String phone = res.getString(9);
                arrayWorkers.add(new Employee(id,name,lastname,patronymic,position,salary,hb,email,phone));
                countId++;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        idColumnn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastname"));
        patronymicColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("patronymic"));
        position.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
        happybirthdayColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("happybirthday"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone"));
        tableWorkers.setItems(arrayWorkers);
    }


    @FXML
    private void btnAddWorkers(ActionEvent event) {
        ObservableList<Employee> arr = tableWorkers.getItems();
        String name = nameTF.getText();
        String lastname = lastnameTF.getText();
        String patronymic = patronymicTF.getText();
        String position = positionTF.getText();
        String salary = salaryTF.getText();
        String happybirthday = happybirthdayTF.getText();
        String email = emailTF.getText();
        String phone = phoneTF.getText();
            if(!name.equals("") && !lastname.equals("")) {
                arr.add(new Employee(++countId,name,lastname,patronymic,position,Integer.parseInt(salary),happybirthday,email,phone));

                try {
                    String urlBD = "jdbc:mysql://MY_SQLDB?useSSL=false";
                    Connection con = DriverManager.getConnection(urlBD,"MY_USER_BD","MY_PASSWORD_BD");
                    PreparedStatement ps = con.prepareStatement("INSERT INTO Workers (id,name,lastname,patronymic," +
                                                                    "position,salary,happybirthday,email,phone) " +
                                                                    "VALUES(null,?,?,?,?,?,?,?,?)");
                    ps.setString(1,name);
                    ps.setString(2,lastname);
                    ps.setString(3,patronymic);
                    ps.setString(4,position);
                    ps.setInt(5,Integer.parseInt(salary));
                    ps.setString(6,happybirthday);
                    ps.setString(7,email);
                    ps.setString(8,phone);
                    ps.executeUpdate();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                congrLabel.setVisible(true);
                nameTF.setText("");
                lastnameTF.setText("");
                patronymicTF.setText("");
                positionTF.setText("");
                salaryTF.setText("");
                happybirthdayTF.setText("");
                emailTF.setText("");
                phoneTF.setText("");
            }



    }


}
