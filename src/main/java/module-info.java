module gal.pazodamerce {
    requires javafx.controls;
    requires javafx.fxml;

    opens gal.pazodamerce to javafx.fxml;
    exports gal.pazodamerce;
}
