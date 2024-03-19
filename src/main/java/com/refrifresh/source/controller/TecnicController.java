package com.refrifresh.source.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.refrifresh.source.entity.Tecnic;
import com.refrifresh.source.service.TecnicService;

@RestController
@RequestMapping("/tecnic")
public class TecnicController {
	
	private final TecnicService serviceTecnic;
	
	public TecnicController (TecnicService serviceTecnic) {
		this.serviceTecnic = serviceTecnic;
	}
	
	@GetMapping("/list-tecnic")
	public ResponseEntity<List<Tecnic>> getTecnic(){
		return new ResponseEntity<>(serviceTecnic.getTecnic(), HttpStatus.OK);
	}
	
	@GetMapping("/list-active")
	public ResponseEntity<List<Tecnic>> getActive(){
		return new ResponseEntity<>(serviceTecnic.getActive(), HttpStatus.OK);
	}
	
	@GetMapping("/list-inactive")
	public ResponseEntity<List<Tecnic>> getInactive(){
		return new ResponseEntity<>(serviceTecnic.getInactive(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{idTecnic}")
	public ResponseEntity<Tecnic> findByIdTecnic(@PathVariable("idTecnic") int idTecnic) {
	    if (idTecnic > 0) {
	       	Tecnic t = serviceTecnic.findByIdTecnic(idTecnic);
	        if (t != null) {
	            return new ResponseEntity<>(t, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } else {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Tecnic> save(@RequestBody Tecnic tecnic) {
		tecnic.setActTecnico("Activo");
	    return new ResponseEntity<>(serviceTecnic.save(tecnic), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Tecnic> update(@PathVariable("id") int id, @RequestBody Tecnic update) {
		try {
			Tecnic exist = serviceTecnic.findByIdTecnic(id);
			if(exist!=null){
				exist.setTecTecnico(update.getTecTecnico());
				Tecnic updateAfter = serviceTecnic.update(exist);
				return new ResponseEntity<>(updateAfter, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(update, HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(update, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*@PostMapping("/save")
	public ResponseEntity<Tecnic> save(@RequestBody Tecnic tecnic, @RequestParam("firmaTecnico") MultipartFile imagen){
	    if (imagen != null && !imagen.isEmpty()) {
	        Path directorioImagenes = Paths.get("src//main//resources//static/firma");
	        String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

	        try {
	            byte[] bytesImg = imagen.getBytes();
	            Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
	            Files.write(rutaCompleta, bytesImg);
	            tecnic.setFirmaTecnico(imagen.getOriginalFilename());
	        } catch (IOException e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    } else {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    tecnic.setActTecnico("Activo");
	    return new ResponseEntity<>(serviceTecnic.save(tecnic), HttpStatus.CREATED);
	}*/
	
    /*@PostMapping("/save")
    public ResponseEntity<Tecnic> save(@RequestParam("tecTecnico") String tecTecnico,
                                       @RequestParam("firmaTecnico") MultipartFile firmaTecnico) {
        if (firmaTecnico != null && !firmaTecnico.isEmpty()) {
            Path directorioImagenes = Paths.get("src//main//resources//static/firma");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = firmaTecnico.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + firmaTecnico.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                
                Tecnic tecnic = new Tecnic();
                tecnic.setTecTecnico(tecTecnico);
                tecnic.setFirmaTecnico(firmaTecnico.getOriginalFilename());
                tecnic.setActTecnico("Activo");

                return new ResponseEntity<>(serviceTecnic.save(tecnic), HttpStatus.CREATED);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/
	
	/*@PutMapping("/update/{id}")
	public ResponseEntity<Tecnic> update(@PathVariable("id") int id, @RequestBody Tecnic update){
		try {
			Tecnic exist = serviceTecnic.findByIdTecnic(id);
			if(exist!=null) {
				exist.setTecTecnico(update.getTecTecnico());
				exist.setFirmaTecnico(update.getFirmaTecnico());
				Tecnic updateAfter = serviceTecnic.update(exist);
				return new ResponseEntity<>(updateAfter, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(update, HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(update, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
    
    /*@PutMapping("/update/{id}")
    public ResponseEntity<Tecnic> update(@PathVariable("id") int id, @RequestParam("tecTecnico") String tecTecnico, @RequestParam("firmaTecnico") MultipartFile firmaTecnico) {
        if (firmaTecnico != null && !firmaTecnico.isEmpty()) {
            try {
                Tecnic exist = serviceTecnic.findByIdTecnic(id);
                if (exist != null) {
                    Path directorioImagenes = Paths.get("src//main//resources//static/firma");
                    String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

                    byte[] bytesImg = firmaTecnico.getBytes();
                    Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + firmaTecnico.getOriginalFilename());
                    Files.write(rutaCompleta, bytesImg);

                    exist.setTecTecnico(tecTecnico);
                    exist.setFirmaTecnico(firmaTecnico.getOriginalFilename());
                    Tecnic updateAfter = serviceTecnic.update(exist);
                    return new ResponseEntity<>(updateAfter, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/

	
	@DeleteMapping("/delete-soft/{id}")
	public ResponseEntity<List<Tecnic>> deleteSoft(@PathVariable int id){
		try {
			Tecnic tecnic = serviceTecnic.findByIdTecnic(id);
			if(tecnic!=null){
				tecnic.setActTecnico("Inactivo");
				serviceTecnic.update(tecnic);
				List<Tecnic> active = serviceTecnic.getActive();
				return new ResponseEntity<>(active, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete-hard/{id}")
	public ResponseEntity<List<Tecnic>> deleteHard(@PathVariable int id){
		try {
			Tecnic tecnic = serviceTecnic.findByIdTecnic(id);
			if(tecnic!=null){
				serviceTecnic.delete(tecnic);
				List<Tecnic> active = serviceTecnic.getActive();
				return new ResponseEntity<>(active, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
