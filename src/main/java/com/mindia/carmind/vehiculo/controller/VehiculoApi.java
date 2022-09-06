package com.mindia.carmind.vehiculo.controller;

import java.util.List;

import com.mindia.carmind.entities.Documento;
import com.mindia.carmind.evaluacion.pojo.LogEvaluacionView;
import com.mindia.carmind.evaluacion.pojo.view.EvaluacionView;
import com.mindia.carmind.vehiculo.manager.VehiculoManager;
import com.mindia.carmind.vehiculo.pojo.AltaPojo;
import com.mindia.carmind.vehiculo.pojo.AsignacionPojo;
import com.mindia.carmind.vehiculo.pojo.DocumentoView;
import com.mindia.carmind.vehiculo.pojo.LogUsoVehiculoView;
import com.mindia.carmind.vehiculo.pojo.ModificarPojo;
import com.mindia.carmind.vehiculo.pojo.VehiculoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class VehiculoApi {

    @Autowired
    VehiculoManager manager;

    @GetMapping("/vehiculo")
    public List<VehiculoView> getAllVehiculo() {
        return manager.getAllVehiculos();
    }

    @GetMapping("/vehiculo/{id}")
    public VehiculoView getVehiculo(@PathVariable String id) {
        return manager.obtenerVehiculoById(id);
    }

    @PostMapping("/vehiculo")
    public void altaVehiculo(@RequestBody AltaPojo pojo) {
        manager.altaVehiculo(pojo);
    }

    @PutMapping("/vehiculo")
    public void editarVehiculo(@RequestBody ModificarPojo pojo) {
        manager.modificarVehiculo(pojo);
    }

    @DeleteMapping("/vehiculo/{id}")
    public void borrarVehiculo(@PathVariable String id) {
        manager.bajaVehiculo(id);
    }

    @PostMapping("/vehiculo/{id}/asignarEvaluacion")
    public void asignarEvaluacion(@PathVariable String id, @RequestBody AsignacionPojo pojo) {
        manager.asignarEvaluacion(id, pojo);
    }

    @GetMapping("/vehiculo/{id}/check")
    public EvaluacionView check(@PathVariable int id) {
        return manager.checkVehiculo(id);
    }

    @GetMapping("/vehiculo/{id}/iniciarUso")
    public void iniciaruso(@PathVariable int id) {
        manager.iniciarUso(id, null);
    }

    @GetMapping("/vehiculo/{id}/terminarUso")
    public void terminarUso(@PathVariable int id) {
        manager.terminarUso(id,null);
    }

    @GetMapping("/vehiculo/{id}/documentos")
    public List<DocumentoView> getDocumentosOfVehiculo(@PathVariable Integer id) {
        return manager.obtenerDocumentos(id);
    }

    @PostMapping("/vehiculo/{id}/{tipo}/upload")
    public void subirDocumentacion(@PathVariable int id, @RequestParam("file") MultipartFile file, @RequestParam("vencimiento") String vencimiento, @PathVariable("tipo") String tipo){
        manager.subirDocumentacion(id, file, tipo, vencimiento);
    }

    @GetMapping("/vehiculo/{id}/documento/{tipo}")
    public ResponseEntity<byte[]> getDocumentacionVehiculo(@PathVariable int id, @PathVariable String tipo){
        Documento doc = manager.getDocumentacionVehiculo(id, tipo);


        return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + doc.getId() + "."+ doc.getFormato()+"\"")
        .header(HttpHeaders.CONTENT_TYPE, doc.getContentType())
        .body(doc.getData());
    }

    @GetMapping("/vehiculo/current")
    public VehiculoView getVehiculoEnUso() {
        return manager.getCurrentVehiculo();
    }

    @GetMapping("vehiculo/{id}/formularios")
    public List<EvaluacionView> getFormularios(@PathVariable Integer id) {
        return manager.obtenerFormularios(id);
    }

    @GetMapping("vehiculo/{id}/formularios/historial")
    public List<LogEvaluacionView> getLogsFormularios(@PathVariable Integer id) {
        return manager.obtenerLogsFormularios(id);
    }

    @GetMapping("vehiculo/{id}/historial/vehiculosUsados")
    public List<LogUsoVehiculoView> getLogsVehiculosUsados(@PathVariable Integer id) {
        return manager.obtenerLogsVehiculosUsados(id);
    }
}
