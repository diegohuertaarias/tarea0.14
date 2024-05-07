module com.empresa.tarea014 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.empresa.tarea014 to javafx.fxml;
    exports com.empresa.tarea014;
}