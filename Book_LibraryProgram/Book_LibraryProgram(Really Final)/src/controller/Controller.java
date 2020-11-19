package controller;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Book;

/**
 * This class enables to interact between the interface and the model class.
 * 
 * @author Seokwoo Ha
 *
 */
public class Controller {

	/**
	 * The table in the program.
	 */
	@FXML
	private TableView<Book> searchTable;

	/**
	 * The first column of the table.
	 */
	@FXML
	private TableColumn<Book, Integer> searchc1RowID;

	/**
	 * The second column of the table.
	 */
	@FXML
	private TableColumn<Book, String> searchc2Author;

	/**
	 * The third column of the table.
	 */
	@FXML
	private TableColumn<Book, String> searchc3Title;

	/**
	 * The fourth column of the table.
	 */
	@FXML
	private TableColumn<Book, String> searchc4Genre;

	/**
	 * The fifth column of the table.
	 */
	@FXML
	private TableColumn<Book, String> searchc5Location;

	/**
	 * The textbox for author.
	 */
	@FXML
	private TextField updateAuthor;

	/**
	 * The textbox for title.
	 */
	@FXML
	private TextField updateTitle;

	/**
	 * The textbox for genre.
	 */
	@FXML
	private TextField updateGenre;

	/**
	 * The textbox for location.
	 */
	@FXML
	private TextField updateLocation;

	/**
	 * The textbox for searchByAny.
	 */
	@FXML
	private TextField searchByAny;

	/**
	 * The textbox for searchByAuthor.
	 */
	@FXML
	private TextField searchByAuthor;

	/**
	 * The textbox for searchByTitle.
	 */
	@FXML
	private TextField searchByTitle;

	/**
	 * The textbox for searchByGenre.
	 */
	@FXML
	private TextField searchByGenre;

	/**
	 * The textbox for searchByLocation.
	 */
	@FXML
	private TextField searchByLocation;

	/**
	 * The textbox for searchByRowID.
	 */
	@FXML
	private TextField searchByRowID;

	/**
	 * The button for delete.
	 */
	@FXML
	private Button buttonDelete;

	/**
	 * The button for delete.
	 */
	@FXML
	private Button buttonUpdate;

	/**
	 * The button for search.
	 */
	@FXML
	private Button buttonSearch;

	/**
	 * The button for reset.
	 */
	@FXML
	private Button buttonSearchClear;

	/**
	 * The button for create.
	 */
	@FXML
	private Button buttonCreate;

	/**
	 * The combobox for selecting search methods.
	 */
	@FXML
	private ComboBox combobox1;

	/**
	 * Teh combobox for selecting create, update, or delete.
	 */
	@FXML
	private ComboBox combobox2;

	/**
	 * The label for search by any.
	 */
	@FXML
	private Label labelSearchByAny;

	/**
	 * The label for search by author.
	 */
	@FXML
	private Label labelSearchByAuthor;

	/**
	 * The label for search by title.
	 */
	@FXML
	private Label labelSearchByTitle;

	/**
	 * The label for search by genre.
	 */
	@FXML
	private Label labelSearchByGenre;

	/**
	 * The label for search by location.
	 */
	@FXML
	private Label labelSearchByLocation;

	/**
	 * The label for search by row ID.
	 */
	@FXML
	private Label labelSearchByRowID;

	/**
	 * The label for update author textbox.
	 */
	@FXML
	private Label labelUpdateAuthor;

	/**
	 * The label for update title textbox.
	 */
	@FXML
	private Label labelUpdateTitle;

	/**
	 * The label for update genre textbox.
	 */
	@FXML
	private Label labelUpdateGenre;

	/**
	 * The label for update location textbox.
	 */
	@FXML
	private Label labelUpdateLocation;

	/**
	 * The label for update instructions.
	 */
	@FXML
	private Label labelUpdate;

	/**
	 * The label for update instructions.
	 */
	@FXML
	private Label labelUpdate1;

	/**
	 * The label for update instructions.
	 */
	@FXML
	private Label labelUpdate2;

	/**
	 * The label for update instructions.
	 */
	@FXML
	private Label labelUpdate3;

	/**
	 * The label for delete instructions.
	 */
	@FXML
	private Label labelDelete1;

	/**
	 * The label for delete instructions.
	 */
	@FXML
	private Label labelDelete2;

	/**
	 * The label for delete instructions.
	 */
	@FXML
	private Label labelDelete3;

	/**
	 * The label for delete instructions.
	 */
	@FXML
	private Label labelDelete4;

	/**
	 * The label for create instructions.
	 */
	@FXML
	private Label labelCreate;

	/**
	 * The label for create instructions.
	 */
	@FXML
	private Label labelCreate1;

