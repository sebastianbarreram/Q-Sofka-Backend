package co.com.qsofkau.mongo.aspirante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AspiranteDocument {
    @Id
    private String id;
    private String nombre;
    private String correo;
    private Integer nivel;
    private Integer puntajePrueba1;
    private Integer puntajePrueba2;
    private String codigoVerificacion;
    private String evaluacionId;
}