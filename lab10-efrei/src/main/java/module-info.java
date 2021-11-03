module cz.jezek.lab10 {
    requires transitive javafx.controls;
    requires javafx.fxml;
    opens cz.jezek.lab11 to javafx.fxml;
    exports cz.jezek.lab11;
}