	/**
	 * Set the comboboxes and table.
	 * 
	 * @throws SQLException Throws errors if it exists.
	 */
	@FXML
	private void initialize() throws SQLException {
		// Set the comboboxes values.
		combobox1.getItems().setAll("By Any", "By Author", "By Title", "By Genre", "By Location", "By RowID");
		combobox2.getItems().setAll("Update", "Create", "Delete");

		// Set the table values.
		searchc1RowID.setCellValueFactory(new PropertyValueFactory<Book, Integer>("rowID"));
		searchc2Author.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));
		searchc3Title.setCellValueFactory(new PropertyValueFactory<Book, String>("Title"));
		searchc4Genre.setCellValueFactory(new PropertyValueFactory<Book, String>("Genre"));
		searchc5Location.setCellValueFactory(new PropertyValueFactory<Book, String>("Location"));
		searchTable.getItems().addAll(Book.getAllBooks());
	}

	/**
	 * 
	 * @param event Get the information if the user double click the table.
	 * @throws SQLException Throws errors if it exists.
	 */
	@FXML
	private void getInfo(final MouseEvent event) throws SQLException {
		Alert message = new Alert(AlertType.INFORMATION);
		if (event.getClickCount() == 1) {
			// Throw messages to the user and let the user to select an item.
			if (searchTable.getSelectionModel().isEmpty()) {
				message.setTitle("Alert");
				message.setContentText("There are no items in the table.");
				message.showAndWait();
			} else {
				updateAuthor.setText(String.valueOf(searchTable.getSelectionModel().getSelectedItem().getAuthor()));
				updateTitle.setText(String.valueOf(searchTable.getSelectionModel().getSelectedItem().getTitle()));
				updateGenre.setText(String.valueOf(searchTable.getSelectionModel().getSelectedItem().getGenre()));
				updateLocation.setText(String.valueOf(searchTable.getSelectionModel().getSelectedItem().getLocation()));
			}
		}
	}

	/**
	 * 
	 * @param e Get the information for the user when they press enter key.
	 */
	@FXML
	public void buttonPressed(final KeyEvent e) {
		Alert message = new Alert(AlertType.INFORMATION);
		if (e.getCode().toString().equals("ENTER")) {
			if (searchTable.getSelectionModel().isEmpty()) {
				message.setTitle("Alert");
				message.setContentText("There are no items in the table.");
				message.showAndWait();
			} else {
				updateAuthor.setText(String.valueOf(searchTable.getSelectionModel().getSelectedItem().getAuthor()));
				updateTitle.setText(String.valueOf(searchTable.getSelectionModel().getSelectedItem().getTitle()));
				updateGenre.setText(String.valueOf(searchTable.getSelectionModel().getSelectedItem().getGenre()));
				updateLocation.setText(String.valueOf(searchTable.getSelectionModel().getSelectedItem().getLocation()));
			}
		}
	}

	/**
	 * Enable the visibility of textboxes and labels according to user's choice.
	 * 
	 * @throws SQLException Throws errors if it exists.
	 */
	@FXML
	private void setSearchEnabled() throws SQLException {
		String p = (String) combobox1.getSelectionModel().getSelectedItem().toString();

		// Show labels and textboxes according to users choices.
		if ("By Any".equals(p)) {
			buttonSearch.setDefaultButton(true);
			buttonUpdate.setDefaultButton(false);
			buttonCreate.setDefaultButton(false);
			buttonDelete.setDefaultButton(false);
			buttonSearchClear.setDefaultButton(false);
			combobox2.setValue(combobox2.getPromptText());
			labelUpdate1.setVisible(false);
			labelUpdate2.setVisible(false);
			labelUpdate3.setVisible(false);
			labelDelete1.setVisible(false);
			labelDelete2.setVisible(false);
			labelDelete3.setVisible(false);
			labelDelete4.setVisible(false);
			labelSearchByAny.setVisible(true);
			labelSearchByAuthor.setVisible(false);
			labelSearchByTitle.setVisible(false);
			labelSearchByGenre.setVisible(false);
			labelSearchByLocation.setVisible(false);
			labelSearchByRowID.setVisible(false);
			labelUpdateAuthor.setVisible(false);
			labelUpdateGenre.setVisible(false);
			labelUpdateLocation.setVisible(false);
			labelUpdateTitle.setVisible(false);
			labelCreate.setVisible(false);
			searchByAny.setVisible(true);
			searchByAuthor.setVisible(false);
			searchByTitle.setVisible(false);
			searchByGenre.setVisible(false);
			searchByLocation.setVisible(false);
			searchByRowID.setVisible(false);
			updateAuthor.setVisible(false);
			updateGenre.setVisible(false);
			updateLocation.setVisible(false);
			updateTitle.setVisible(false);
			buttonUpdate.setVisible(false);
			buttonSearch.setVisible(true);
			buttonCreate.setVisible(false);
			buttonDelete.setVisible(false);
			searchByAuthor.setText("");
			searchByTitle.setText("");
			searchByGenre.setText("");
			searchByLocation.setText("");
			searchByRowID.setText("");
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
		} else if ("By Author".equals(p)) {
			buttonSearch.setDefaultButton(true);
			buttonUpdate.setDefaultButton(false);
			buttonCreate.setDefaultButton(false);
			buttonDelete.setDefaultButton(false);
			buttonSearchClear.setDefaultButton(false);
			combobox2.setValue(combobox2.getPromptText());
			labelUpdate1.setVisible(false);
			labelUpdate2.setVisible(false);
			labelUpdate3.setVisible(false);
			labelDelete1.setVisible(false);
			labelDelete2.setVisible(false);
			labelDelete3.setVisible(false);
			labelDelete4.setVisible(false);
			labelSearchByAny.setVisible(false);
			labelSearchByAuthor.setVisible(true);
			labelSearchByTitle.setVisible(false);
			labelSearchByGenre.setVisible(false);
			labelSearchByLocation.setVisible(false);
			labelSearchByRowID.setVisible(false);
			labelUpdateAuthor.setVisible(false);
			labelUpdateGenre.setVisible(false);
			labelUpdateLocation.setVisible(false);
			labelUpdateTitle.setVisible(false);
			labelCreate.setVisible(false);
			searchByAny.setVisible(false);
			searchByAuthor.setVisible(true);
			searchByTitle.setVisible(false);
			searchByGenre.setVisible(false);
			searchByLocation.setVisible(false);
			searchByRowID.setVisible(false);
			updateAuthor.setVisible(false);
			updateGenre.setVisible(false);
			updateLocation.setVisible(false);
			updateTitle.setVisible(false);
			buttonUpdate.setVisible(false);
			buttonSearch.setVisible(true);
			buttonCreate.setVisible(false);
			buttonDelete.setVisible(false);
			searchByAny.setText("");
			searchByTitle.setText("");
			searchByGenre.setText("");
			searchByLocation.setText("");
			searchByRowID.setText("");
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
		} else if ("By Title".equals(p)) {
			buttonSearch.setDefaultButton(true);
			buttonUpdate.setDefaultButton(false);
			buttonCreate.setDefaultButton(false);
			buttonDelete.setDefaultButton(false);
			buttonSearchClear.setDefaultButton(false);
			combobox2.setValue(combobox2.getPromptText());
			labelUpdate1.setVisible(false);
			labelUpdate2.setVisible(false);
			labelUpdate3.setVisible(false);
			labelDelete1.setVisible(false);
			labelDelete2.setVisible(false);
			labelDelete3.setVisible(false);
			labelDelete4.setVisible(false);
			labelSearchByAny.setVisible(false);
			labelSearchByAuthor.setVisible(false);
			labelSearchByTitle.setVisible(true);
			labelSearchByGenre.setVisible(false);
			labelSearchByLocation.setVisible(false);
			labelSearchByRowID.setVisible(false);
			labelUpdateAuthor.setVisible(false);
			labelUpdateGenre.setVisible(false);
			labelUpdateLocation.setVisible(false);
			labelUpdateTitle.setVisible(false);
			labelCreate.setVisible(false);
			searchByAny.setVisible(false);
			searchByAuthor.setVisible(false);
			searchByTitle.setVisible(true);
			searchByGenre.setVisible(false);
			searchByLocation.setVisible(false);
			searchByRowID.setVisible(false);
			updateAuthor.setVisible(false);
			updateGenre.setVisible(false);
			updateLocation.setVisible(false);
			updateTitle.setVisible(false);
			buttonUpdate.setVisible(false);
			buttonSearch.setVisible(true);
			buttonCreate.setVisible(false);
			buttonDelete.setVisible(false);
			searchByAny.setText("");
			searchByAuthor.setText("");
			searchByGenre.setText("");
			searchByLocation.setText("");
			searchByRowID.setText("");
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
		} else if ("By Genre".equals(p)) {
			buttonSearch.setDefaultButton(true);
			buttonUpdate.setDefaultButton(false);
			buttonCreate.setDefaultButton(false);
			buttonDelete.setDefaultButton(false);
			buttonSearchClear.setDefaultButton(false);
			combobox2.setValue(combobox2.getPromptText());
			labelUpdate1.setVisible(false);
			labelUpdate2.setVisible(false);
			labelUpdate3.setVisible(false);
			labelDelete1.setVisible(false);
			labelDelete2.setVisible(false);
			labelDelete3.setVisible(false);
			labelDelete4.setVisible(false);
			labelSearchByAny.setVisible(false);
			labelSearchByAuthor.setVisible(false);
			labelSearchByTitle.setVisible(false);
			labelSearchByGenre.setVisible(true);
			labelSearchByLocation.setVisible(false);
			labelSearchByRowID.setVisible(false);
			labelUpdateAuthor.setVisible(false);
			labelUpdateGenre.setVisible(false);
			labelUpdateLocation.setVisible(false);
			labelUpdateTitle.setVisible(false);
			labelCreate.setVisible(false);
			searchByAny.setVisible(false);
			searchByAuthor.setVisible(false);
			searchByTitle.setVisible(false);
			searchByGenre.setVisible(true);
			searchByLocation.setVisible(false);
			searchByRowID.setVisible(false);
			updateAuthor.setVisible(false);
			updateGenre.setVisible(false);
			updateLocation.setVisible(false);
			updateTitle.setVisible(false);
			buttonUpdate.setVisible(false);
			buttonSearch.setVisible(true);
			buttonCreate.setVisible(false);
			buttonDelete.setVisible(false);
			searchByAny.setText("");
			searchByAuthor.setText("");
			searchByTitle.setText("");
			searchByLocation.setText("");
			searchByRowID.setText("");
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
		} else if ("By Location".equals(p)) {
			buttonSearch.setDefaultButton(true);
			buttonUpdate.setDefaultButton(false);
			buttonCreate.setDefaultButton(false);
			buttonDelete.setDefaultButton(false);
			buttonSearchClear.setDefaultButton(false);
			combobox2.setValue(combobox2.getPromptText());
			labelUpdate1.setVisible(false);
			labelUpdate2.setVisible(false);
			labelUpdate3.setVisible(false);
			labelDelete1.setVisible(false);
			labelDelete2.setVisible(false);
			labelDelete3.setVisible(false);
			labelDelete4.setVisible(false);
			labelSearchByAny.setVisible(false);
			labelSearchByAuthor.setVisible(false);
			labelSearchByTitle.setVisible(false);
			labelSearchByGenre.setVisible(false);
			labelSearchByLocation.setVisible(true);
			labelSearchByRowID.setVisible(false);
			labelUpdateAuthor.setVisible(false);
			labelUpdateGenre.setVisible(false);
			labelUpdateLocation.setVisible(false);
			labelUpdateTitle.setVisible(false);
			labelCreate.setVisible(false);
			searchByAny.setVisible(false);
			searchByAuthor.setVisible(false);
			searchByTitle.setVisible(false);
			searchByGenre.setVisible(false);
			searchByLocation.setVisible(true);
			searchByRowID.setVisible(false);
			updateAuthor.setVisible(false);
			updateGenre.setVisible(false);
			updateLocation.setVisible(false);
			updateTitle.setVisible(false);
			buttonUpdate.setVisible(false);
			buttonSearch.setVisible(true);
			buttonCreate.setVisible(false);
			buttonDelete.setVisible(false);
			searchByAny.setText("");
			searchByAuthor.setText("");
			searchByTitle.setText("");
			searchByGenre.setText("");
			searchByRowID.setText("");
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
		} else if ("By RowID".equals(p)) {
			buttonSearch.setDefaultButton(true);
			buttonUpdate.setDefaultButton(false);
			buttonCreate.setDefaultButton(false);
			buttonDelete.setDefaultButton(false);
			buttonSearchClear.setDefaultButton(false);
			combobox2.setValue(combobox2.getPromptText());
			labelUpdate1.setVisible(false);
			labelUpdate2.setVisible(false);
			labelUpdate3.setVisible(false);
			labelDelete1.setVisible(false);
			labelDelete2.setVisible(false);
			labelDelete3.setVisible(false);
			labelDelete4.setVisible(false);
			labelSearchByAny.setVisible(false);
			labelSearchByAuthor.setVisible(false);
			labelSearchByTitle.setVisible(false);
			labelSearchByGenre.setVisible(false);
			labelSearchByLocation.setVisible(false);
			labelSearchByRowID.setVisible(true);
			labelUpdateAuthor.setVisible(false);
			labelUpdateGenre.setVisible(false);
			labelUpdateLocation.setVisible(false);
			labelUpdateTitle.setVisible(false);
			labelCreate.setVisible(false);
			searchByAny.setVisible(false);
			searchByAuthor.setVisible(false);
			searchByTitle.setVisible(false);
			searchByGenre.setVisible(false);
			searchByLocation.setVisible(false);
			searchByRowID.setVisible(true);
			updateAuthor.setVisible(false);
			updateGenre.setVisible(false);
			updateLocation.setVisible(false);
			updateTitle.setVisible(false);
			buttonUpdate.setVisible(false);
			buttonSearch.setVisible(true);
			buttonCreate.setVisible(false);
			buttonDelete.setVisible(false);
			searchByAny.setText("");
			searchByAuthor.setText("");
			searchByTitle.setText("");
			searchByGenre.setText("");
			searchByLocation.setText("");
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
		} else {
			labelSearchByAny.setVisible(false);
			labelSearchByAuthor.setVisible(false);
			labelSearchByTitle.setVisible(false);
			labelSearchByGenre.setVisible(false);
			labelSearchByLocation.setVisible(false);
			labelSearchByRowID.setVisible(false);
			searchByAny.setVisible(false);
			searchByAuthor.setVisible(false);
			searchByTitle.setVisible(false);
			searchByGenre.setVisible(false);
			searchByLocation.setVisible(false);
			searchByRowID.setVisible(false);
			updateAuthor.setVisible(false);
			updateGenre.setVisible(false);
			updateLocation.setVisible(false);
			updateTitle.setVisible(false);
			labelUpdateAuthor.setVisible(false);
			labelUpdateGenre.setVisible(false);
			labelUpdateLocation.setVisible(false);
			labelUpdateTitle.setVisible(false);
			buttonSearch.setVisible(false);
			searchByAny.setText("");
			searchByAuthor.setText("");
			searchByTitle.setText("");
			searchByGenre.setText("");
			searchByLocation.setText("");
			searchByRowID.setText("");
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
		}
	}

	/**
	 * Enable the visibility of textboxes and labels according to user's choice.
	 * 
	 * @throws SQLException Throws errors if it exists.
	 */
	@FXML
	private void setUpdateDeleteCreateEnabled() throws SQLException {
		String p = (String) combobox2.getSelectionModel().getSelectedItem().toString();

		// Show labels and textboxes according to the user's choices.
		if ("Update".contentEquals(p)) {
			buttonSearch.setDefaultButton(false);
			buttonUpdate.setDefaultButton(true);
			buttonCreate.setDefaultButton(false);
			buttonDelete.setDefaultButton(false);
			buttonSearchClear.setDefaultButton(false);
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
			combobox1.setValue(combobox1.getPromptText());
			labelUpdate1.setVisible(true);
			labelUpdate2.setVisible(true);
			labelUpdate3.setVisible(true);
			labelUpdate.setVisible(true);
			labelCreate1.setVisible(false);
			labelDelete1.setVisible(false);
			labelDelete2.setVisible(false);
			labelDelete3.setVisible(false);
			labelDelete4.setVisible(false);
			labelUpdateAuthor.setVisible(true);
			labelUpdateGenre.setVisible(true);
			labelUpdateLocation.setVisible(true);
			labelUpdateTitle.setVisible(true);
			buttonUpdate.setVisible(true);
			buttonSearch.setVisible(false);
			buttonDelete.setVisible(false);
			buttonCreate.setVisible(false);
			updateAuthor.setVisible(true);
			updateGenre.setVisible(true);
			updateLocation.setVisible(true);
			updateTitle.setVisible(true);
			labelSearchByAny.setVisible(false);
			labelSearchByAuthor.setVisible(false);
			labelSearchByTitle.setVisible(false);
			labelSearchByGenre.setVisible(false);
			labelSearchByLocation.setVisible(false);
			labelSearchByRowID.setVisible(false);
			labelCreate.setVisible(false);
			searchByAny.setVisible(false);
			searchByAuthor.setVisible(false);
			searchByTitle.setVisible(false);
			searchByGenre.setVisible(false);
			searchByLocation.setVisible(false);
			searchByRowID.setVisible(false);
			searchByAny.setText("");
			searchByAuthor.setText("");
			searchByTitle.setText("");
			searchByGenre.setText("");
			searchByRowID.setText("");
		} else if ("Delete".contentEquals(p)) {
			buttonSearch.setDefaultButton(false);
			buttonUpdate.setDefaultButton(false);
			buttonCreate.setDefaultButton(false);
			buttonDelete.setDefaultButton(true);
			buttonSearchClear.setDefaultButton(false);
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
			combobox1.setValue(combobox1.getPromptText());
			labelUpdate1.setVisible(false);
			labelUpdate2.setVisible(false);
			labelUpdate3.setVisible(false);
			labelDelete1.setVisible(true);
			labelDelete2.setVisible(true);
			labelDelete3.setVisible(true);
			labelDelete4.setVisible(true);
			labelUpdate.setVisible(false);
			labelCreate1.setVisible(false);
			labelUpdateAuthor.setVisible(false);
			labelUpdateGenre.setVisible(false);
			labelUpdateLocation.setVisible(false);
			labelUpdateTitle.setVisible(false);
			buttonUpdate.setVisible(false);
			buttonSearch.setVisible(false);
			buttonDelete.setVisible(true);
			buttonCreate.setVisible(false);
			updateAuthor.setVisible(false);
			updateGenre.setVisible(false);
			updateLocation.setVisible(false);
			updateTitle.setVisible(false);
			labelSearchByAny.setVisible(false);
			labelSearchByAuthor.setVisible(false);
			labelSearchByTitle.setVisible(false);
			labelSearchByGenre.setVisible(false);
			labelSearchByLocation.setVisible(false);
			labelSearchByRowID.setVisible(false);
			labelCreate.setVisible(false);
			searchByAny.setVisible(false);
			searchByAuthor.setVisible(false);
			searchByTitle.setVisible(false);
			searchByGenre.setVisible(false);
			searchByLocation.setVisible(false);
			searchByRowID.setVisible(false);
			searchByAny.setText("");
			searchByAuthor.setText("");
			searchByTitle.setText("");
			searchByGenre.setText("");
			searchByRowID.setText("");
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
		} else if ("Create".contentEquals(p)) {
			buttonSearch.setDefaultButton(false);
			buttonUpdate.setDefaultButton(false);
			buttonCreate.setDefaultButton(true);
			buttonDelete.setDefaultButton(false);
			buttonSearchClear.setDefaultButton(false);
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
			combobox1.setValue(combobox1.getPromptText());
			labelUpdate.setVisible(false);
			labelCreate1.setVisible(true);
			labelCreate.setVisible(true);
			labelUpdate1.setVisible(false);
			labelUpdate2.setVisible(false);
			labelUpdate3.setVisible(false);
			labelDelete1.setVisible(false);
			labelDelete2.setVisible(false);
			labelDelete3.setVisible(false);
			labelDelete4.setVisible(false);
			labelUpdateAuthor.setVisible(true);
			labelUpdateGenre.setVisible(true);
			labelUpdateLocation.setVisible(true);
			labelUpdateTitle.setVisible(true);
			buttonUpdate.setVisible(false);
			buttonSearch.setVisible(false);
			buttonDelete.setVisible(false);
			buttonCreate.setVisible(true);
			updateAuthor.setVisible(true);
			updateGenre.setVisible(true);
			updateLocation.setVisible(true);
			updateTitle.setVisible(true);
			labelSearchByAny.setVisible(false);
			labelSearchByAuthor.setVisible(false);
			labelSearchByTitle.setVisible(false);
			labelSearchByGenre.setVisible(false);
			labelSearchByLocation.setVisible(false);
			labelSearchByRowID.setVisible(false);
			searchByAny.setVisible(false);
			searchByAuthor.setVisible(false);
			searchByTitle.setVisible(false);
			searchByGenre.setVisible(false);
			searchByLocation.setVisible(false);
			searchByRowID.setVisible(false);
			searchByAny.setText("");
			searchByAuthor.setText("");
			searchByTitle.setText("");
			searchByGenre.setText("");
			searchByRowID.setText("");
		} else {
			labelUpdate.setVisible(false);
			labelCreate1.setVisible(false);
			labelCreate.setVisible(false);
			labelUpdate1.setVisible(false);
			labelUpdate2.setVisible(false);
			labelUpdate3.setVisible(false);
			labelDelete1.setVisible(false);
			labelDelete2.setVisible(false);
			labelDelete3.setVisible(false);
			labelDelete4.setVisible(false);
			labelSearchByAny.setVisible(false);
			labelSearchByAuthor.setVisible(false);
			labelSearchByTitle.setVisible(false);
			labelSearchByGenre.setVisible(false);
			labelSearchByLocation.setVisible(false);
			labelSearchByRowID.setVisible(false);
			searchByAny.setVisible(false);
			searchByAuthor.setVisible(false);
			searchByTitle.setVisible(false);
			searchByGenre.setVisible(false);
			searchByLocation.setVisible(false);
			searchByRowID.setVisible(false);
			updateAuthor.setVisible(false);
			updateGenre.setVisible(false);
			updateLocation.setVisible(false);
			updateTitle.setVisible(false);
			labelUpdateAuthor.setVisible(false);
			labelUpdateGenre.setVisible(false);
			labelUpdateLocation.setVisible(false);
			labelUpdateTitle.setVisible(false);
			buttonSearch.setVisible(false);
			buttonUpdate.setVisible(false);
			buttonDelete.setVisible(false);
			buttonCreate.setVisible(false);
			searchByAny.setText("");
			searchByAuthor.setText("");
			searchByTitle.setText("");
			searchByGenre.setText("");
			searchByLocation.setText("");
			searchByRowID.setText("");
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
		}
	}

	/**
	 * Set functions on the search button.
	 * 
	 * @throws SQLException Throws errors if it exists.
	 */
	@FXML
	private void handleSearch() throws SQLException {

		Alert message = new Alert(AlertType.ERROR);
		boolean b = true, a = false;

		// Throws an error boxes if there's no selected items.
		// Otherwise, get inputs from the user.
		if (combobox1.getSelectionModel().isEmpty()
				|| combobox1.getSelectionModel().getSelectedItem().toString() == combobox1.getPromptText().toString()) {
			message.setTitle("Alert");
			message.setContentText("Please select a search method.");
			message.showAndWait();
		} else {
			if ("By Any".equals(combobox1.getSelectionModel().getSelectedItem().toString())) {
				// Let the user to fill the blank.
				if (searchByAny.getText().isEmpty() == b) {
					message.setTitle("Alert");
					message.setContentText("Please fill the blank.");
					message.showAndWait();
					searchByAny.requestFocus();

				} else {
					if (Book.isInteger(searchByAny.getText()) == b) {
						searchTable.getItems().clear();
						searchTable.getItems().addAll(Book.searchByRowID(Integer.parseInt(searchByAny.getText())));
					} else {
						searchTable.getItems().clear();
						searchTable.getItems().addAll(Book.searchByAny(searchByAny.getText()));
					}
				}
			} else if ("By Author".equals(combobox1.getSelectionModel().getSelectedItem().toString())) {
				// Let the user to fill the blank.
				if (searchByAuthor.getText().isEmpty() == b) {
					message.setTitle("Alert");
					message.setContentText("Please fill the blank.");
					message.showAndWait();
					searchByAuthor.requestFocus();

				} else {
					searchTable.getItems().clear();
					searchTable.getItems().addAll(Book.searchByAuthor(searchByAuthor.getText()));
				}
			} else if ("By Title".equals(combobox1.getSelectionModel().getSelectedItem().toString())) {
				// Let the user to fill the blank.
				if (searchByTitle.getText().isEmpty() == b) {
					message.setTitle("Alert");
					message.setContentText("Please fill the blank.");
					message.showAndWait();
					searchByTitle.requestFocus();

				} else {
					searchTable.getItems().clear();
					searchTable.getItems().addAll(Book.searchByTitle(searchByTitle.getText()));
				}
			} else if ("By Genre".equals(combobox1.getSelectionModel().getSelectedItem().toString())) {
				// Let the user to fill the blank.
				if (searchByGenre.getText().isEmpty() == b) {
					message.setTitle("Alert");
					message.setContentText("Please fill the blank.");
					message.showAndWait();
					searchByGenre.requestFocus();

				} else {
					searchTable.getItems().clear();
					searchTable.getItems().addAll(Book.searchByGenre(searchByGenre.getText()));
				}
			} else if ("By Location".equals(combobox1.getSelectionModel().getSelectedItem().toString())) {
				// Let the user to fill the blank.
				if (searchByLocation.getText().isEmpty() == b) {
					message.setTitle("Alert");
					message.setContentText("Please fill the blank.");
					message.showAndWait();
					searchByLocation.requestFocus();

				} else {
					searchTable.getItems().clear();
					searchTable.getItems().addAll(Book.searchByLocation(searchByLocation.getText()));
				}
			} else if ("By RowID".equals(combobox1.getSelectionModel().getSelectedItem().toString())) {
				// Let the user to fill the blank.
				if (searchByRowID.getText().isEmpty() == b || Book.isInteger(searchByRowID.getText()) == a) {
					message.setTitle("Alert");
					message.setContentText("Please fill integer values in the blank.");
					message.showAndWait();
					searchByRowID.requestFocus();

				} else {
					searchTable.getItems().clear();
					searchTable.getItems().addAll(Book.searchByRowID(Integer.parseInt(searchByRowID.getText())));
				}
			} else {
				searchTable.getItems().clear();
			}
		}

	}

	/**
	 * Set functions on the clear button.
	 * 
	 * @throws SQLException Throws errors if it exists.
	 */
	@FXML
	private void handleSearchClear() {
		// Hide and reset comboboxes, labels, and textboxes.
		Alert message7 = new Alert(AlertType.CONFIRMATION);
		Alert message8 = new Alert(AlertType.INFORMATION);

		// Confirm the user before reset.
		message7.setTitle("Notice");
		message7.setContentText(
				"Are you sure to reset?" + "\n\nIf you reset, all the inputs, selections, and the table will be reset."
						+ "\n\nPress Enter to reset or press Esc to cancel.");

		// Reset all fields.
		if (message7.showAndWait().get() == ButtonType.OK) {
			combobox1.setValue(combobox1.getPromptText());
			combobox2.setValue(combobox2.getPromptText());
			labelSearchByAny.setVisible(false);
			labelSearchByAuthor.setVisible(false);
			labelSearchByTitle.setVisible(false);
			labelSearchByGenre.setVisible(false);
			labelSearchByLocation.setVisible(false);
			labelSearchByRowID.setVisible(false);
			searchByAny.setVisible(false);
			searchByAuthor.setVisible(false);
			searchByTitle.setVisible(false);
			searchByGenre.setVisible(false);
			searchByLocation.setVisible(false);
			searchByRowID.setVisible(false);
			updateAuthor.setVisible(false);
			updateGenre.setVisible(false);
			updateLocation.setVisible(false);
			updateTitle.setVisible(false);
			labelUpdateAuthor.setVisible(false);
			labelUpdateGenre.setVisible(false);
			labelUpdateLocation.setVisible(false);
			labelUpdateTitle.setVisible(false);
			buttonSearch.setVisible(false);
			buttonUpdate.setVisible(false);
			buttonDelete.setVisible(false);
			searchByAny.setText("");
			searchByAuthor.setText("");
			searchByTitle.setText("");
			searchByGenre.setText("");
			searchByLocation.setText("");
			searchByRowID.setText("");
			updateAuthor.setText("");
			updateGenre.setText("");
			updateLocation.setText("");
			updateTitle.setText("");
			searchTable.getItems().clear();
			message8.setTitle("Alert");
			message8.setContentText("All fields has been reset.");
			message8.showAndWait();
		}
	}

	/**
	 * Set functions on the create button.
	 * 
	 * @throws SQLException Throws errors if it exists.
	 */
	@FXML
	private void handleCreate() throws SQLException {
		Book myBook = new Book();
		boolean b = true;

		Alert message = new Alert(AlertType.ERROR);
		Alert message5 = new Alert(AlertType.CONFIRMATION);
		Alert message6 = new Alert(AlertType.INFORMATION);

		// Throw error messages if user did not put inputs.
		if (updateAuthor.getText().isEmpty() || updateTitle.getText().isEmpty() || updateGenre.getText().isEmpty()
				|| updateLocation.getText().isEmpty() == b) {
			message.setTitle("Alert");
			message.setContentText("Please fill all (Author, title, genre, and location) blanks.");
			message.showAndWait();

		} else {
			// Confirm the user before creating an item.
			message5.setTitle("Notice");
			message5.setContentText("Are you sure creating the item?\n\nPress Enter to create or press Esc to cancel.");

			// Create the book if the user choose the ok button.
			if (message5.showAndWait().get() == ButtonType.OK) {
				myBook.setAuthor(updateAuthor.getText());
				myBook.setTitle(updateTitle.getText());
				myBook.setGenre(updateGenre.getText());
				myBook.setLocation(updateLocation.getText());
				myBook.create();
				searchTable.getItems().clear();
				searchTable.getItems().addAll(Book.searchByRowID(myBook.getRowID()));
				message6.setTitle("Alert");
				message6.setContentText("The item has been successfully created.");
				message6.showAndWait();
			}
		}
	}

	/**
	 * Set functions on the update button.
	 * 
	 * @throws SQLException Throws errors if it exists.
	 */
	@FXML
	private void handleUpdate() throws SQLException {
		Book myBook = new Book();
		boolean b = true;

		Alert message = new Alert(AlertType.ERROR);
		Alert message3 = new Alert(AlertType.CONFIRMATION);
		Alert message4 = new Alert(AlertType.INFORMATION);

		// Throw error messages if user did not put inputs.
		if (updateAuthor.getText().isEmpty() || updateTitle.getText().isEmpty() || updateGenre.getText().isEmpty()
				|| updateLocation.getText().isEmpty() == b) {
			message.setTitle("Alert");
			message.setContentText(
					"There is no item selected from the table below.\nPlease double-click a row you want to update.");
			message.showAndWait();

		} else {
			if (searchTable.getSelectionModel().isEmpty()) {
				message.setTitle("Alert");
				message.setContentText("There is no item selected from the table below."
						+ "\nPlease double-click a row you want to update.");
				message.showAndWait();
			} else {
				// Confirm the user before updating an item.
				message3.setTitle("Notice");
				message3.setContentText(
						"Are you sure updating the item?\n\nPress Enter to update or press Esc to cancel.");
				// Update the book if the user choose the ok button.
				if (message3.showAndWait().get() == ButtonType.OK) {
					myBook.setRowID(searchTable.getSelectionModel().getSelectedItem().getRowID());
					myBook.setAuthor(updateAuthor.getText());
					myBook.setTitle(updateTitle.getText());
					myBook.setGenre(updateGenre.getText());
					myBook.setLocation(updateLocation.getText());
					myBook.update();
					searchTable.getItems().clear();
					searchTable.getItems().addAll(Book.searchByRowID(myBook.getRowID()));
					updateAuthor.setText("");
					updateTitle.setText("");
					updateGenre.setText("");
					updateLocation.setText("");
					message4.setTitle("Alert");
					message4.setContentText("The item has been successfully updated.");
					message4.showAndWait();
				}
			}

		}

	}

	/**
	 * Set functions on the delete button.
	 * 
	 * @throws SQLException Throws errors if it exists.
	 */
	@FXML
	private void handleDelete() throws SQLException {
		Book myBook = new Book();
		boolean b = true;
		Alert message = new Alert(AlertType.ERROR);

		// Throw error messages if user did not put inputs.
		if (searchTable.getSelectionModel().isEmpty() == b) {
			message.setTitle("Alert");
			message.setContentText("Please select a row from the table below you want to delete.");
			message.showAndWait();

		} else {
			myBook.setRowID(searchTable.getSelectionModel().getSelectedItem().getRowID());

			// Confirm the user before deleting an item.
			Alert message1 = new Alert(AlertType.CONFIRMATION);
			Alert message2 = new Alert(AlertType.INFORMATION);
			message1.setTitle("Notice");
			message1.setContentText("Are you sure deleting the item?\n\nPress Enter to delete or press Esc to cancel.");

			// Delete the book if the user choose the ok button.
			if (message1.showAndWait().get() == ButtonType.OK) {
				myBook.delete();
				searchTable.getItems().clear();
				searchTable.getItems().addAll(Book.getAllBooklists());
				message2.setTitle("Alert");
				message2.setContentText("The item has been successfully deleted.");
				message2.showAndWait();
			}
		}

	}
}